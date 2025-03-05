package com.javamsdt.service;

import com.javamsdt.entity.Message;

public class Consumer implements Runnable {
    private final MessageBus messageBus;
    private final String topic;

    public Consumer(MessageBus messageBus, String topic) {
        this.messageBus = messageBus;
        this.topic = topic;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = messageBus.consumeMessage(topic);
                if (message != null) {
                    System.out.println("Consumer on topic " + topic + " received message: " + message.payload());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
