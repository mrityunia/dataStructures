package com.smartcity.interview;

public abstract class OnlineTransaction implements Payable, Refundable{
    public void pay() {
        System.out.println("Processing online payment...");
    }
    // refund() left unimplemented

}
