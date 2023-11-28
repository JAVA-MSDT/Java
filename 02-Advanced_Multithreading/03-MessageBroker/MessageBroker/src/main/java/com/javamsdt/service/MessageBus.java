package com.javamsdt.service;

import com.javamsdt.entity.Message;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MessageBus {
    private final Map<String, BlockingQueue<Message>> messageQueueMap = new HashMap<>();
    private final Map<String, Lock> topicLocks = new HashMap<>();

    public MessageBus(String[] topics) {
        for (String topic : topics) {
            messageQueueMap.put(topic, new LinkedBlockingQueue<>());
            topicLocks.put(topic, new ReentrantLock());
        }
    }

    public void postMessage(Message message) {
        String topic = message.topic();
        messageQueueMap.get(topic).offer(message);
    }

    public Message consumeMessage(String topic) throws InterruptedException {
        return messageQueueMap.get(topic).poll(1, TimeUnit.SECONDS);
    }

    public Lock getTopicLock(String topic) {
        return topicLocks.get(topic);
    }
}
