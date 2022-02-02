package com.example.interview.service;

import com.example.interview.models.Cuisine;
import com.example.interview.models.Vendor;
import com.example.interview.models.Weekday;
import com.example.interview.service.comparator.CuisineComparatorBuilder;
import com.example.interview.service.comparator.VendorComparatorBuilder;
import com.example.interview.service.comparator.WeekdayComparatorBuilder;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class DataMetricsService {

    private static PriorityQueue<Cuisine> cuisinePriorityQueueSales =
            new PriorityQueue<>(CuisineComparatorBuilder.buildSalesComparator());
    private static PriorityQueue<Vendor> vendorPriorityQueueSales =
            new PriorityQueue<>(VendorComparatorBuilder.buildSalesComparator());
    private static PriorityQueue<Weekday> weekdayPriorityQueueSales =
            new PriorityQueue<>(WeekdayComparatorBuilder.buildSalesComparator());

    private static PriorityQueue<Cuisine> cuisinePriorityQueueOrders =
            new PriorityQueue<>(CuisineComparatorBuilder.buildOrderComparator());
    private static PriorityQueue<Vendor> vendorPriorityQueueOrders =
            new PriorityQueue<>(VendorComparatorBuilder.buildOrderComparator());
    private static PriorityQueue<Weekday> weekdayPriorityQueueOrders =
            new PriorityQueue<>(WeekdayComparatorBuilder.buildOrderComparator());

    public void addOrderData(long totalSaleAmount, Weekday weekday, Cuisine cuisine, Vendor vendor){
        weekday.addTotalOrders(1);
        weekday.addTotalSaleAmount(totalSaleAmount);
        cuisine.addTotalOrders(1);
        cuisine.addTotalSaleAmount(totalSaleAmount);
        vendor.addTotalOrders(1);
        vendor.addTotalSaleAmount(totalSaleAmount);

        cuisinePriorityQueueSales.removeIf(c->c.equals(cuisine));
        cuisinePriorityQueueSales.add(cuisine);

        cuisinePriorityQueueOrders.removeIf(c->c.equals(cuisine));
        cuisinePriorityQueueOrders.add(cuisine);

        vendorPriorityQueueSales.removeIf(v->v.equals(vendor));
        vendorPriorityQueueSales.add(vendor);

        vendorPriorityQueueOrders.removeIf(v->v.equals(vendor));
        vendorPriorityQueueOrders.add(vendor);

        weekdayPriorityQueueSales.removeIf(w->w.equals(weekday));
        weekdayPriorityQueueSales.add(weekday);

        weekdayPriorityQueueOrders.removeIf(w->w.equals(weekday));
        weekdayPriorityQueueOrders.add(weekday);
    }

    public static PriorityQueue<Vendor> getVendorPriorityQueueSales(){
        return vendorPriorityQueueSales;
    }

    public static PriorityQueue<Vendor> getVendorPriorityQueueOrders(){
        return vendorPriorityQueueOrders;
    }

    public static PriorityQueue<Cuisine> getCuisinePriorityQueueSales(){
        return cuisinePriorityQueueSales;
    }

    public static PriorityQueue<Cuisine> getCuisinePriorityQueueOrders(){
        return cuisinePriorityQueueOrders;
    }

    public static PriorityQueue<Weekday> getWeekdayPriorityQueueSales(){
        return weekdayPriorityQueueSales;
    }

    public static PriorityQueue<Weekday> getWeekdayPriorityQueueOrders(){
        return weekdayPriorityQueueOrders;
    }
}
