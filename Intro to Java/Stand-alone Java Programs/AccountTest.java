/**
 * AccountTest.java
 *
 * Inputting and outputting floating-point numbers with Account objects
 */
import java.util.Scanner;
public class AccountTest {
    public static void main(String[] args){
        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", -7.53);
        int counter = 2;

        do
        {
            System.out.println(counter);
            counter += 2;
        } while (counter <= 100);
        // display initial balance
        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());

        // create a scanner object
        Scanner input = new Scanner(System.in);

        // TEST DEPOSIT
        System.out.print("Enter deposit amount for Account 1: "); //prompt
        double depositAmount = input.nextDouble(); // obtain user input
        System.out.printf("%nadding %.2f to Account 1 balance %n%n", depositAmount);
        account1.deposit(depositAmount); // add to balance

        // display balance
        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());

        System.out.print("Enter deposit amount for Account 2: "); //prompt
        depositAmount = input.nextDouble(); // obtain user input
        System.out.printf("%nadding %.2f to Account 2 balance %n%n", depositAmount);
        account2.deposit(depositAmount); // add to balance

        // display balance
        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());

        // TEST WITHDRAW
        System.out.print("Enter withdrawal amount for Account 1: "); //prompt
        double withdrawAmount = input.nextDouble(); // obtain user input
        System.out.printf("%nremoving %.2f from Account 1 balance %n%n", withdrawAmount);
        account1.withdraw(withdrawAmount); // add to balance

        // display balance
        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());

        System.out.print("Enter withdrawal amount for Account 2: "); //prompt
        withdrawAmount = input.nextDouble(); // obtain user input
        System.out.printf("%nremoving %.2f from Account 2 balance %n%n", withdrawAmount);
        account2.withdraw(withdrawAmount); // add to balance

        // display balance
        System.out.printf("%s balance: $%.2f%n", account1.getName(), account1.getBalance());
        System.out.printf("%s balance: $%.2f%n%n", account2.getName(), account2.getBalance());
    } // end main
} // end class AccountTest