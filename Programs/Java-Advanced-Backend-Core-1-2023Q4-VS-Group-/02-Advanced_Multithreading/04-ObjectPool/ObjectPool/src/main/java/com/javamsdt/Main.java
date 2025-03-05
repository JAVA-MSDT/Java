package com.javamsdt;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingObjectPool blockingObjectPool = new BlockingObjectPool(5);

        long start = System.currentTimeMillis();
        long endTime = start + 30 * 1000;

        while (System.currentTimeMillis() < endTime) {
            Thread one = new Thread(() -> {
                for (int i = 0; i < 6; i++) {
                    Object object = blockingObjectPool.get();
                    System.out.println("Thread # " + Thread.currentThread().getId() + ", getting object: " + object);
                }
            });
            Thread.sleep(1000);

            Thread two = new Thread(() -> {
                for (int i = 0; i < 6; i++) {

                    Object object = new Object();
                    System.out.println("Thread # " + Thread.currentThread().getId() + ", returning object: " + object);
                    blockingObjectPool.take(object);
                }
            });

            two.start();
            one.start();

        }
    }
}
