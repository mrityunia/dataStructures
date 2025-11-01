package transport;

public class MainApp {
    public static void main(String[] args) {
        Vehicle car = new Car("Toyota", 5);
        Vehicle truck = new Truck("Volvo", 10000);
        Vehicle electric = new ElectricCar("Tesla", 5, 90);

        System.out.println("\n🔹 --- Vehicle Details ---");
        car.showInfo();
        truck.showInfo();
        electric.showInfo();

        System.out.println("\n🔹 --- Polymorphism in Action ---");
        car.start();
        truck.start();
        electric.start();

        System.out.println("\n🔹 --- Maintenance ---");
        car.performMaintenance();
        truck.performMaintenance();
        electric.performMaintenance();

        // Downcasting example
        if (electric instanceof ElectricCar) {
            ElectricCar e = (ElectricCar) electric;
            e.chargeBattery();
        }
    }
}
