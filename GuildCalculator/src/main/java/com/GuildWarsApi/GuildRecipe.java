package com.GuildWarsApi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by darionmoore on 1/6/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GuildRecipe {

    private int id;
    private String type;
    @JsonProperty("ingredients")
    private ArrayList<Ingredient> ingredients;
    @JsonProperty("output_item_id")
    private int outputItem;

    public GuildRecipe(int id, String type, ArrayList<Ingredient> ingredients, int outputItem) {
        this.id = id;
        this.type = type;
        this.ingredients = ingredients;
        this.outputItem = outputItem;
    }

    public GuildRecipe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
