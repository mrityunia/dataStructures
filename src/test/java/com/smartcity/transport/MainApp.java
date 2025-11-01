package com.smartcity.transport;

import com.smartcity.transport.base.Transport;
import com.smartcity.transport.implementations.Drone;
import com.smartcity.transport.implementations.ElectricCar;
import com.smartcity.transport.implementations.MetroTrain;
import com.smartcity.transport.interfaces.Connectable;
import com.smartcity.transport.interfaces.Maintainable;
import com.smartcity.transport.interfaces.SmartOperable;

public class MainApp {

    public static void main(String[] args) {
        Transport car = new ElectricCar("EV001", 85, 4);
        Transport train = new MetroTrain("MT100", 100, 10);
        Transport drone = new Drone("DR500", 120);

        System.out.println("\n🔹 --- Transport Information ---");
        car.showInfo();
        train.showInfo();
        drone.showInfo();

        System.out.println("\n🔹 --- Starting all Transports ---");
        car.start();
        train.start();
        drone.start();

        System.out.println("\n🔹 --- Maintenance Operations ---");
        ((Maintainable) car).performMaintenance();
        ((Maintainable) train).performMaintenance();

//        if (car instanceof Maintainable) ((Maintainable) car).performMaintenance();
//        if (train instanceof Maintainable) ((Maintainable) train).performMaintenance();

        System.out.println("\n🔹 --- Network Connectivity ---");
        if (car instanceof Connectable) ((Connectable) car).connectToNetwork("EV-NET");
        if (drone instanceof Connectable) ((Connectable) drone).connectToNetwork("DRONE-CONTROL");

        System.out.println("\n🔹 --- Downcasting Demo ---");
        if (drone instanceof Drone) {
            ((Drone) drone).captureFootage();
        }

        System.out.println("\n🔹 --- Smart Diagnostics ---");
        if (car instanceof SmartOperable) ((SmartOperable) car).runDiagnostics();

        System.out.println("\n🔹 --- Stop All ---");
        car.stop();
        train.stop();
        drone.stop();

    }
}
