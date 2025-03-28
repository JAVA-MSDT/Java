package com.javamsdt;

import com.javamsdt.service.Consumer;
import com.javamsdt.service.MessageBus;
import com.javamsdt.service.Producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        String[] topics = {"Topic1", "Topic2", "Topic3"};
        MessageBus messageBus = new MessageBus(topics);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        executor.submit(new Producer(messageBus, topics));

        for (String topic : topics) {
            executor.submit(new Consumer(messageBus, topic));
        }

        executor.shutdown();
    }
}