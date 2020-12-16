package loan.repayment;

import loan.repayment.account.CurrentAccount;
import loan.repayment.account.LoanAccount;
import loan.repayment.account.SavingsAccount;

public class PersonAccount {
    private LoanAccount loanAccount;
    private CurrentAccount currentAccount;
    private SavingsAccount savingsAccount;
    private PersonFunding personFunding;

    public PersonAccount(PersonFunding personFunding,
                         LoanAccount loanAccount,
                         CurrentAccount currentAccount,
                         SavingsAccount savingsAccount) {
        this.loanAccount = loanAccount;
        this.currentAccount = currentAccount;
        this.savingsAccount = savingsAccount;
        this.personFunding = personFunding;
    }

    public int calculateLoanRepaymentInMonths() {
        return loanAccount.calculateRepaymentDurationInMonth(personFunding.getDebtsContribution());
    }

    public double calculateCurrentAccountAmountAfterMonths(int months, double amount) {
        for (int i = 0; i < months; i++) {
            currentAccount.makeDeposit(amount);
            currentAccount.addInterest();
        }
        return currentAccount.getBalance();
    }

    public double calculateSavingsAccountAmountAfterMonths(int months, double amount) {
        for (int i = 0; i < months; i++) {
            savingsAccount.makeDeposit(amount);
            savingsAccount.addInterest();
        }
        return savingsAccount.getBalance();
    }
}
