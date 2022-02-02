package com.example.interview;

import com.example.interview.controller.FoodCourtManager;
import com.example.interview.models.Cuisine;
import com.example.interview.models.Vendor;
import com.example.interview.models.Weekday;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

/*
A food court manager wants insights towards the meals sold based on certain requirements.
Design a system that can handle the below requirements:

The food court has different shops and each shop is assigned to a vendor. The vendor can sell food of different cuisines. Each of the food stalls have separated billing systems that will be linked to the new system to be designed.

Top n cuisines for the food court. (by number of orders/by amount of sales)
Top n vendors for the food court. (by number of orders/by amount of sales)
Peak Sales day for the week

 */
@SpringBootApplication
public class MachineCodingApplication {

	public static void main(String[] args) {

		SpringApplication.run(MachineCodingApplication.class, args);

		FoodCourtManager foodCourtManager = new FoodCourtManager();

		foodCourtManager.createAndAddVendor("vendor1");
		foodCourtManager.createAndAddVendor("vendor2");
		foodCourtManager.createAndAddVendor("vendor3");

		List<String> cuisinies = new ArrayList<>();
		cuisinies.add("MEXICAN");
		foodCourtManager.createAndAddFoodShop("foodShop1", cuisinies,1);
		cuisinies.add("ITALIAN");
		foodCourtManager.createAndAddFoodShop("foodShop2", cuisinies,2);
		cuisinies.remove("MEXICAN");
		foodCourtManager.createAndAddFoodShop("foodShop3", cuisinies,3);

		foodCourtManager.addOrderData(100,"MONDAY",1,"MEXICAN");
		foodCourtManager.addOrderData(10,"TUESDAY",2,"MEXICAN");
		foodCourtManager.addOrderData(70,"MONDAY",2,"MEXICAN");
		foodCourtManager.addOrderData(50,"MONDAY",2,"ITALIAN");
		foodCourtManager.addOrderData(500,"MONDAY",3,"ITALIAN");
		foodCourtManager.addOrderData(800,"TUESDAY",3,"ITALIAN");

		Vendor vendor = foodCourtManager.findTopVendor("TOTAL_SALES");
		System.out.println("Highest SOLD : " +vendor.toString());

		foodCourtManager.addOrderData(8000,"TUESDAY",2,"MEXICAN");
		vendor = foodCourtManager.findTopVendor("TOTAL_SALES");
		System.out.println("Highest SOLD : " + vendor.toString());

		foodCourtManager.addOrderData(9100,"WEDNESDAY",1,"MEXICAN");
		vendor = foodCourtManager.findTopVendor("TOTAL_SALES");
		System.out.println("Highest SOLD : " + vendor.toString());

		foodCourtManager.addOrderData(8000,"WEDNESDAY",3,"ITALIAN");
		vendor = foodCourtManager.findTopVendor("TOTAL_ORDERS");
		System.out.println("Highest Ordered : " + vendor.toString());

		foodCourtManager.addOrderData(10000,"WEDNESDAY",3,"ITALIAN");
		Cuisine cuisine = foodCourtManager.findTopCuisine("TOTAL_SALES");
		System.out.println("Highest SOLD : " + cuisine.toString());

		cuisine = foodCourtManager.findTopCuisine("TOTAL_ORDERS");
		System.out.println("Highest Ordered : " +cuisine.toString());

		Weekday weekday = foodCourtManager.findTopWeekday("TOTAL_SALES");
		System.out.println("Highest SOLD : " +weekday.toString());

		weekday = foodCourtManager.findTopWeekday("TOTAL_ORDERS");
		System.out.println("Highest Ordered : " +weekday.toString());
	}

}
