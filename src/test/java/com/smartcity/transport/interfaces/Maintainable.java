package com.smartcity.transport.interfaces;

public interface Maintainable {

    void performMaintenance();

    default void maintenanceLog() {
        System.out.println("🧾 Default log: Maintenance completed successfully.");
    }
}
