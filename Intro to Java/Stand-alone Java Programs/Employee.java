package edu.bu.met.cs232;

/**
 * Employee.java
 * 3.13
 * Created by Jennifer Konikowski on 2/6/16.
 *
 * This is a class that represents an employee. It has three pieces of information:
 *  * first name (type String)
 *  * last name (type String)
 *  * monthly salary (double)
 *
 * If the monthly salary is not positive, do not set its value.
 * Getters and setters for everything are needed
 *
 * Employee.java tests this class.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private double monthlySalary;

    // Employee constructor that receives three parameters
    public Employee(String firstName, String lastName, double monthlySalary) {
        this.firstName = firstName; // assign first name to instance variable
        this.lastName = lastName; // assign last name to instance variable

        // validate that item price is positive
        if (monthlySalary > 0.0){
            this.monthlySalary = monthlySalary; // assign monthlySalary to instance variable
        }
    } // end Employee

    // method that sets firstName
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    // method that returns firstName
    public String getFirstName() {
        return firstName;
    }

    // method that sets lastName
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    // method that returns lastName
    public String getLastName() {
        return lastName;
    }

    // method that sets monthlySalary
    public void setMonthlySalary(double monthlySalary){
        if (monthlySalary > 0.0) {
            this.monthlySalary = monthlySalary;
        } else {
            System.out.println("Monthly salary must be greater than $0.0.");
        }
    }

    // method that gets monthly Salary
    public double getMonthlySalary() {
        return monthlySalary;
    }

    // returns yearly salary
    public double getYearlySalary() {
        return monthlySalary * 12;
    }

    // increases employee salary by percenage (given as 10 if 10% raise)
    public void giveRaise(int percentage) {
        double raiseMultiplier = (100 + percentage)/100.0;
        this.monthlySalary = monthlySalary * raiseMultiplier;
    }
} // end Employee