package com.GuildWarsApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by darionmoore on 1/6/17.
 */
@Controller
public class RecipeController {
    public static final String BASE_URL = "https://api.guildwars2.com/v2/";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(path = "/recipes/{recipeId}", method = RequestMethod.GET)
    public String getRecipe(Model model, @PathVariable Integer recipeId){
        GuildRecipe recipe = restTemplate.getForObject(BASE_URL + "/recipes/" + recipeId, GuildRecipe.class);
        model.addAttribute("recipe", recipe);
        return "Home";
    }

//    @RequestMapping(path = "/items/{outputItemId}", method = RequestMethod.GET)
//    public String getName(Model model, @PathVariable Integer outputItemId){
//        GuildRecipe itemName = restTemplate.getForObject(BASE_URL + "/items/" + outputItemId , GuildRecipe.class);
//        model.addAttribute("itemName", itemName);
//
//        return "Home";
//    }

//    @RequestMapping(path = "/commerce/prices/{ingredientId}", method = RequestMethod.GET)
//    public String getPrice(Model model, @PathVariable Integer ingredientId){
//        GuildRecipe price = restTemplate.getForObject(BASE_URL + "/items/" + ingredientId, GuildRecipe.class);
//        model.addAttribute("price", price);
//
//
//        return "Home";
//    }

}
