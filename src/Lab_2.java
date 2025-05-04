import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_2 {
    private double a, b;

    public Lab_2(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public boolean IfOnLine(double x, double y) {
        return y == a * x + b;
    }

    public double[] intersection(Lab_2 other) {
        if (this.a == other.a) return null;
        double x = (other.b - this.b) / (this.a - other.a);
        return new double[]{x, a * x + b};
    }

    private static double getDoubleInput(Scanner scanner, String prompt) {
        double num;
        while (true) {
            try {
                System.out.print(prompt);
                num = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Помилка! Введіть лише число.");
                scanner.next();
            }
        }
        return num;
    }

    public static void lab_2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть параметри для першої прямої (y = ax + b):");
        double a1 = getDoubleInput(scanner, "a1: ");
        double b1 = getDoubleInput(scanner, "b1: ");
        Lab_2 line1 = new Lab_2(a1, b1);

        System.out.println("Введіть параметри для другої прямої (y = ax + b):");
        double a2 = getDoubleInput(scanner, "a2: ");
        double b2 = getDoubleInput(scanner, "b2: ");
        Lab_2 line2 = new Lab_2(a2, b2);

        System.out.println("Введіть координати точки для перевірки її належності першій і другій прямим:");
        double x = getDoubleInput(scanner, "x: ");
        double y = getDoubleInput(scanner, "y: ");

        System.out.println("Точка (" + x + ", " + y + ") " + (line1.IfOnLine(x, y) ? "належить" : "не належить") + " прямій 1");
        System.out.println("Точка (" + x + ", " + y + ") " + (line2.IfOnLine(x, y) ? "належить" : "не належить") + " прямій 2");

        double[] intersection = line1.intersection(line2);
        if (intersection != null) {
            System.out.println("Перетин: (" + intersection[0] + ", " + intersection[1] + ")");
        } else {
            System.out.println("Прямі паралельні");
        }

        scanner.close();
    }
}
