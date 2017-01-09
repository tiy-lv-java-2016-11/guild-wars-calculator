package com.GuildWarsApi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by darionmoore on 1/8/17.
 */
public class Ingredient {
    @JsonProperty("id")
    private int itemId;
    @JsonProperty("quantity")
    private int count;
    @JsonProperty("unit_price")
    private int itemPrice;

    public Ingredient(int itemId, int count, int itemPrice) {
        this.itemId = itemId;
        this.count = count;
        this.itemPrice = itemPrice;

    }

    public Ingredient() {
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }


}

