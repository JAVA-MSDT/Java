package com.javamsdt.classes.abstractinterface.abstracts;

import com.javamsdt.classes.abstractinterface.abstracts.impl.Circle;
import com.javamsdt.classes.abstractinterface.abstracts.impl.Rectangle;

public class AbstractRunner {
    public static void main(String[] args) {
        // Creating instances of concrete subclasses
        Circle circle = new Circle("Red", 5.0);
        Rectangle rectangle = new Rectangle("Blue", 4.0, 3.0);

        // Using common method from abstract class
        circle.displayColor(); // Output: Color: Red
        rectangle.displayColor(); // Output: Color: Blue

        // Using abstract method to calculate area
        double circleArea = circle.calculateArea();
        double rectangleArea = rectangle.calculateArea();

        System.out.println("Area of Circle: " + circleArea); // Output: Area of Circle: 78.53981633974483
        System.out.println("Area of Rectangle: " + rectangleArea); // Output: Area of Rectangle: 12.0
    }
}
