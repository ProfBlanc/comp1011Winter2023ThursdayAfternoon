package ca.georgiancollege.comp1011winter2023thursdayafternoon.classbasics;

public class SuperHero extends Person{

    public boolean hasGlasses;
    protected String pseudonym;
    public enum SUPER_HERO_RATING {A, B, C, S};
    private SUPER_HERO_RATING superHeroRating = SUPER_HERO_RATING.S;

    @Override
    public String toString() {
        return "SuperHero{" +
                "something=" + something +
                ", hasGlasses=" + hasGlasses +
                ", pseudonym='" + pseudonym + '\'' +
                ", superHeroRating=" + superHeroRating +
                ", " +
                super.toString().substring(7)

                ;
    }

    public SuperHero(String name, int age, double height, boolean hasGlasses, String pseudonym, SUPER_HERO_RATING superHeroRating) {
        super(name, age, height);
        this.hasGlasses = hasGlasses;
        this.pseudonym = pseudonym;
        this.superHeroRating = superHeroRating;
    }
    public SuperHero(String name,String pseudonym, int age, double height,
                     boolean hasGlasses , SUPER_HERO_RATING superHeroRating) {

        this(name, age, height, hasGlasses, pseudonym, superHeroRating);
    }


    public SuperHero(String name, int age, double height,
                     boolean hasGlasses, String pseudonym) {
        super(name, age, height);
        this.hasGlasses = hasGlasses;
        this.pseudonym = pseudonym;
    }

    public boolean isHasGlasses() {
        return hasGlasses;
    }

    public void setHasGlasses(boolean hasGlasses) {
        this.hasGlasses = hasGlasses;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public SUPER_HERO_RATING getSuperHeroRating() {
        return superHeroRating;
    }

    public void setSuperHeroRating(SUPER_HERO_RATING superHeroRating) {
        this.superHeroRating = superHeroRating;
    }

    public SuperHero() {
    }

    public SuperHero(String name, int age, double height) {
        super(name, age, height);

        //super.setAge(50);
    }

    @Override
    public void setAge(int age){

        if (age % 2 == 0)
            super.setAge(age);
    }

    public SuperHero(String name, int age) {
        super(name, age);
    }
}
