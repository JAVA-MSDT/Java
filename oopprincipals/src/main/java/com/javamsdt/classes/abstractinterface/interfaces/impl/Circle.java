package com.javamsdt.classes.abstractinterface.interfaces.impl;

import com.javamsdt.classes.abstractinterface.interfaces.api.Shape;

public class Circle implements Shape {
    private final String color;
    private final double radius;

    // Constructor
    public Circle(String color, double radius) {
        this.color = color;
        this.radius = radius;
    }

    // Implementing abstract method to calculate area for Circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementing common method to display color
    @Override
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}
