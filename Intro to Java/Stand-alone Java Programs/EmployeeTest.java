package edu.bu.met.cs232;

import java.util.Scanner;

/**
 * EmployeeTest.java
 * 3.13
 * Created by Jennifer Konikowski on 2/6/16.
 *
 * Test class for Employee.java
 *
 * There should be two Employee objects and a yearly salary should be displayed.
 * Then give each employee a 10% raise and display the yearly salary again.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        // create employees
        Employee employee1 = new Employee("Jennifer", "Konikowski", 8000.00);
        Employee employee2 = new Employee("Ada", "Lovelace", 10000.00);

        // display yearly salaries
        System.out.printf("%s %s: %.2f%n", employee1.getFirstName(), employee1.getLastName(), employee1.getYearlySalary());
        System.out.printf("%s %s: %.2f%n%n", employee2.getFirstName(), employee2.getLastName(), employee2.getYearlySalary());

        // create a scanner object
        Scanner input = new Scanner(System.in);

        // TEST FIRST NAME
        System.out.print("Enter first name for Employee 2: "); //prompt
        String firstName = input.nextLine(); // obtain user input
        System.out.printf("%nupdating first name for Employee 2 to %s%n%n", firstName);
        employee2.setFirstName(firstName);

        // TEST LAST NAME
        System.out.print("Enter last name for Employee 2: "); //prompt
        String lastName = input.nextLine(); // obtain user input
        System.out.printf("%nupdating last name for Employee 2 to %s%n%n", lastName);
        employee2.setLastName(lastName);

        // TEST MONTHLY SALARY
        System.out.print("Enter monthly salary for Employee 1: "); //prompt
        double salary = input.nextDouble(); // obtain user input
        System.out.printf("%nupdating monthly salary for employee 1 to %.2f%n%n", salary);
        employee1.setMonthlySalary(salary);

        System.out.print("Enter monthly salary for Employee 2: "); //prompt
        salary = input.nextDouble(); // obtain user input
        System.out.printf("%nupdating monthly salary for employee 2 to %.2f%n%n", salary);
        employee2.setMonthlySalary(salary);

        System.out.printf("%s %s: %.2f%n", employee1.getFirstName(), employee1.getLastName(), employee1.getYearlySalary());
        System.out.printf("%s %s: %.2f%n%n", employee2.getFirstName(), employee2.getLastName(), employee2.getYearlySalary());

        // TEST RAISE
        System.out.println("Giving each employee a 10% raise.");
        employee1.giveRaise(10);
        employee2.giveRaise(10);

        System.out.printf("%s %s: %.2f%n", employee1.getFirstName(), employee1.getLastName(), employee1.getYearlySalary());
        System.out.printf("%s %s: %.2f%n%n", employee2.getFirstName(), employee2.getLastName(), employee2.getYearlySalary());
    } // end main
} // end EmployeeTest