package com.smartcity.transport.implementations;

import com.smartcity.transport.base.MotorizedTransport;
import com.smartcity.transport.interfaces.Maintainable;

public class MetroTrain extends MotorizedTransport implements Maintainable {

    private int coaches;

    public MetroTrain(String id, double electricityLevel, int coaches) {
        super(id, "Metro Train", electricityLevel);
        this.coaches = coaches;
        System.out.println("🚉 MetroTrain ready with " + coaches + " coaches.");
    }

    @Override
    public void start() {
        System.out.println("MetroTrain " + id + " departing from station.");
    }

    @Override
    public void stop() {
        System.out.println("MetroTrain " + id + " stopped at terminal station.");
    }

    @Override
    public void refuelOrRecharge() {
        System.out.println("Recharging MetroTrain grid connection at depot...");
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing MetroTrain brake system and powerline checks.");
    }
}
