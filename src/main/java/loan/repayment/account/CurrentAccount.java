package loan.repayment.account;

public class CurrentAccount {
    private double interestRate = 0.0007;
    private double balance;

    public CurrentAccount(double balance) {
        this.balance = balance;
    }

    public CurrentAccount() {
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
