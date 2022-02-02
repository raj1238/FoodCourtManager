package com.example.interview.service.comparator;

import com.example.interview.models.Cuisine;
import com.example.interview.models.Vendor;

import java.util.Comparator;

public class CuisineComparatorBuilder {

    public static Comparator<Cuisine> buildSalesComparator(){
        return new Comparator<Cuisine>() {
            @Override
            public int compare(Cuisine a, Cuisine b) {
                if (a.getTotalSaleAmount() < b.getTotalSaleAmount())
                    return 1;
                if (a.getTotalSaleAmount() > b.getTotalSaleAmount())
                    return -1;
                return 0;
            }
        };
    }

    public static Comparator<Cuisine> buildOrderComparator(){
        return new Comparator<Cuisine>() {
            @Override
            public int compare(Cuisine a, Cuisine b) {
                if (a.getTotalOrders() < b.getTotalOrders())
                    return 1;
                if (a.getTotalOrders() > b.getTotalOrders())
                    return -1;
                return 0;
            }
        };
    }
}
