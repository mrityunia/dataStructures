package transport;

public class ElectricCar extends Car {
    private int batteryLevel;

    ElectricCar (String brand, int seatCount, int batteryLevel) {
        super(brand, seatCount);
        this.batteryLevel = batteryLevel;
        System.out.println("⚡ ElectricCar Constructor");
    }

    @Override
    public void start() {
        System.out.println(brand + " ElectricCar starting silently...");
    }

    @Override
    public void performMaintenance() {
        System.out.println(brand + " ElectricCar battery check completed.");
    }

    public void chargeBattery() {
        System.out.println(brand + " ElectricCar charging battery to " + batteryLevel + "%");
    }
}
