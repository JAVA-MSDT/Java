package com.javamsdt;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Runner {
    public static void main(String[] args) {
        RandomNumberHandler randomNumberHandler = new RandomNumberHandler();
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        scheduler.scheduleAtFixedRate(randomNumberHandler::writeRandomNumber, 0, 500, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(randomNumberHandler::printSum, 0, 500, TimeUnit.MILLISECONDS);
        scheduler.scheduleAtFixedRate(randomNumberHandler::printSqrt, 0, 500, TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.shutdown();
    }
}