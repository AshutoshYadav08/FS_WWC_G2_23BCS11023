package BankingSystem;

public class Main {
    public static void main(String[] args) {

        // Creating a normal bank account
        BankAccount acc1 = new BankAccount("BA101", "Ravi Kumar", 5000);
        acc1.deposit(2000);
        acc1.withdraw(1500);
        acc1.printDetails();

        // Creating a savings account
        SavingsAccount sav1 = new SavingsAccount("SA201", "Priya Sharma", 8000, 5.0);
        sav1.deposit(1000);
        sav1.withdraw(9500);   // Should not allow
        sav1.withdraw(2000);   // Valid
        sav1.applyInterest();
        sav1.printDetails();
    }
}
