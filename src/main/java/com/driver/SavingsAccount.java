package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;
    double totalWithdraw;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name, balance, 0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.totalWithdraw = 0;
    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public double getTotalWithdraw() {
        return totalWithdraw;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(totalWithdraw + amount > maxWithdrawalLimit)
        {
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        else
        {
            super.withdraw(amount);
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double balance = super.getBalance();
        double simpleInterest = (balance * rate * years) / (double)100;
        return simpleInterest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double balance = super.getBalance();
        double compoundInterest = Math.pow(balance * (1 + (rate/times)),times * years);
        return compoundInterest;
    }

}
