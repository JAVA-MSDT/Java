package com.javamsdt.inheritance;

public class Dog extends Animal {
    private final String breed;

    // Constructor
    public Dog(String name, int age, String breed) {
        super(name, age); // Call superclass constructor
        this.breed = breed;
    }

    // Method specific to Dog
    public void bark() {
        System.out.println(name + " barks loudly!");
    }

    // Override method to make dog sound
    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
