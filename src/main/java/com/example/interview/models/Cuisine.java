package com.example.interview.models;

import lombok.Getter;

@Getter
public enum Cuisine {

    MEXICAN,
    NORTH_INDIAN,
    ITALIAN,
    SOUTH_INDIAN,
    MUGHLAI;

    private long totalSaleAmount;
    private long totalOrders;

    public static Cuisine fromValue(String cuisine){
        for (Cuisine value : Cuisine.values()) {
            if(value.toString().equals(cuisine))
                return value;
        }
        return null;
    }

    public void addTotalSaleAmount(long totalSaleAmount){
        this.totalSaleAmount += totalSaleAmount;
    }

    public void addTotalOrders(long totalOrders){
        this.totalOrders += totalOrders;
    }
}
