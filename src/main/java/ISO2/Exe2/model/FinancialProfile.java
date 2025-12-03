package ISO2.Exe2.model;

/**
 * Value object that encapsulates financial information about a customer.
 * This reduces the number of independent parameters in Customer.
 */
public class FinancialProfile {
    private final double income;

    public FinancialProfile(double income) {
        this.income = income;
    }

    public double getIncome() {
        return income;
    }

    public boolean hasMiddleIncome() {
        return income > 20000 && income < 35000;
    }

    public boolean hasHighIncome() {
        return income > 35000;
    }
}
