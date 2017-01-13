package com.theironyard.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    @JsonProperty("type")
    private String recipeType;

    @Column(nullable = false)
    @JsonProperty("output_item_id")
    private Integer outputItemId;

    @Transient
    private Item outputItem;

    @ElementCollection
    @JsonProperty("ingredients")
//    private String ingredientCounts;
    private List<HashMap<String, Integer>> ingredientCounts = new ArrayList<>();

    @Transient
    private List<Item> ingredientItems = new ArrayList<>();

    @Transient
    private Integer buyPrice;
    @Transient
    private Integer sellPrice;
    @Transient
    private Integer priceDifference;





    public Recipe() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(String recipeType) {
        this.recipeType = recipeType;
    }

    public Integer getOutputItemId() {
        return outputItemId;
    }

    public void setOutputItemId(Integer outputItemId) {
        this.outputItemId = outputItemId;
    }

    public Item getOutputItem() {
        return outputItem;
    }

    public void setOutputItem(Item outputItem) {
        this.outputItem = outputItem;
    }

    public List<HashMap<String, Integer>>  getIngredientCounts() {
        return ingredientCounts;
    }

//    public void setIngredientCounts(List<HashMap<String, Integer>> ingredientCounts) {
//        this.ingredientCounts = ingredientCounts;
//    }

    public List<Item> getIngredientItems() {
        return ingredientItems;
    }

    public void setIngredientItems(List<Item> ingredientItems) {
        this.ingredientItems = ingredientItems;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getPriceDifference() {
        return priceDifference;
    }

    public void setPriceDifference(Integer priceDifference) {
        this.priceDifference = priceDifference;
    }
}
