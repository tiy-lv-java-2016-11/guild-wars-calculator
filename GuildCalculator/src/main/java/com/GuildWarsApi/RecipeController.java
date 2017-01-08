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
    public static final String BASE_URL = "https://api.guildwars2.com/";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(path = "/v2/recipes/{recipeId}", method = RequestMethod.GET)
    public String getRecipe(Model model, @PathVariable Integer recipeId){
        GuildRecipe recipe = restTemplate.getForObject(BASE_URL + recipeId, GuildRecipe.class);
        model.addAttribute("recipe", recipe);

        return "Home";
    }

}
