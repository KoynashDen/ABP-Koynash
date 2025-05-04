import java.util.InputMismatchException;
import java.util.Scanner;

interface Run {
    void showName();
    int getSpeed();
    int getMass();
    int getPassengers();
    int propellers();
}

abstract class Transport implements Run {
    protected static final int MaxSpeed = 400;
    protected static final int MinSpeed = 0;
    protected static final int MaxPassengers = 40;
    protected static final int MinPassengers = 0;

    protected String name;
    protected int speed;

    public Transport(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public void showName() {
        System.out.println("Назва: " + name);
    }
}

class Helicopter extends Transport {
    protected int mass;
    protected int passengers;
    protected int propellers;

    public Helicopter(String name, int speed, int mass, int passengers, int propellers) {
        super(name, speed);
        this.mass = mass;
        this.passengers = passengers;
        this.propellers = propellers;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getMass() {
        return mass;
    }

    @Override
    public int getPassengers() {
        return passengers;
    }

    @Override
    public int propellers() {
        return propellers;
    }
}

class Cargo extends Helicopter {
    public Cargo(String name, int speed, int mass, int passengers, int propellers) {
        super(name, speed, mass, passengers, propellers);
    }
}

class   Army extends Helicopter {
    public Army(String name, int speed, int mass, int passengers, int propellers) {
        super(name, speed, mass, passengers, propellers);
    }
}

public class Lab_3 {
    private static int getIntInput(Scanner scanner, String prompt) {
        int num;
        while (true) {
            try {
                System.out.print(prompt);
                num = scanner.nextInt();
                if (num > 0) {
                    break;
                } else {
                    System.out.println("Помилка! Введіть число більше 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка! Введіть лише ціле число.");
                scanner.next();
            }
        }
        return num;
    }

    public static void lab_3() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть параметри для вантажного гелікоптера:");
        String cargoName = "Cargo";
        int cargoSpeed = getIntInput(scanner, "Швидкість: ");
        int cargoMass = getIntInput(scanner, "Маса: ");
        int cargoPassengers = getIntInput(scanner, "Пасажиромісткість: ");
        int cargoPropellers = getIntInput(scanner, "Кількість пропелерів: ");
        Cargo cargo = new Cargo(cargoName, cargoSpeed, cargoMass, cargoPassengers, cargoPropellers);

        System.out.println();

        System.out.println("Введіть параметри для військового гелікоптера:");
        String armyName = "Army";
        int armySpeed = getIntInput(scanner, "Швидкість: ");
        int armyMass = getIntInput(scanner, "Маса: ");
        int armyPassengers = getIntInput(scanner, "Пасажиромісткість: ");
        int armyPropellers = getIntInput(scanner, "Кількість пропелерів: ");
        Army army = new Army(armyName, armySpeed, armyMass, armyPassengers, armyPropellers);

        System.out.println();

        cargo.showName();
        System.out.println("Швидкість: " + cargo.getSpeed() + " км/год");
        System.out.println("Маса: " + cargo.getMass() + " кг");
        System.out.println("Пасажиромісткість: " + cargo.getPassengers());
        System.out.println("Кількість пропелерів: " + cargo.propellers());

        System.out.println();

        army.showName();
        System.out.println("Швидкість: " + army.getSpeed() + " км/год");
        System.out.println("Маса: " + army.getMass() + " кг");
        System.out.println("Пасажиромісткість: " + army.getPassengers());
        System.out.println("Кількість пропелерів: " + army.propellers());

        scanner.close();
    }
}