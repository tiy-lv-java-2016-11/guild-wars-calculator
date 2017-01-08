package com.theironyard.services;

import com.theironyard.entities.Item;
import com.theironyard.entities.Price;
import com.theironyard.entities.Recipe;
import com.theironyard.repositories.ItemRepository;
import com.theironyard.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class GuildWarsApiService {
    public static final String RECIPES_URL = "https://api.guildwars2.com/v2/recipes/";
    public static final String ITEMS_URL = "https://api.guildwars2.com/v2/items/";
    public static final String PRICES_URL = "https://api.guildwars2.com/v2/commerce/prices/";
    public static final String INGREDIENT_ITEM_ID = "item_id";
    public static final String INGREDIENT_COUNT = "count";
    public static final String ITEM_UNIT_PRICE = "unit_price";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    ItemRepository itemRepository;

    public GuildWarsApiService() {
    }

    public Recipe getRecipeById(String id){
        Recipe recipe;

        if (recipeRepository.exists(Integer.valueOf(id))){
            recipe = recipeRepository.findOne(Integer.valueOf(id));
            recipe.setOutputItem(downloadItem(recipe.getOutputItemId()));
        }
        else {
            recipe = downloadRecipe(id);
            recipeRepository.save(recipe);
        }
        loadIngredientItems(recipe);
        setCurrentPrices(recipe);
        return recipe;
    }

    public Recipe downloadRecipe(String id){
        Recipe recipe = restTemplate.getForObject(RECIPES_URL + id, Recipe.class);
        recipe.setOutputItem(downloadItem(recipe.getOutputItemId()));
        return recipe;
    }

    public Item downloadItem(int id){
        return restTemplate.getForObject(ITEMS_URL + id, Item.class);
    }

    public void loadIngredientItems(Recipe recipe){

        for (HashMap ingredient : recipe.getIngredientCounts()){
            Item item;
            Integer id = (Integer) ingredient.get(INGREDIENT_ITEM_ID);
            Integer count = (Integer) ingredient.get(INGREDIENT_COUNT);

            if (itemRepository.exists(id)){
                item = itemRepository.findOne(id);
            }
            else {
                item = downloadItem(id);
                itemRepository.save(item);
            }
            item.setCount(count);
            recipe.getIngredientItems().add(item);
        }
    }

    public void setCurrentPrices(Recipe recipe){
        Integer sellPrice = getCurrentPrice(recipe.getOutputItemId());
        recipe.setSellPrice(sellPrice);
        Integer buyPrice = 0;
        for (Item item : recipe.getIngredientItems()){
            item.setPrice(getCurrentPrice(item.getId()));
            item.setTotalPrice(item.getCount()*item.getPrice());
            buyPrice += item.getTotalPrice();
        }
        recipe.setBuyPrice(buyPrice);
        recipe.setPriceDifference(sellPrice - buyPrice);
    }

    public int getCurrentPrice(Integer id){
        Price price = restTemplate.getForObject(PRICES_URL + id, Price.class);
        return price.getBuys().get(ITEM_UNIT_PRICE);
    }
}
