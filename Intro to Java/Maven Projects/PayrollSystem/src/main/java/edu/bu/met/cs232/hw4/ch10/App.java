package edu.bu.met.cs232.hw4.ch10;

import org.joda.time.DateTime;

/**
 * App to test both Payroll and Accounts Payable Systems
 * Created by Jennifer Konikowski 3/4/2016
 *
 * Payroll System Test:
 *   Create an array of Employee variables to store references to the various employee
 *   objects. In a loop, calculate the payroll for each Employee (polymorphically), and
 *   add a $100.00 bonus to the person’s payroll amount if the current month is the one
 *   in which the Employee’s birthday occurs.
 *
 * Accounts Payable System Test:
 *   The application should still process two Invoice objects, but now should process
 *   one object of each of the four Employee subclasses. If the object currently being
 *   processed is a BasePlusCommissionEmployee, the application should increase the
 *   BasePlusCommissionEmployee’s base salary by 10%. Finally, the application should
 *   output the payment amount for each object.
 *
 */
public class App 
{
  public static void main( String[] args )
  {
    // Payroll System test
    System.out.println("*---------------------*");
    System.out.println("* PAYROLL SYSTEM TEST *");
    System.out.println("*---------------------*");
    // create subclass objects
    SalariedEmployee salariedEmployee = new SalariedEmployee("Kevin", "Konikowski",
        "999-99-9999", 3, 14, 1985, 2000.0);
    HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen", "Price",
        "222-22-2222", 8, 30, 1960, 16.75, 40);
    CommissionEmployee commissionEmployee =
        new CommissionEmployee(
            "Sue", "Jones", "333-33-3333", 7, 6, 1990, 10000, .06);
    BasePlusCommissionEmployee basePlusCommissionEmployee =
        new BasePlusCommissionEmployee(
            "Bob", "Lewis", "444-44-4444", 11, 3, 1986, 5000, .04, 300);
    PieceWorker pieceWorker = new PieceWorker("Rainbow", "Bright", "111-11-1111", 5,
        28, 1999, 20.0, 100);
    // create four-element Employee array
    Employee[] employees = new Employee[5];

    // initialize array with Employees
    employees[0] = salariedEmployee;
    employees[1] = hourlyEmployee;
    employees[2] = commissionEmployee;
    employees[3] = basePlusCommissionEmployee;
    employees[4] = pieceWorker;

    System.out.printf("Employees processed polymorphically:%n%n");
    double totalMonthlyEarnings;
    // generically process each element in array employees
    for (Employee currentEmployee : employees)
    {
      System.out.print(currentEmployee); // invokes toString
      DateTime today = DateTime.now();
      // since this is doing payroll by the month but earnings are by the week,
      // multiplying by four... not the greatest but ¯\_(ツ)_/¯
      totalMonthlyEarnings = currentEmployee.earnings() * 4;
      if(currentEmployee.getBirthDate().getMonthOfYear() == today.getMonthOfYear()){
        totalMonthlyEarnings += 100.0;
      }

      System.out.printf(
          "earned $%,.2f%n%n", totalMonthlyEarnings);
    }

    // Accounts Payable System test
    System.out.println("");
    System.out.println("*------------------------------*");
    System.out.println("* ACCOUNTS PAYABLE SYSTEM TEST *");
    System.out.println("*------------------------------*");
    // create four-element Payable array
    Payable[] payableObjects = new Payable[7];

    // populate array with objects that implement Payable
    payableObjects[0] = new Invoice("01234", "seat", 2, 375.00);
    payableObjects[1] = new Invoice("56789", "tire", 4, 79.95);
    payableObjects[2] = salariedEmployee;
    payableObjects[3] = hourlyEmployee;
    payableObjects[4] = commissionEmployee;
    payableObjects[5] = basePlusCommissionEmployee;
    payableObjects[6] = pieceWorker;

    System.out.println("Invoices and Employees processed polymorphically:");

    // generically process each element in array payableObjects
    for (Payable currentPayable : payableObjects) {
      // determine whether element is a BasePlusCommissionEmployee
      if(currentPayable instanceof BasePlusCommissionEmployee)
      {
        // downcast Employee reference to
        // BasePlusCommissionEmployee reference
        BasePlusCommissionEmployee employee =
            (BasePlusCommissionEmployee) currentPayable ;

        employee.setBaseSalary(1.10 * employee.getBaseSalary());

        System.out.printf(
            "%nnew base salary with 10%% increase is: $%,.2f",
            employee.getBaseSalary());
      } // end if
      // output currentPayable and its appropriate payment amount
      System.out.printf("%n%s%s: $%,.2f%n", currentPayable.toString(), "payment " +
          "due", currentPayable.getPaymentAmount());
    }
  }
}
