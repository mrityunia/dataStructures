package theroy.VehicleManagement;

public class Main {
    static {
        System.out.println("🔧 [Class Main loaded]");
    }
    public static void main(String[] args) {
//
//        System.out.println("===== Case 1: Default Constructor =====");
//        Car c1 = new Car();
//        c1.showCarDetails();

//        System.out.println("\n===== Case 2: Parameterized Constructor =====");
//        Car c2 = new Car("Honda", 120, "Civic", 6);
//        c2.showCarDetails();
//
//        System.out.println("\n===== Case 3: Constructor Chaining =====");
//        Car c3 = new Car("Fortuner");
//        c3.showCarDetails();

//        System.out.println("===== Case 1: Default Constructor =====");
//        ElectricCar e1 = new ElectricCar();
//        e1.showElectricCarDetails();
//
//        System.out.println("\n===== Case 2: Parameterized Constructor =====");
//        ElectricCar e2 = new ElectricCar("BMW", 180, "i4", 1, 90, 550);
//        e2.showElectricCarDetails();
//
//        System.out.println("\n===== Case 3: Constructor Chaining (this + super) =====");
//        ElectricCar e3 = new ElectricCar("Model S");
//        e3.showElectricCarDetails();

        Vehicle mahindra  = new ElectricCar();
        mahindra.showDetails();

        ElectricCar tesla  = (ElectricCar)mahindra;
        tesla.showElectricCarDetails();

    }


    //🚘 Vehicle: Default constructor called
//🚗 Car: Default constructor called
//Brand "Unknow" speed 4
// Model Statndar . gears = 4


    //2
    //🚘 Vehicle: Parameterized constructor called
    //🚗 Car: Parameterized constructor called
    //Brand "Honda" speed 120
    //Model Civic . gears = 6

//3
    //🚘 Vehicle: Parameterized constructor called
    //🚗 Car: Parameterized constructor called
   // Brand "Toyota" speed 80
    //Model Fortuner . gears = 5

}
