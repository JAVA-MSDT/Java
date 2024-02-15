package com.javamsdt.classes.abstractinterface.abstracts.impl;

import com.javamsdt.classes.abstractinterface.abstracts.api.Shape;

// Concrete subclass Circle
public class Circle extends Shape {
    private final double radius;

    // Constructor
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // Implementing abstract method to calculate area for Circle
    @Override
    public double calculateArea() {
        area = Math.PI * radius * radius;
        return area;
    }
}
