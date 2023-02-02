package ca.georgiancollege.comp1011winter2023thursdayafternoon.text;

public class StringAndStringBuilder {


    public static void main(String[] args) {
        /*
            String is a reference data type that behaves like a primitive data type

         */

        //Person p1 = new Person();
        String s1 = new String("Hello");
        String s2 = "Hello";

        StringBuilder sb1 = new StringBuilder(); //length =0, capacity = 16
        StringBuilder sb2 = new StringBuilder("Hello"); //length = # of chars, capacity = # chars + 16
        StringBuilder sb3 = new StringBuilder(1000);
        sb1.append("Hello");
        sb1.delete(0, 2); // 0, 1 => llo

        //String were a cup of water, StringBuilder would be a water bottle
        sb1.capacity(); //soft max # of characters => auto-expand

        System.out.println(sb2.capacity());
        sb1.append("World");
        sb1.append("comp1011bob");
        //auto-expands by formula previous capacity + 1, doubled
        System.out.println(sb1.length());
        System.out.println(sb1.capacity());
        System.out.println(sb1.toString());



    }

}
