package com.theironyard.controllers;

import com.theironyard.entities.Recipe;
import com.theironyard.services.GuildWarsApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipeController {

    @Autowired
    GuildWarsApiService guildWars;

    @RequestMapping(path = "/recipes/{id}", method = RequestMethod.GET)
    public String getRecipe(Model model, @PathVariable String id){
        Recipe recipe = guildWars.getRecipeById(id);
        model.addAttribute("recipe", recipe);

        return "home";
    }
}
