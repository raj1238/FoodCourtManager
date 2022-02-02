package com.example.interview.controller;

import com.example.interview.controller.performance.CuisinePerformanceCalculator;
import com.example.interview.controller.performance.VendorPerformanceCalculator;
import com.example.interview.controller.performance.WeekdayPerformanceCalculator;
import com.example.interview.controller.util.PerformanceMetric;
import com.example.interview.models.*;
import com.example.interview.service.dao.FoodShopDAOService;
import com.example.interview.service.DataMetricsService;
import com.example.interview.service.dao.VendorDAOService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.example.interview.models.Cuisine.fromValue;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class FoodCourtManager {

    private FoodShopDAOService foodShopDAOService = new FoodShopDAOService();
    private VendorDAOService vendorDAOService = new VendorDAOService();

    private DataMetricsService dataMetricsService = new DataMetricsService();

    private VendorPerformanceCalculator vendorPerformanceCalculator = new VendorPerformanceCalculator();
    private CuisinePerformanceCalculator cuisinePerformanceCalculator = new CuisinePerformanceCalculator();
    private WeekdayPerformanceCalculator weekdayPerformanceCalculator = new WeekdayPerformanceCalculator();

    public void createAndAddFoodShop(String name,List<String> cuisines, int vendorNo){
        Vendor vendor = vendorDAOService.findVendorFromNumber(vendorNo);
        if(isNull(vendor)){
            throw new RuntimeException("No vendor with the number");
        }
        List<Cuisine> cuisineList = new ArrayList<>();
        for (String cuisine : cuisines) {
            if(nonNull(fromValue(cuisine)))
                cuisineList.add(fromValue(cuisine));
        }
        foodShopDAOService.createNewFoodShop(name,vendor,cuisineList);
    }

    public void createAndAddVendor(String name){
       vendorDAOService.createNewVendor(name);
    }

    public Collection<FoodShop> fetchAllFoodShops(){
        return foodShopDAOService.fetchAllFoodShops();
    }

    public Collection<Vendor> fetchAllVendors(){
        return vendorDAOService.fetchAllVendors();
    }

    public void addOrderData(long totalSaleAmount, String day, int vendorNo, String cuisineString){
        Weekday weekday = Weekday.fromValue(day);
        if(isNull(weekday)){
            throw new RuntimeException("Weekday Invalid");
        }
        Vendor vendor = vendorDAOService.findVendorFromNumber(vendorNo);
        if(isNull(vendor)){
            throw new RuntimeException("No Vendor with this number");
        }
        Cuisine cuisine = Cuisine.fromValue(cuisineString);
        if(isNull(cuisine)){
            throw new RuntimeException("Cuisine Invalid");
        }
        FoodShop foodShop = foodShopDAOService.findFoodShopFromVendor(vendor);
        if(isNull(foodShop) || !foodShop.getCuisineList().contains(cuisine)){
            throw new RuntimeException("No Foodshop found or Foodshop doesn't offer this cuisine");
        }
        dataMetricsService.addOrderData(totalSaleAmount,weekday,cuisine,vendor);
    }

    public Vendor findTopVendor(String metricString){
        PerformanceMetric metric = PerformanceMetric.fromValue(metricString);
        if(isNull(metric)){
            throw new RuntimeException("Invalid Metric Passed");
        }
        return vendorPerformanceCalculator.findTopPerformer(metric);
    }

    public Cuisine findTopCuisine(String metricString){
        PerformanceMetric metric = PerformanceMetric.fromValue(metricString);
        if(isNull(metric)){
            throw new RuntimeException("Invalid Metric Passed");
        }
        return cuisinePerformanceCalculator.findTopPerformer(metric);
    }

    public Weekday findTopWeekday(String metricString){
        PerformanceMetric metric = PerformanceMetric.fromValue(metricString);
        if(isNull(metric)){
            throw new RuntimeException("Invalid Metric Passed");
        }
        return weekdayPerformanceCalculator.findTopPerformer(metric);
    }

}
