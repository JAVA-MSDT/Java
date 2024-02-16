package com.javamsdt.abstraction.advanced.innerclasses;

public class InnerClassesRunner {
    public static void main(String[] args) {
        System.out.println("============ Inner Static Class ==============");
        OuterClass.StaticNested nestedObject = new OuterClass.StaticNested();
        nestedObject.display();

        System.out.println("============ Inner Non-Static Class ==============");
        OuterClass outerObject = new OuterClass();
        OuterClass.Inner innerObject = outerObject.new Inner();
        innerObject.display();

        System.out.println("============ Inner Local Class ==============");
        outerObject.method();

        System.out.println("============ Anonymous class Class ==============");
        Greeting greeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello");
            }
        };
        greeting.greet();

        System.out.println("============ Anonymous class Class Using Lambda ==============");
        Greeting greetingTwo = () -> System.out.println("Hello From Lambda");
        greetingTwo.greet();
    }
}
