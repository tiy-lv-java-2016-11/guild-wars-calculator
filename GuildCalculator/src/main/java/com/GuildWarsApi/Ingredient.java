package com.GuildWarsApi;

/**
 * Created by darionmoore on 1/8/17.
 */
public class Ingredient {
    private int itemId;
    private int count;

    public Ingredient(int itemId, int count) {
        this.itemId = itemId;
        this.count = count;
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
}

