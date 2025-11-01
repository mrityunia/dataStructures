package theroy.VehicleManagement;

public class Vehicle {
    String brand;
    int speed;

    static {
        System.out.println("🔧 🔧 🔧🔧🔧🔧🔧[Vehicle class loaded]");
    }
    // 1️⃣ Default Constructor
    Vehicle () {
        System.out.println("🚘 Vehicle: Default constructor called");
        this.brand = "Unknown";
        this.speed = 0;
    }

    // 2️⃣ Parameterized Constructor
    Vehicle(String brand, int speed) {
        System.out.println("🚘 Vehicle: Parameterized constructor called");
        this.brand = brand;
        this.speed = speed;
    }

    void showDetails() {
        System.out.println("Brand: " + brand + ", Speed: " + speed + " km/h");
    }
}


