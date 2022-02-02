package com.example.interview.service.performer;

import org.springframework.stereotype.Service;

import java.util.PriorityQueue;

@Service
public class TopPerformerServiceImpl<T> implements TopPerformerService<T> {

    @Override
    public T findTopPerformer(PriorityQueue<T> priorityQueue) {
        return priorityQueue.peek();
    }

}
