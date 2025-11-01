package com.smartcity.transport.implementations;

import com.smartcity.transport.base.MotorizedTransport;
import com.smartcity.transport.interfaces.SmartOperable;

public class ElectricCar extends MotorizedTransport implements SmartOperable {

    private int passengers;

    public ElectricCar(String id, double batteryLevel, int passengers) {
        super(id, "Electric Car", batteryLevel);
        this.passengers = passengers;
        System.out.println("🚗 ElectricCar ready for service with " + passengers + " seats.");
    }
    @Override
    public void start() {
        System.out.println("ElectricCar " + id + " starting silently ⚡...");
    }

    @Override
    public void stop() {
        System.out.println("ElectricCar " + id + " stopped.");
    }

    @Override
    public void refuelOrRecharge() {
        System.out.println("Charging ElectricCar to " + fuelOrBatteryLevel + "% battery.");
    }

    @Override
    public void performMaintenance() {
        System.out.println("Running EV diagnostics & software update...");
        maintenanceLog();
    }

    @Override
    public void connectToNetwork(String networkName) {
        System.out.println("ElectricCar connected to network: " + networkName);
    }
    @Override
    public void disconnect() {
        System.out.println("ElectricCar disconnected from network.");
    }
    @Override
    public void runDiagnostics() {
        System.out.println("Checking motor, sensors, and battery health ✅");
    }
}
