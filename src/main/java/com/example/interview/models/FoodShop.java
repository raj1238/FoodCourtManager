package com.example.interview.models;

import lombok.Data;

import java.util.List;

@Data
public class FoodShop {

    private int shopNo;
    private String name;
    private Vendor vendor;
    private List<Cuisine> cuisineList;

    public FoodShop(int shopNo,String name, Vendor vendor, List<Cuisine> cuisineList) {
        this.shopNo = shopNo;
        this.name = name;
        this.vendor = vendor;
        this.cuisineList = cuisineList;
    }

}
