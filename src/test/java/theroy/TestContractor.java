package theroy;

public class TestContractor {

    public static void main(String[] args) {
        ReturnConstructor rc2 = new ReturnConstructor(-10);
       // rc2.printNumber();
        ReturnConstructor rc1 = new ReturnConstructor(100);
     //   rc1.printNumber();


    }
}

class Super {
    Super() {
        System.out.println("Super ctor");
    }

    int x = initX();

    int initX() {
        System.out.println("initX");
        return 1;
    }
}

class Sub extends Super {
    int y = initY();

    Sub() {
        System.out.println("Sub ctor");
    }

    int initY() {
        System.out.println("initY");
        return 2;
    }
}

class ReturnConstructor {
    int number = 10;

    ReturnConstructor(int number) {
        if (number < 0) {
            return;
        } else {
            this.number = this.number + number;
        }
        System.out.println("Exit from Constructor");
    }

    public void printNumber() {
        System.out.println(number);
    }
}

