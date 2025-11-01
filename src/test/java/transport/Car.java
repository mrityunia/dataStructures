package transport;

public class Car extends Vehicle{
    protected int seatCount;

    Car(String brand, int seatCount) {
        super(brand, 4); // Calls Vehicle constructor
        this.seatCount = seatCount;
        System.out.println("🚗 Car Constructor");
    }
    @Override
    public void start() {
        System.out.println(brand + " Car starting with key ignition...");
    }

    @Override
    public void stop() {
        System.out.println(brand + " Car stopped.");
    }
    @Override
    public void performMaintenance() {
        System.out.println(brand + " Car servicing done.");
    }
 }
