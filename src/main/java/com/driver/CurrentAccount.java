package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        if(balance < 5000)
        {
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        int n = this.tradeLicenseId.length();
        boolean isValid = true;
        for(int i=0 ; i<n-1 ; i++)
        {
            if(this.tradeLicenseId.charAt(i) == this.tradeLicenseId.charAt(i+1))
            {
                isValid = false;
            }
        }
        if(isValid)
        {
            return;
        }
        else
        {

        }
    }

}
