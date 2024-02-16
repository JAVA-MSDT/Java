package com.javamsdt.inheritance;

public class InheritanceRunner {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", 3, "Labrador");
        Cat myCat = new Cat("Whiskers", 2, "Tabby");

        // Display information and make sounds
        System.out.println(myDog);
        myDog.displayInfo();
        myDog.makeSound();
        myDog.bark();

        System.out.println("========================");

        System.out.println(myCat);
        myCat.displayInfo();
        myCat.makeSound();
        myCat.meow();
    }
}
