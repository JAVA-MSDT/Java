package com.javamsdt.inheritance;

public class Cat extends Animal {
    private final String color;

    // Constructor
    public Cat(String name, int age, String color) {
        super(name, age); // Call superclass constructor
        this.color = color;
    }

    // Method specific to Cat
    public void meow() {
        System.out.println(name + " meows softly.");
    }

    // Override method to make cat sound
    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
