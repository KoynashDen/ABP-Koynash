interface Run{
    void showName();
    int getSpeed();
    int getMass();
    int getPassengers();
    int propellers();
}

abstract class Transport implements Run{
    protected static final int MaxSpeed = 400;
    protected static final int MinSpeed = 0;
    protected static final int MaxPassengers = 40;
    protected static final int MinPassengers = 0;

    protected String name;
    protected int speed;

    public Transport(String name, int speed){
        this.name = name;
        this.speed = speed;
    }

    public void showName(){
        System.out.println("Назва: "+name);
    }


}
class Helicopter extends Transport{
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


class Cargo extends Helicopter{

    public Cargo() {
        super("Cargo", 210, 4000, 4, 2);
    }
}

class Army extends Helicopter{
    public Army() {
        super("Army", 300, 3000, 2, 1);
    }
}
public class Lab_3 {
    public static void lab_3() {
        Cargo cargo = new Cargo();
        Army army = new Army();

        cargo.showName();
        System.out.println("Швидкість: " + cargo.getSpeed() + " км/год");
        System.out.println("Маса: " + cargo.getMass() + " кг");
        System.out.println("Пасажиромісткість: " + cargo.getPassengers());
        System.out.println("Кількість пропелерів: " + cargo.propellers());

        army.showName();
        System.out.println("Швидкість: " + army.getSpeed() + " км/год");
        System.out.println("Маса: " + army.getMass() + " кг");
        System.out.println("Пасажиромісткість: " + army.getPassengers());
        System.out.println("Кількість пропелерів: " + army.propellers());
    }
}
