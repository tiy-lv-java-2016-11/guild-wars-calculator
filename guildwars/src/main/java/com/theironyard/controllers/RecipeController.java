package com.theironyard.controllers;

import com.theironyard.entities.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sparatan117 on 1/9/17.
 */
@Controller
public class RecipeController {
    public static final String BASE_URL = "https://api.guildwars2.com/v2/recipes/";


    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(path = "/recipes/{id)", method = RequestMethod.GET)
    public String getItem(Model model, @PathVariable Integer id){
        Recipe recipe = restTemplate.getForObject(BASE_URL + id, Recipe.class);

        return "home";
    }
}
