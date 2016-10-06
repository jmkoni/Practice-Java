package edu.bu.met.cs232;

import java.time.LocalDate;

/**
 * HeartRates.java
 * 3.16
 * Created by Jennifer Konikowski on 2/6/16.
 *
 * This class has the following attributes:
 *  * first name
 *  * last name
 *  * date of birth (month, day, year)
 *
 * Needs constructors that receives this data and each attribute should provide get and set methods.
 * This class should also have:
 *   * a method that returns a persons age (in years) - getAge
 *   * a method that calculates and returns the person's maximum heart rate - maxRate
 *   * a method that returns a person's target heart rate - targetRate
 *
 *
 * HeartRateCalculator.java uses this class.
 */
public class HeartRates {
    private String firstName;
    private String lastName;
    private int birthMonth;
    private int birthDay;
    private int birthYear;
    private LocalDate fullBirthday;

    public HeartRates(String firstName, String lastName, int birthMonth, int birthDay, int birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
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
} // end HeartRates
