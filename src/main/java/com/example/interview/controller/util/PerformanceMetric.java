package com.example.interview.controller.util;

import lombok.Getter;

@Getter
public enum PerformanceMetric {

    TOTAL_SALES,
    TOTAL_ORDERS;

    public static PerformanceMetric fromValue(String value){
        for (PerformanceMetric performanceMetric : PerformanceMetric.values()) {
            if(performanceMetric.toString().equals(value))
                return performanceMetric;
        }
        return null;
    }
}
