
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть номер лаболаторки: ");
        int numOfLab = scanner.nextInt();

        switch (numOfLab) {
            case 1:
                Lab_1.lab_1();
                break;
            default:
                System.out.println("Неправильний номер варіанту(");

        }
    }
}