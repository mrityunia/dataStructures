package transport;

public abstract class Vehicle implements Maintainable{
    protected String brand;
    protected int wheels;

    // Constructor
    public Vehicle(String brand, int wheels) {
        this.brand = brand;
        this.wheels = wheels;
        System.out.println("🚘 Vehicle Constructor: " + brand);
    }

    // Abstract methods (must be implemented)
    public abstract void start();
    public abstract void stop();

    // Common method
    public void showInfo() {
        System.out.println("Vehicle: " + brand + " | Wheels: " + wheels);
    }
}
