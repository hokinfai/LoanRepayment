package loan.repayment.account;

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

    public void makePayment(double amount) {
        balance -= amount;
    }

    public int calculateRepaymentDurationInMonth(double amount) {
        int numberOfMonths = 0;
        while (balance >= 0) {
            numberOfMonths++;
            makePayment(amount);
            addInterest();
        }
        return numberOfMonths;
    }
}
