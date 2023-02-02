package ca.georgiancollege.comp1011winter2023thursdayafternoon.classbasics;

public class Person {

    // 3 attributes: name, age, height
    public int something;
    private String name = "Ben";
    private int age = 18;
    private double height = 100;

    //getters and setters
    //alt+insert


    /*
    enum: enumerable. List of options for user to select => drop-down menu.
          List of constants

    Two parts:
                create the list of options
                creating an instance variable to store one of the values of the list of options
     */
    //List of Genders
    public enum GENDER_OPTIONS {MALE, FEMALE, OTHER};

    //creating instance variable
    private GENDER_OPTIONS gender = GENDER_OPTIONS.MALE;

    public GENDER_OPTIONS getGender() {
        return gender;
    }

    public void setGender(GENDER_OPTIONS gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() < 3)
            throw new IllegalArgumentException("Name needs to be at least 3 characters");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0 || age > 120)
            throw new IllegalArgumentException("Age not within range");
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {

        if(height < 10 || height > 250)
            throw new IllegalArgumentException("Height not within range");
        this.height = height;
    }

    public Person(){}

    public Person(String name, int age, double height) {
        /*
        this.name = name;
        this.age = age;
        this.height = height;
        */
        setName(name);
        setAge(age);
        setHeight(height);
    }

    public Person(String name, int age) {
//        this.name = name;
//        this.age = age;
        setName(name);
        setAge(age);

    }

    //in order to summary all instance variables of a class, create (override) toString method


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o){

        try{
            Person compare = (Person)o;
            return name.equals(compare.name) && age == compare.age && height == compare.height && gender.equals(compare.gender);
        }
        catch (Exception e){
            return false;
        }
    }

}
