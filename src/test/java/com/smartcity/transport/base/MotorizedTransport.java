package com.smartcity.transport.base;

public abstract class MotorizedTransport extends Transport {

    protected double fuelOrBatteryLevel;

    public MotorizedTransport(String id, String type, double level) {
        super(id, type);
        this.fuelOrBatteryLevel = level;
        System.out.println("⚙️ Motorized Transport initialized with energy level: " + level);
    }
    public abstract void refuelOrRecharge();
}
