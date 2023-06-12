package org.winside.refactor;

public class BankAccount {
    int acc_num = 123456;
    double balance = 1000.0;

    public double calculateInterest(double principal, int years) {
        double interestRate;
        if (years <= 5) {
            interestRate = 0.05;
        } else {
            interestRate = 0.1;
        }

        double interest = principal * interestRate * years;
        return interest;
    }

    public void withdraw(int accountNumber, String accountHolderName, double amount) {
        balance = balance - amount;
    }

    public double   getBalance()
    {
        return   balance;
    }

    public boolean isInDebt(){
        boolean condition = balance < 0; return condition;
    }


    public void Withdraw_money(int accountNumber, double amount) {
        // Withdrawal logic
    }

    public String getAccountType(int accountNumber) {
        String accountType = "";
        if (accountNumber >= 1000 && accountNumber <= 1999) {
            accountType = "Savings Account";
        } else if (accountNumber >= 2000 && accountNumber <= 2999) {
            accountType = "Checking Account";
        } else if (accountNumber >= 3000 && accountNumber <= 3999) {
            accountType = "Business Account";
        }
        return accountType;
    }

    public double calculateOverdraftFee(double balance) {
        if (balance < 0) {
            return -50.0;
        } else {
            return 0.0;
        }
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }

    public void withdrawAndApplyFees(double amount) {
        double overdraftFee = calculateOverdraftFee(balance);
        balance -= amount + overdraftFee;
        System.out.println("Withdrawal successful. New balance: " + balance);
    }

    public static final String SAVINGS = "Savings Account";
    public static final String CHECKING = "Checking Account";
    public static final String BUSINESS = "Business Account";

    public String getAccountTypeName(String accountType) {
        if (accountType.equals(SAVINGS)) {
            return "Savings";
        } else if (accountType.equals(CHECKING)) {
            return "Checking";
        } else if (accountType.equals(BUSINESS)) {
            return "Business";
        } else {
            return "Unknown";
        }
    }
}
