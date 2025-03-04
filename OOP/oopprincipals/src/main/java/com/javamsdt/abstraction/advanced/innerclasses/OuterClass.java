package com.javamsdt.abstraction.advanced.innerclasses;

public class OuterClass {
    private static final int outerStaticVariable = 10;
    private final int outerVariable = 10;

    // Static nested class
    public static class StaticNested {
        private final int innerStaticVariable = 20;

        public void display() {
            System.out.println("Outer Static Variable: " + outerStaticVariable);
            System.out.println("Inner Static Variable: " + innerStaticVariable);
        }
    }

    // Inner class
    public class Inner {
        public void display() {
            System.out.println("Outer Variable for Inner Class: " + outerVariable);
            System.out.println("Outer Static Variable for Inner Class: " + outerStaticVariable);
        }
    }

    public void method() {
        // Local class
        class Local {
            public void display() {
                System.out.println("Outer Variable for Local class: " + outerVariable);
                System.out.println("Outer Static Variable for Local class: " + outerStaticVariable);
            }
        }

        Local local = new Local();
        local.display();
    }

}
