package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        CurrentAccount CA = new CurrentAccount("curr",10000,"ZZY");
        CA.validateLicenseId();
        System.out.println(CA.getTradeLicenseId());
    }
}