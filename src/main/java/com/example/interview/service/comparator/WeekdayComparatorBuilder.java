package com.example.interview.service.comparator;

import com.example.interview.models.Weekday;

import java.util.Comparator;

public class WeekdayComparatorBuilder {

    public static Comparator<Weekday> buildSalesComparator(){
        return new Comparator<Weekday>() {
            @Override
            public int compare(Weekday a, Weekday b) {
                if (a.getTotalSaleAmount() < b.getTotalSaleAmount())
                    return 1;
                if (a.getTotalSaleAmount() > b.getTotalSaleAmount())
                    return -1;
                return 0;
            }
        };
    }

    public static Comparator<Weekday> buildOrderComparator(){
        return new Comparator<Weekday>() {
            @Override
            public int compare(Weekday a, Weekday b) {
                if (a.getTotalOrders() < b.getTotalOrders())
                    return 1;
                if (a.getTotalOrders() > b.getTotalOrders())
                    return -1;
                return 0;
            }
        };
    }
}
