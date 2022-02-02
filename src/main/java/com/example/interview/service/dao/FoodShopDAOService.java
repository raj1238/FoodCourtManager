package com.example.interview.service.dao;

import com.example.interview.models.Cuisine;
import com.example.interview.models.FoodShop;
import com.example.interview.models.Vendor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodShopDAOService {

    private Map<Integer,FoodShop> foodShopMap = new HashMap<>();
    private static int foodShopNo = 0;

    public void createNewFoodShop(String name, Vendor vendor, List<Cuisine> cuisineList){
        foodShopNo++;
        if(!validateVendorNotAssigned(vendor)){
            throw new RuntimeException("Vendor Already Assigned to a FoodShop");
        }
        FoodShop foodShop = new FoodShop(foodShopNo,name,vendor,cuisineList);
        foodShopMap.put(foodShopNo,foodShop);
    }

    public Collection<FoodShop> fetchAllFoodShops(){
        return foodShopMap.values();
    }

    public FoodShop findFoodShopFromNumber(int no){
        for (FoodShop value : foodShopMap.values()) {
            if(value.getShopNo()==no)
                return value;
        }
        return null;
    }

    public FoodShop findFoodShopFromVendor(Vendor vendor){
        for (FoodShop value : foodShopMap.values()) {
            if(value.getVendor()==vendor)
                return value;
        }
        return null;
    }

    private boolean validateVendorNotAssigned(Vendor vendor){
        for (FoodShop foodShop : foodShopMap.values()) {
            if(foodShop.getVendor().equals(vendor))
                return false;
        }
        return true;
    }
}
