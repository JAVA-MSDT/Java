package com.javamsdt.service;

import com.javamsdt.entity.Message;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable {
    private static final int QUANTITY = 100;
    private final MessageBus messageBus;
    private final String[] topics;

    public Producer(MessageBus messageBus, String[] topics) {
        this.messageBus = messageBus;
        this.topics = topics;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (int i = 0; i < QUANTITY; i++) {
            String topic = topics[random.nextInt(topics.length)];
            String payload = "Message " + i;
            Message message = new Message(topic, payload);

            Lock lock = messageBus.getTopicLock(topic);
            lock.lock();
            try {
                messageBus.postMessage(message);
            } finally {
                System.out.println("Producing a message:: " + message.payload() + ", to topic:: " + topic);
                lock.unlock();
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
