package BankingSystem;
public class SavingsAccount extends BankAccount {
    private double interestRate; 

    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println(amount + " withdrawn from Savings. New Balance: " + getBalance());
        } else {
            System.out.println("Withdrawal denied! Cannot exceed available balance.");
        }
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        setBalance(getBalance() + interest);
        System.out.println("Interest applied: " + interest + ". New Balance: " + getBalance());
    }
}
