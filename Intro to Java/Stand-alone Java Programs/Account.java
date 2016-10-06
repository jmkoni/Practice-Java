/**
 * Account.java
 *
 * Account class with a double instance variable balance and a constructur
 * and deposit method that perform validation
 */
public class Account {
    private String name; // account name
    private double balance; // account balance

    // Account constructor that receives two parameters
    public Account(String name, double balance) {
        this.name = name; // assign account name to instance variable

        // validate that the balance is greater than 0; if not,
        // instance variable balance keeps initial value of 0.0
        if (balance > 0.0) // balance is valid
        {
            this.balance = balance; // assign balance to instance variable
        }
    }

    // method that deposits only a valid amount to account balance
    public void deposit(double depositAmount){
        if (depositAmount > 0) { // if depositAmount is valid
            balance = balance + depositAmount; // add it to the balance
        }
    }

    // method that withdraws only a valid amount from the balance
    public void withdraw(double withdrawAmount){
        if (withdrawAmount < balance){ // if withdrawAmount is valid
            balance = balance - withdrawAmount; // subtract it from balance
        } else {
            System.out.println("Withdrawal amount exceeded account balance.");
        }
    }

    //method returns the account balance
    public double getBalance(){
        return balance;
    }

    // method that sets name
    public void setName(String name){
        this.name = name;
    }

    // method that returns name
    public String getName() {
        return name;
    }
} // end class Account
