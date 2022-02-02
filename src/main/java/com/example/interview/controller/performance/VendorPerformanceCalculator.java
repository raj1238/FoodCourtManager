package com.example.interview.controller.performance;

import com.example.interview.controller.util.PerformanceMetric;
import com.example.interview.controller.util.PriorityQueueFactory;
import com.example.interview.models.Vendor;
import com.example.interview.service.performer.TopPerformerService;
import com.example.interview.service.performer.TopPerformerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class VendorPerformanceCalculator {

    private TopPerformerServiceImpl<Vendor> topPerformerService = new TopPerformerServiceImpl<>();

    PriorityQueueFactory priorityQueueFactory = new PriorityQueueFactory();

    public Vendor findTopPerformer(PerformanceMetric metric) {
        PriorityQueue<Vendor> priorityQueue = (PriorityQueue<Vendor>) priorityQueueFactory.fetchVendorPriorityQueue(Vendor.class,metric);
        return topPerformerService.findTopPerformer(priorityQueue);
    }

}
