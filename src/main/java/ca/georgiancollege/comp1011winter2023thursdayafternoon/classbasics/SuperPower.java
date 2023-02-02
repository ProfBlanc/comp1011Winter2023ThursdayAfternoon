package ca.georgiancollege.comp1011winter2023thursdayafternoon.classbasics;

public abstract class SuperPower {

    /*
        abstract class looks and feels like a concrete class but cannot be instantiated
        abstract method
            method with no method body
                no default implementation
                    area
     */

    private String name;
    private int strength;
    private boolean canFly;

    public abstract void implementationOfSuperPower();

    public SuperPower(){}
    public SuperPower(String name, int strength, boolean canFly) {
        this.name = name;
        this.strength = strength;
        this.canFly = canFly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean isCanFly() {
        return canFly;
    }

    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }
}
