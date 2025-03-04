package com.javamsdt.classes.abstractinterface.interfaces.api;

public interface Shape {
    // Variables of different types (implicitly static and final)
    String DEFAULT_COLOR = "Black";
    double DEFAULT_AREA = 0.0;

    // Common method to be used everywhere
    void displayColor();

    // Abstract method to calculate area (must be implemented by classes implementing Shape)
    double calculateArea();

    // Default method to display default color
    default void displayDefaultColor() {
        System.out.println("Default Color: " + DEFAULT_COLOR);
    }

    // Static method to get default area
    static double getDefaultArea() {
        return DEFAULT_AREA;
    }
}
