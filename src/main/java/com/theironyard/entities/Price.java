package com.theironyard.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Price {
    private Integer id;
    private Map<String, Integer> buys;
    @JsonProperty("buys:unit_price")
    private Integer price;

    public Price() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<String, Integer> getBuys() {
        return buys;
    }

    public void setBuys(Map<String, Integer> buys) {
        this.buys = buys;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
