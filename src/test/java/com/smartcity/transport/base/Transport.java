package com.smartcity.transport.base;

public abstract class Transport {
    protected String id;
    protected String type;

    public Transport(String id, String type) {
        this.id = id;
        this.type = type;
        System.out.println("🚦 Transport Created: " + type);
    }

    public abstract void start();
    public abstract void stop();

    public void showInfo() {
        System.out.println("Interface Transport [ID=" + id + ", Type=" + type + "]");
    }
}
