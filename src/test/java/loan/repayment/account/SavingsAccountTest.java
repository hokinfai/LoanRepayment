package loan.repayment.account;

import loan.repayment.account.SavingsAccount;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SavingsAccountTest {
    @Test
    public void addInteresetToAccount() {
        final SavingsAccount savingsAccount = new SavingsAccount(100);

        savingsAccount.addInterest();

        assertThat(savingsAccount.getBalance(), is(100.3));
    }

    @Test
    public void makeDepositToAccount() {
        final SavingsAccount savingsAccount = new SavingsAccount(100);

        savingsAccount.makeDeposit(100);

        assertThat(savingsAccount.getBalance(), is(200.0));
    }

}
