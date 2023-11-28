package com.javamsdt.service;

import com.javamsdt.entity.Message;

import java.util.Random;
import java.util.concurrent.locks.Lock;

public class Producer implements Runnable{
    private final MessageBus messageBus;
    private final String[] topics;

    public Producer(MessageBus messageBus, String[] topics) {
        this.messageBus = messageBus;
        this.topics = topics;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            String topic = topics[random.nextInt(topics.length)];
            String payload = "Message " + random.nextInt(100);
            Message message = new Message(topic, payload);

            Lock lock = messageBus.getTopicLock(topic);
            lock.lock();
            try {
                messageBus.postMessage(message);
            } finally {
                lock.unlock();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
