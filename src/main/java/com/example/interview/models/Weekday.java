package com.example.interview.models;

import lombok.Getter;

@Getter
public enum Weekday {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    private long totalSaleAmount;
    private long totalOrders;

    public void addTotalSaleAmount(long totalSaleAmount){
        this.totalSaleAmount += totalSaleAmount;
    }

    public void addTotalOrders(long totalOrders){
        this.totalOrders += totalOrders;
    }
    public static Weekday fromValue(String day){
        for (Weekday value : Weekday.values()) {
            if(value.toString().equals(day))
                return value;
        }
        return null;
    }
}
