package com.javamsdt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RandomNumberHandler {
    private final List<Integer> numbers = new ArrayList<>();
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public void writeRandomNumber() {
        Random random = new Random();

        try {
            lock.writeLock().lock();
            int randomNumber = random.nextInt(100);
            numbers.add(randomNumber);
            System.out.println("Added: " + randomNumber);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void printSum() {
        try {
            lock.readLock().lock();
            int sum = numbers.stream().mapToInt(Integer::intValue).sum();
            System.out.println("Sum: " + sum);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void printSqrt() {
        try {
            lock.readLock().lock();
            double sumOfSquares = numbers
                    .stream()
                    .mapToDouble(x -> x * x)
                    .sum();
            double sqrt = Math.sqrt(sumOfSquares);
            System.out.println("Square Root of Sum of Squares: " + sqrt);
        } finally {
            lock.readLock().unlock();
        }
    }

}
