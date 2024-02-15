package com.javamsdt.classes.abstractinterface.abstracts.impl;

import com.javamsdt.classes.abstractinterface.abstracts.api.Shape;

// Concrete subclass Rectangle
public class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    // Implementing abstract method to calculate area for Rectangle
    @Override
    public double calculateArea() {
        area = length * width;
        return area;
    }
}
