package loan.repayment;

public class PersonFunding {

    private double income;
    private double expense;
    private double debtsContribution;

    private PersonFunding(double income, double expense, double debtsContribution) {
        this.income = income;
        this.expense = expense;
        this.debtsContribution = debtsContribution;
    }

    public double calculateSavingAmountInAMonth() {
        return income - expense - debtsContribution;
    }

    public double getDebtsContribution() {
        return debtsContribution;
    }

    public static final class Builder {
        private double income;
        private double expense;
        private double debtsContribution;

        private Builder() {
        }

        public static Builder aPersonFunding() {
            return new Builder();
        }

        public Builder withIncome(double income) {
            this.income = income;
            return this;
        }

        public Builder withExpense(double expense) {
            this.expense = expense;
            return this;
        }

        public Builder withDebtsContribution(double debtsContribution) {
            this.debtsContribution = debtsContribution;
            return this;
        }

        public PersonFunding build() {
            return new PersonFunding(income, expense, debtsContribution);
        }
    }
}
