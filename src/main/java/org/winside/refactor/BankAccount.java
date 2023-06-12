package org.winside.refactor;

public class BankAccount {
    public static final double LOW_INTEREST_RATE = 0.05;
    public static final double HIGH_INTEREST_RATE = 0.1;
    public static final String SAVINGS_ACCOUNT = "Savings Account";
    public static final String CHECKING_ACCOUNT = "Checking Account";
    public static final String BUSINESS_ACCOUNT = "Business Account";
    public static final String SAVINGS = "SAVINGS";
    public static final String CHECKING = "CHECKING";
    public static final String BUSINESS = "BUSINESS";
    public static final String EMPTY_STRING = "";
    public static final double NO_OVERDARF_FEE = 0.0;
    public static final double OVERDRAFT_FEE = -50.0;
    public static final String UNKNOWN = "Unknown";
    // Poor naming conventions
    final int accountNumber = 123456;
    double accountBalance = 1000.0;

    // method can be optimized
    // Hard coded values can be Constants
    public double calculateInterest(double principal, int years) {
        return principal * (years < 5 ? LOW_INTEREST_RATE : HIGH_INTEREST_RATE);
    }


    //Unused parameters can be removed
    //When removed the method becomes duplicated => it must be removed
    /*public void withdraw(int accountNumber, String accountHolderName, double amount) {
        accountBalance = accountBalance - amount;
    }*/

    //Indent code
    public double getAccountBalance() {
        return accountBalance;
    }

    //Inconsistent formatting write in separate lines
    // this can be a one-liner, but I left it for the sake of the exercise
    public boolean isInDebt() {
        boolean condition = accountBalance < 0;
        return condition;
    }

    // Method with a name that does not respect the Java naming convention
    public void withdrawMoney(int accountNumber, double amount) {
        // Withdrawal logic
    }

    //Use switch case instead of nested if
    //Use Constants instead of hard coded Strings
    public String getAccountType(int accountNumber) {
        return switch (accountNumber / 1000) {
            case 1 -> SAVINGS_ACCOUNT;
            case 2 -> CHECKING_ACCOUNT;
            case 3 -> BUSINESS_ACCOUNT;
            default -> EMPTY_STRING;
        };
    }

    //Invert condition for easier understanding
    //Use constants
    //One-liner
    public double calculateOverdraftFee(double balance) {
        return balance > 0 ? NO_OVERDARF_FEE : OVERDRAFT_FEE;
    }

    //Make private to only allow #withdrawAndApplyFees
    private void withdraw(double amount) {
        accountBalance -= amount;
        //Use logger instead of print
        System.out.println("Withdrawal successful. New balance: " + accountBalance);
    }

    //Remove duplicated code
    public void withdrawAndApplyFees(double amount) {
        double overdraftFee = calculateOverdraftFee(accountBalance);
        withdraw(amount + overdraftFee);
        System.out.println("Withdrawal successful. New balance: " + accountBalance);
    }

    //Use Enum
    public String getAccountTypeName(String accountType) {
        try {
            return AccountType.valueOf(accountType).name();
        }catch (IllegalArgumentException exception){
            return UNKNOWN;
        }
    }

    public enum AccountType {
        SAVINGS_ACCOUNT(SAVINGS),
        CHECKING_ACCOUNT(CHECKING),
        BUSINESS_ACCOUNT(BUSINESS);

        String type;

        AccountType(String type) {
            this.type = type;
        }
    }
}
