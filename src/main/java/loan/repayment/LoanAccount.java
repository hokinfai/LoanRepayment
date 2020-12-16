package loan.repayment;

public class LoanAccount {
    private double interestRate = 0.008;
    private double balance;

    public LoanAccount(double balance) {
        this.balance = balance;
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
