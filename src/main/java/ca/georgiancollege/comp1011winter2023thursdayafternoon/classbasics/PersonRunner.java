package ca.georgiancollege.comp1011winter2023thursdayafternoon.classbasics;

import java.util.Scanner;

public class PersonRunner {

    public static void main(String[] args) {
        example3();
    }
    static void example2(){

        Person p1 = new Person();

        p1.setGender(Person.GENDER_OPTIONS.MALE);
    }
    static void example3(){

        Person p1 = new Person("Ben", 20, 140d);
        System.out.println(p1);  //summary of p1 object

        Person p2 = new Person("Ben", 20, 140d);

        System.out.println(p1.equals(p2));

        Person p3 = p1;
        System.out.println(p1.equals(p3));
    }

    static void example1(){
        Scanner input = new Scanner(System.in);
        int maxNumber = 3;
        Person[] people = new Person[maxNumber];
        for(int i = 1 ; i <= maxNumber; i++){
            int index = i - 1;
            people[index] = new Person();

            System.out.println("Enter firstname for Person " + i);
            people[index].setName(input.nextLine());

            System.out.println("Enter age for Person " + i);
            //age
            people[index].setAge(input.nextInt());
            /*
            //height
            input.nextDouble();
            */



        }

    }
}
