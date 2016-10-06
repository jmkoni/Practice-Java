package edu.bu.met.cs232;

import java.time.LocalDate;

/**
 * HealthProfile.java
 * 3.17
 * Created by Jennifer Konikowski on 2/7/16.
 *
 * Class attributes include a:
 *   * first name
 *   * last name
 *   * gender
 *   * date of birth (month, day, year)
 *   * height (in inches)
 *   * weight (in pounds)
 *
 * Class should include a constructor that receives this data, along with setters and getters.
 * Methods that return the user's age in years, max heart rate and target heart rate... and body mass index
 *
 */
public class HealthProfile {
    private String firstName;
    private String lastName;
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private LocalDate fullBirthday;
    private float height;
    private float weight;

    public HealthProfile(String firstName, String lastName, int birthMonth, int birthDay, int birthYear, float height, float weight){
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        if (birthMonth > 0 && birthMonth < 13) {
            this.birthMonth = birthMonth;
        }
        if (birthDay > 0 && birthDay < 32) {
            this.birthDay = birthDay;
        }
        if (birthYear > 1100) {
            this.birthYear = birthYear;
        }
        if (birthMonth > 0 && birthMonth < 13 && birthDay > 0 && birthDay < 32 && birthYear > 1100) {
            // only create fullBirthday if dates are 'valid'
            this.fullBirthday = LocalDate.of(birthYear, birthMonth, birthDay);
        }
    }

    // set firstName
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    // get firstName
    public String getFirstName(){
        return firstName;
    }

    // set lastName
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    // get lastName
    public String getLastName(){
        return lastName;
    }

    //set birthMonth
    public void setBirthMonth(int birthMonth){
        if (birthMonth > 0 && birthMonth < 13) {
            this.birthMonth = birthMonth;
            this.fullBirthday.withMonth(birthMonth);
        } else {
            System.out.println("Please enter a valid birth month between 1 and 12.");
        }
    }

    // get birthMonth
    public int getBirthMonth(){
        return birthMonth;
    }

    // set birthDay
    public void setBirthDay(int birthDay){
        if (birthDay > 0 && birthDay < 32) {
            this.birthDay = birthDay;
            this.fullBirthday.withDayOfMonth(birthDay);
        } else {
            System.out.println("Please enter a valid birth day between 1 and 31.");
        }
    }

    // get birthDay
    public int getBirthDay(){
        return birthDay;
    }

    //set birthyear
    public void setBirthYear(int birthYear){
        if (birthYear > 1100) {
            this.birthYear = birthYear;
            this.fullBirthday.withYear(birthYear);
        } else {
            System.out.println("Please enter a birth year within this millenia.");
        }
    }

    // get birthYear
    public int getBirthYear(){
        return birthYear;
    }

    // set height
    public void setHeight(float height){
        if (height > 0) {
            this.height = height;
        } else {
            System.out.println("Please enter a height greater than zero.");
        }
    }

    // get height
    public float getHeight() {
        return height;
    }

    // set weight
    public void setWeight(float weight){
        if (weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("Please enter a weight greater than zero.");
        }
    }
    // get weight
    public float getWeight() {
        return weight;
    }

    // function to determine age
    public int getAge(){
        LocalDate now = LocalDate.now();
        // I tried a few different things, but comparing the number of days to Epoch Day
        // ended up giving the right answer.
        long daysSinceBirth = now.toEpochDay() - fullBirthday.toEpochDay();
        return (int) (daysSinceBirth/365);
    }

    // returns max heart rate
    public int maxRate(){
        return 220 - getAge();
    }

    // returns min target rate
    public int minTargetRate(){
        return (int)(maxRate() * 0.50);
    }

    // returns max target rate
    public int maxTargetRate(){
        return (int)(maxRate() * 0.85);
    }

    // returns BMI
    public float bodyMassIndex(){
        return (weight * 703) / (height * height);
    }

    // prints out BMI chart
    public void bmiValues(){
        System.out.println("BMI VALUES");
        System.out.println("Underweight: less than 18.5");
        System.out.println("Normal:      between 18.5 and 24.9");
        System.out.println("Overweight:  between 25 and 29.9");
        System.out.println("Obese:       30 or greater");
    }
}
