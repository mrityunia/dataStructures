package com.smartcity.interview;

public class Demo {
    public static void main(String[] args) {

        Payable payment = new CreditCardPayment();
        payment.pay();          // from abstract class
        ((Refundable) payment).refund();// from subclass
        ((CreditCardPayment) payment).own();// from subclass
    }
}
