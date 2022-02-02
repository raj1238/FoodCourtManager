package com.example.interview.service.performer;

import org.springframework.stereotype.Component;

import java.util.PriorityQueue;

@Component
public interface TopPerformerService<T> {

    T findTopPerformer(PriorityQueue<T> priorityQueue);

}
