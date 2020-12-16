package loan.repayment.account;

public class SavingsAccount {
    private double interestRate = 0.003;
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public SavingsAccount() {
    }

    public double getBalance() {
        return balance;
    }

    public void addInterest() {
        balance += balance * interestRate;
    }

    public void makeDeposit(double amount) {
        balance += amount;
    }

}
