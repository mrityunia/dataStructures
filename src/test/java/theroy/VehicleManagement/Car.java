package theroy.VehicleManagement;

public class Car extends Vehicle{
    String model;
    int gears;
    static {
        System.out.println("🔧🔧 🔧🔧🔧🔧🔧 [Car class loaded]");
    }
    // 3️⃣ Default Constructor (calls super())
    Car () {
        System.out.println("🚗 Car: Default constructor called");
        this.model = "Standard";
        this.gears = 4;
    }

    // 4️⃣ Parameterized Constructor (calls super(brand, speed))
    Car(String brand, int speed, String model, int gears) {
        super(brand, speed);
        System.out.println("🚗 Car: Parameterized constructor called");
        this.model = model;
        this.gears = gears;
    }

    // 5️⃣ Constructor Overloading + this() chaining
    Car(String model) {
        this("Toyota", 80, model, 5); // calls the other Car() constructor
        System.out.println("🚗 Car: Overloaded constructor with model called");
    }

    void showCarDetails() {
        super.showDetails();
        System.out.println("Model: " + model + ", Gears: " + gears);
    }
}
