package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lab_11 {

    public static void lab_11() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nЛабораторна 11 - Меню завдань:");
            System.out.println("1. Сума перших 10 членів геометричної прогресії");
            System.out.println("2. Визначення координатної чверті");
            System.out.println("3. Обчислення добутку (1+1/(n^2))");
            System.out.println("4. Вивести всі прості числа менші 100");
            System.out.println("5. Точки всередині трикутника ABC");
            System.out.println("0. Вихід");
            System.out.print("Оберіть опцію: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    double result = sumOfGeometricProgression(2, 0.5, 10);
                    System.out.println("Сума: " + result);
                }
                case 2 -> {
                    System.out.print("Введіть x: ");
                    double x = scanner.nextDouble();
                    System.out.print("Введіть y: ");
                    double y = scanner.nextDouble();
                    int quarter = quadrant(x, y);
                    System.out.println("Чверть: " + quarter);
                }
                case 3 -> {
                    System.out.print("Введіть n: ");
                    int n = scanner.nextInt();
                    double result = computeProduct(n);
                    System.out.println("Добуток: " + result);
                }
                case 4 -> {
                    List<Integer> primes = getPrimesUnder100();
                    System.out.println("Прості числа < 100: " + primes);
                }
                case 5 -> {
                    List<int[]> points = pointsInsideTriangle();
                    System.out.println("Точки всередині трикутника ABC:");
                    for (int[] p : points) {
                        System.out.println("(" + p[0] + ", " + p[1] + ")");
                    }
                }
                case 0 -> {
                    System.out.println("Вихід...");
                    return;
                }
                default -> System.out.println("Невірна опція. Спробуйте знову.");
            }
        }
    }

    public static double sumOfGeometricProgression(double b1, double q, int n) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += b1 * Math.pow(q, i);
        }
        return sum;
    }

    public static int quadrant(double x, double y) {
        if (x > 0 && y > 0) return 1;
        if (x < 0 && y > 0) return 2;
        if (x < 0 && y < 0) return 3;
        if (x > 0 && y < 0) return 4;
        return 0; // якщо на осі
    }

    public static double computeProduct(int n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= (1 + 1.0 / (i * i));
        }
        return result;
    }

    public static List<Integer> getPrimesUnder100() {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) primes.add(i);
        }
        return primes;
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static List<int[]> pointsInsideTriangle() {
        int[][] triangle = {{2, 3}, {-2, 3}, {0, -1}};
        List<int[]> result = new ArrayList<>();
        for (int x = -2; x <= 2; x++) {
            for (int y = -1; y <= 3; y++) {
                if (isInsideTriangle(x, y, triangle)) {
                    result.add(new int[]{x, y});
                }
            }
        }
        return result;
    }

    private static boolean isInsideTriangle(int x, int y, int[][] t) {
        double area = triangleArea(t[0], t[1], t[2]);
        double a1 = triangleArea(new int[]{x, y}, t[1], t[2]);
        double a2 = triangleArea(t[0], new int[]{x, y}, t[2]);
        double a3 = triangleArea(t[0], t[1], new int[]{x, y});
        return Math.abs((a1 + a2 + a3) - area) < 1e-6;
    }

    private static double triangleArea(int[] a, int[] b, int[] c) {
        return Math.abs((a[0] * (b[1] - c[1]) +
                b[0] * (c[1] - a[1]) +
                c[0] * (a[1] - b[1])) / 2.0);
    }
}
