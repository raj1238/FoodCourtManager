package com.example.interview.controller.performance;

import com.example.interview.controller.util.PerformanceMetric;
import com.example.interview.controller.util.PriorityQueueFactory;
import com.example.interview.models.Weekday;
import com.example.interview.service.performer.TopPerformerService;
import com.example.interview.service.performer.TopPerformerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class WeekdayPerformanceCalculator {

    private TopPerformerServiceImpl<Weekday> topPerformerService = new TopPerformerServiceImpl<>();

    PriorityQueueFactory priorityQueueFactory = new PriorityQueueFactory();

    public Weekday findTopPerformer(PerformanceMetric metric) {
        PriorityQueue<Weekday> priorityQueue = (PriorityQueue<Weekday>) priorityQueueFactory.fetchVendorPriorityQueue(Weekday.class,metric);
        return topPerformerService.findTopPerformer(priorityQueue);
    }

}
