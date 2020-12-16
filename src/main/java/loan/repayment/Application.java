package loan.repayment;

import loan.repayment.account.CurrentAccount;
import loan.repayment.account.LoanAccount;
import loan.repayment.account.SavingsAccount;

import static java.lang.String.format;
import static loan.repayment.PersonFunding.Builder.aPersonFunding;

public class Application {
    public static void main(String args[]) {
        getJohnAccountInfo();

        getMaryAccountInfo();
    }

    private static void getJohnAccountInfo() {
        double johnIncome = 2000.0;
        double johnExpense = 1200.0;
        double johnDebtsContribution = 200;
        double johanLoanAccountBalance = 20000.0;

        PersonFunding johnFunding = aPersonFunding()
                .withIncome(johnIncome)
                .withExpense(johnExpense)
                .withDebtsContribution(johnDebtsContribution)
                .build();
        PersonAccount johnAccount = new PersonAccount(johnFunding, new LoanAccount(johanLoanAccountBalance), new CurrentAccount(), new SavingsAccount());
        int johnLoanRepaymentInMonths = johnAccount.calculateLoanRepaymentInMonths();
        double johnCurrentAccountAmountAfterMonths = johnAccount.calculateCurrentAccountAmountAfterMonths(johnLoanRepaymentInMonths, johnFunding.calculateSavingAmountInAMonth());
        System.out.println(format("John repaid his loan after %s months. His current account balance at that time was £%s", johnLoanRepaymentInMonths, johnCurrentAccountAmountAfterMonths));
    }

    private static void getMaryAccountInfo() {
        double maryIncome = 2200.0;
        double maryExpense = 1000.0;
        double maryDebtsContribution = 250;
        double maryLoanAccountBalance = 15000.0;
        double marySavingAccountOpeningBalance = 100.0;

        PersonFunding maryFunding = aPersonFunding()
                .withIncome(maryIncome)
                .withExpense(maryExpense)
                .withDebtsContribution(maryDebtsContribution)
                .build();
        PersonAccount maryAccount = new PersonAccount(maryFunding, new LoanAccount(maryLoanAccountBalance), new CurrentAccount(), new SavingsAccount(marySavingAccountOpeningBalance));
        int maryLoanRepaymentInMonths = maryAccount.calculateLoanRepaymentInMonths();
        double marySavingsAccountAmountAfterMonths = maryAccount.calculateSavingsAccountAmountAfterMonths(maryLoanRepaymentInMonths, maryFunding.calculateSavingAmountInAMonth());
        System.out.println(format("Mary repaid her loan after %s months. Her savings account balance at that time was £%s", maryLoanRepaymentInMonths, marySavingsAccountAmountAfterMonths));
    }

}
