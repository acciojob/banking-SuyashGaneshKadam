package com.driver;

public class Main {
    public static void main(String[] args) throws Exception {
        CurrentAccount CA = new CurrentAccount("SK",10000, "AABBCC");
        CA.validateLicenseId();
        System.out.println(CA.getTradeLicenseId());
    }
}