package com.smartcity.transport.implementations;

import com.smartcity.transport.base.Transport;
import com.smartcity.transport.interfaces.Connectable;

public class Drone extends Transport implements Connectable {
    private double altitudeLimit;

    public Drone(String id, double altitudeLimit) {
        super(id, "Drone");
        this.altitudeLimit = altitudeLimit;
        System.out.println("🛸 Drone initialized with altitude limit: " + altitudeLimit + "m");
    }

    @Override
    public void start() {
        System.out.println("Drone " + id + " taking off...");
    }

    @Override
    public void stop() {
        System.out.println("Drone " + id + " landing...");
    }

    @Override
    public void connectToNetwork(String networkName) {
        System.out.println("Drone connected to 5G control network: " + networkName);
    }

    @Override
    public void disconnect() {
        System.out.println("Drone disconnected from network.");
    }

    public void captureFootage() {
        System.out.println("Drone capturing aerial footage at altitude " + altitudeLimit + "m 🎥");
    }
}
