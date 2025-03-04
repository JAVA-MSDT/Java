package com.javamsdt.classes.abstractinterface.interfaces.impl;

import com.javamsdt.classes.abstractinterface.interfaces.api.Shape;

public class Rectangle implements Shape {
    private final String color;
    private final double length;
    private final double width;

    // Constructor
    public Rectangle(String color, double length, double width) {
        this.color = color;
        this.length = length;
        this.width = width;
    }

    // Implementing abstract method to calculate area for Rectangle
    @Override
    public double calculateArea() {
        return length * width;
    }

    // Implementing common method to display color
    @Override
    public void displayColor() {
        System.out.println("Color: " + color);
    }
}
