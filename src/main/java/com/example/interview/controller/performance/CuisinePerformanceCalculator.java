package com.example.interview.controller.performance;

import com.example.interview.controller.util.PerformanceMetric;
import com.example.interview.controller.util.PriorityQueueFactory;
import com.example.interview.models.Cuisine;
import com.example.interview.service.performer.TopPerformerServiceImpl;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class CuisinePerformanceCalculator {

    private TopPerformerServiceImpl<Cuisine> topPerformerService = new TopPerformerServiceImpl<>();

    PriorityQueueFactory priorityQueueFactory = new PriorityQueueFactory();

    public Cuisine findTopPerformer(PerformanceMetric metric) {
        PriorityQueue<Cuisine> priorityQueue = (PriorityQueue<Cuisine>) priorityQueueFactory.fetchVendorPriorityQueue(Cuisine.class,metric);
        return topPerformerService.findTopPerformer(priorityQueue);
    }
}
