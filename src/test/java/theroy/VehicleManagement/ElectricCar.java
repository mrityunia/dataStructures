package theroy.VehicleManagement;

public class ElectricCar extends Car{
    int batteryCapacity;
    int range;


    // Parameterized constructor
    ElectricCar(String brand, int speed, String model, int gears, int batteryCapacity, int range) {
        super(brand, speed, model, gears); // calls Car(brand, speed, model, gears)
        System.out.println("⚡ ElectricCar: Parameterized constructor called");
        this.batteryCapacity = batteryCapacity;
        this.range = range;
    }

    // Default constructor
    ElectricCar() {
        super(); // calls Car()
        System.out.println("⚡ ElectricCar: Default constructor called");
        this.batteryCapacity = 50;
        this.range = 200;
    }

    // Constructor chaining inside subclass
    ElectricCar(String model) {
        this("Tesla", 200, model, 1, 100, 400); // chaining to another constructor
        System.out.println("⚡ ElectricCar: Overloaded constructor with model called");
    }

    void showElectricCarDetails() {
        super.showCarDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
        System.out.println("Range: " + range + " km");
    }

    static {
        System.out.println("🔧 🔧🔧🔧🔧🔧[ElectricCar class loaded]");
    }
}
