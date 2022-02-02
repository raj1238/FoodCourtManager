package com.example.interview.service.comparator;

import com.example.interview.models.Vendor;

import java.util.Comparator;

public class VendorComparatorBuilder {

    public static Comparator<Vendor> buildSalesComparator(){
        return new Comparator<Vendor>() {
            @Override
            public int compare(Vendor a, Vendor b) {
                if (a.getTotalSaleAmount() < b.getTotalSaleAmount())
                    return 1;
                if (a.getTotalSaleAmount() > b.getTotalSaleAmount())
                    return -1;
                return 0;
            }
        };
    }

    public static Comparator<Vendor> buildOrderComparator(){
        return new Comparator<Vendor>() {
            @Override
            public int compare(Vendor a, Vendor b) {
                if (a.getTotalOrders() < b.getTotalOrders())
                    return 1;
                if (a.getTotalOrders() > b.getTotalOrders())
                    return -1;
                return 0;
            }
        };
    }
}
