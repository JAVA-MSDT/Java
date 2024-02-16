package com.javamsdt.inheritance;

public class Animal {
    protected String name;
    protected int age;

    // Constructor
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display animal information
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " years");
        System.out.println("Class Caller:: " + this.getClass().getSimpleName());
    }

    // Method to make animal sound (to be overridden by subclasses)
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}
