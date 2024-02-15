package com.javamsdt.classes.abstractinterface.interfaces;

import com.javamsdt.classes.abstractinterface.interfaces.api.Shape;
import com.javamsdt.classes.abstractinterface.interfaces.impl.Circle;
import com.javamsdt.classes.abstractinterface.interfaces.impl.Rectangle;

public class InterfaceRunner {
    public static void main(String[] args) {
        // Creating instances of concrete classes
        Shape circle = new Circle("Red", 5.0);
        Shape rectangle = new Rectangle("Blue", 4.0, 3.0);

        // Using common method from interface
        circle.displayColor(); // Output: Color: Red
        rectangle.displayColor(); // Output: Color: Blue

        // Using default method to display default color
        circle.displayDefaultColor(); // Output: Default Color: Black
        rectangle.displayDefaultColor(); // Output: Default Color: Black

        // Using static method to get default area
        double defaultArea = Shape.getDefaultArea();
        System.out.println("Default Area: " + defaultArea); // Output: Default Area: 0.0

        // Using abstract method to calculate area
        double circleArea = circle.calculateArea();
        double rectangleArea = rectangle.calculateArea();

        System.out.println("Area of Circle: " + circleArea); // Output: Area of Circle: 78.53981633974483
        System.out.println("Area of Rectangle: " + rectangleArea); // Output: Area of Rectangle: 12.0
    }
}
