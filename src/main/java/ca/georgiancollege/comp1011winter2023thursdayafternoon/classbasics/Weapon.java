package ca.georgiancollege.comp1011winter2023thursdayafternoon.classbasics;

public interface Weapon {
    /*
        public entities
        constants
        method signatures
            declarations of methods with NO default implementation
     */

    int MIN_STRENGTH = 10;
    int MAX_STRENGTH = 100;

    void strike();
    double effectiveness(int age);
    double criticalHit();

}
