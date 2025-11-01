package com.smartcity.interview;

public class CreditCardPayment extends OnlineTransaction {

    @Override
    public void refund() {
        System.out.println("Refunding to credit card...");
    }
    public void own() {
        System.out.println("Own Refunding ...");
    }

}
