package ca.georgiancollege.comp1011winter2023thursdayafternoon.classbasics;

public class Week2 {

    public static void main(String[] args) {

        /*
            In Java, only extend one other java class
            What do you want to include?
                only methods

         */


        example3();
    }
    static void example3(){

    SuperMan superMan = new SuperMan();
    Sword sword = new Sword();
    /*
    Weapon weapon = new Weapon();
    SuperPower superPower = new SuperPower();
    */
    //Sword is a weapon
    Weapon weapon = new Sword();

    //SuperMan is-a SuperPower
    SuperPower superPower = new SuperMan();


    }
    static void example2(){

        /*
            comp1011 is overloaded
            Polymorphism: many forms
                Overriding: new implementation of a method
                Overloading: new variations of a method


            Creating a class that is ONLY to be used as base class
                Abstract class

            Create an entity that serves as a list of requirements
                Interface

         */


    }
    static void example1(){

        /*
            Inheritance: creating a class BASED on another class
            Keep the instance variables and class methods of previous class
                non-private
            Keep the default constructors

            Override: change the behaviour.

            Previous            New

            super               sub
            parent              child
            base                derived
         */

        SuperHero superHero = new SuperHero();
        superHero.something = 100;
        SuperHero superHero1 = new SuperHero("Ben", 20, 170d);

        System.out.println(superHero);

    }
}
