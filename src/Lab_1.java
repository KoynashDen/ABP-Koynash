import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lab_1 {
    public static void lab_1() {
        Lab_1 task = new Lab_1();
        task.task1();
        task.task2();
        task.task3();
        task.task4();
        task.task5();
    }

    private int getIntInput(Scanner scanner, String prompt) {
        int num;
        while (true) {
            try {
                System.out.print(prompt);
                num = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Помилка! Введіть лише ціле число.");
                scanner.next();
            }
        }
        return num;
    }

    public void task1() {
        System.out.println("Завдання 1");
        Scanner scanner = new Scanner(System.in);
        int x1 = getIntInput(scanner, "x1 = ");
        int y1 = getIntInput(scanner, "y1 = ");
        int x2 = getIntInput(scanner, "x2 = ");
        int y2 = getIntInput(scanner, "y2 = ");

        int x3 = (x1 + x2) / 2;
        int y3 = (y1 + y2) / 2;
        System.out.println("x3 = " + x3 + ", y3 = " + y3);
    }

    public void task2() {
        System.out.println("Завдання 2");
        Scanner scanner = new Scanner(System.in);
        int x = getIntInput(scanner, "x = ");
        int y = getIntInput(scanner, "y = ");
        int z = getIntInput(scanner, "z = ");

        int[] arr = {x, y, z};
        java.util.Arrays.sort(arr);
        System.out.println(arr[2] + "," + arr[1] + "," + arr[0]);
    }

    public void task3() {
        System.out.println("Завдання 3");
        Scanner scanner = new Scanner(System.in);
        int x = getIntInput(scanner, "x = ");
        int y = getIntInput(scanner, "y = ");

        for (int i = x; i <= y; i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nКількість: " + (y - x + 1));
    }

    public void task4() {
        System.out.println("Завдання 4");
        Scanner scanner = new Scanner(System.in);
        int n = getIntInput(scanner, "N = ");
        int[] array = new int[n];
        Random random = new Random();
        int[] counts = new int[4];

        System.out.println("Масив:");
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(4);
            counts[array[i]]++;
            System.out.print(array[i] + " ");
        }

        System.out.println("\nКількість 0,1,2,3(відповідно): " + counts[0] + "," + counts[1] + "," + counts[2] + "," + counts[3]);
    }

    public void task5() {
        System.out.println("Завдання 5");
        double maxSquare = 0;
        int maxTriangle = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введіть координати " + i + " трикутника:");
            int x1 = getIntInput(scanner, "x1 = ");
            int y1 = getIntInput(scanner, "y1 = ");
            int x2 = getIntInput(scanner, "x2 = ");
            int y2 = getIntInput(scanner, "y2 = ");
            int x3 = getIntInput(scanner, "x3 = ");
            int y3 = getIntInput(scanner, "y3 = ");

            double area = square(x1, y1, x2, y2, x3, y3);
            if (area > maxSquare) {
                maxSquare = area;
                maxTriangle = i;
            }
        }
        System.out.println("Найбільша площа у " + maxTriangle + " трикутника");
    }

    public double square(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0;
    }
}
