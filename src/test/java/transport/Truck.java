package transport;

public class Truck extends Vehicle{
    private double loadCapacity;

    public Truck(String brand, double loadCapacity) {
        super(brand, 6);
        this.loadCapacity = loadCapacity;
        System.out.println("🚛 Truck Constructor");
    }

    @Override
    public void start() {
        System.out.println(brand + " Truck roaring to life...");
    }

    @Override
    public void stop() {
        System.out.println(brand + " Truck braking...");
    }

    @Override
    public void performMaintenance() {
        System.out.println(brand + " Truck oil change completed.");
    }
}
