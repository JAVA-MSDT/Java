package com.javamsdt.classes.abstractinterface.abstracts.api;

// Abstract class Shape
public abstract class Shape {
    // Variables of different types
    protected String color;
    protected double area;

    // Constructor
    public Shape(String color) {
        this.color = color;
    }

    // Common method to be used everywhere
    public void displayColor() {
        System.out.println("Color: " + color);
    }

    // Abstract method to calculate area (must be implemented by subclasses)
    public abstract double calculateArea();
}

