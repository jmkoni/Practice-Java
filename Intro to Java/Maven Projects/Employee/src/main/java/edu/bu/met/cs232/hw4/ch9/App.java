package edu.bu.met.cs232.hw4.ch9;

/**
 * 9.14 (Employee Hierarchy) In this chapter, you studied an inheritance hierarchy in
 * which class BasePlusCommissionEmployee inherited  from class CommissionEmployee.
 * However, not all types of employees are CommissionEmployees. In this exercise,
 * you’ll create a more general Employee superclass that factors out the attributes and
 * behaviors in class CommissionEmployee that are common to all Employees. The common
 * attributes and behaviors for all Employees are firstName, lastName,
 * socialSecurityNumber, getFirstName, getLastName, getSocialSecurityNumber and a
 * portion of method toString. Create a new superclass Employee that contains these
 * instance variables and methods and a constructor. Next, rewrite class
 * CommissionEmployee from Section 9.4.5 as a subclass of Employee. Class
 * CommissionEmployee should contain only the instance variables and methods that are
 * not declared in superclass Employee. Class CommissionEmployee’s constructor should
 * invoke class Employee’s constructor and CommissionEmployee’s toString method should
 * invoke Employee’s toString method. Once you’ve completed these modifications, run
 * the CommissionEmployeeTest and BasePlusCommissionEmployeeTest apps using these new
 * classes to ensure that the apps still display the same results for a
 * CommissionEmployee object and BasePlusCommissionEmployee object, respectively.
 *
 * 9.15 (Creating a New Subclass of Employee) Other types of Employees might include
 * SalariedEmployees who get paid a fixed weekly salary, PieceWorkers who get paid by
 * the number of pieces they produce or HourlyEmployees who get paid an hourly wage
 * with time-and-a-half—1.5 times the hourly wage—for hours worked over 40 hours.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      // instantiate BasePlusCommissionEmployee object
      BasePlusCommissionEmployee bpc_employee = new BasePlusCommissionEmployee("Bob",
          "Lewis", "333-33-3333", 5000, .04, 300);

      // get base-salaried commission employee data
      System.out.println("Employee information obtained by get methods:%n");
      System.out.printf("%s %s%n", "First name is", bpc_employee.getFirstName());
      System.out.printf("%s %s%n", "Last name is", bpc_employee.getLastName());
      System.out.printf("%s %s%n", "Social security number is", bpc_employee
          .getSocialSecurityNumber());
      System.out.printf("%s %.2f%n", "Gross sales is", bpc_employee.getGrossSales());
      System.out.printf("%s %.2f%n", "Commission rate is", bpc_employee.getCommissionRate
          ());
      System.out.printf("%s %.2f%n", "Base salary is", bpc_employee.getBaseSalary());
      bpc_employee.setBaseSalary(1000);
      System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by " +
          "toString", bpc_employee.toString());

      // instantiate CommissionEmployee object
      CommissionEmployee c_employee = new CommissionEmployee("Sue", "Jones",
          "222-22-2222", 10000, .06);
      // get commission employee data
      System.out.println("Employee information obtained by get methods:");
      System.out.printf("%n%s %s%n", "First name is", c_employee.getFirstName());
      System.out.printf("%s %s%n", "Last name is", c_employee.getLastName());
      System.out.printf("%s %s%n", "Social security number is", c_employee
          .getSocialSecurityNumber());
      System.out.printf("%s %.2f%n", "Gross sales is", c_employee.getGrossSales());
      System.out.printf("%s %.2f%n", "Commission rate is", c_employee.getCommissionRate
          ());
      c_employee.setGrossSales(5000);
      c_employee.setCommissionRate(.1);
      System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by " +
          "toString", c_employee);
    }
}
