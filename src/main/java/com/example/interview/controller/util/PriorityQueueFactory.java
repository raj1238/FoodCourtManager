package com.example.interview.controller.util;

import com.example.interview.models.Cuisine;
import com.example.interview.models.Vendor;
import com.example.interview.models.Weekday;
import com.example.interview.service.DataMetricsService;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class PriorityQueueFactory {

    public PriorityQueue<?> fetchVendorPriorityQueue(Class clazz,PerformanceMetric metric){
        if(clazz.equals(Vendor.class)){
            if(metric.equals(PerformanceMetric.TOTAL_SALES))
                return DataMetricsService.getVendorPriorityQueueSales();
            if(metric.equals(PerformanceMetric.TOTAL_ORDERS))
                return DataMetricsService.getVendorPriorityQueueOrders();
        }
        else if(clazz.equals(Cuisine.class)){
            if(metric.equals(PerformanceMetric.TOTAL_SALES))
                return DataMetricsService.getCuisinePriorityQueueSales();
            if(metric.equals(PerformanceMetric.TOTAL_ORDERS))
                return DataMetricsService.getCuisinePriorityQueueOrders();
        }
        else if(clazz.equals(Weekday.class)){
            if(metric.equals(PerformanceMetric.TOTAL_SALES))
                return DataMetricsService.getWeekdayPriorityQueueSales();
            if(metric.equals(PerformanceMetric.TOTAL_ORDERS))
                return DataMetricsService.getWeekdayPriorityQueueOrders();
        }
        throw new RuntimeException("Wrong metric or Clazz passed");
    }
}
