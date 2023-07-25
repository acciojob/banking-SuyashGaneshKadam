package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        BankAccount BA = new BankAccount("SK", 1000, 500);
        System.out.println(BA.generateAccountNumber(10,1));
    }
}