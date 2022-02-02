package com.example.interview.models;

import lombok.Data;

@Data
public class Vendor {

    private int vendorNo;
    private String vendorName;
    private long totalSaleAmount;
    private long totalOrders;

    public Vendor(int vendorNo, String vendorName) {
        this.vendorNo = vendorNo;
        this.vendorName = vendorName;
    }

    public void addTotalSaleAmount(long totalSaleAmount){
        this.totalSaleAmount += totalSaleAmount;
    }

    public void addTotalOrders(long totalOrders){
        this.totalOrders += totalOrders;
    }
}
