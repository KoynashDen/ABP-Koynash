
import javax.swing.*;
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
            case 2:
                Lab_2.lab_2();
                break;
            case 3:
                Lab_3.lab_3();
                break;
            case 4:
                Lab_4.lab_4();
                break;
            case 5:
                Lab_5.lab_5();
                break;
            case 6:
                Lab_6.lab_6();
                break;
            case 7:
                new Lab_7.FirstForm();
                break;
            case 8:
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Lab_8.lab_8();
                    }
                });
                break;
            default:
                System.out.println("Неправильний номер варіанту(");

        }
    }
}