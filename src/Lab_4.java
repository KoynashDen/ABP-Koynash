import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_4 extends JPanel {
    private int excellent;
    private int good;
    private int zadovilno;
    private int bad;

    public Lab_4(int excellent, int good, int zadovilno, int bad) {
        this.excellent = excellent;
        this.good = good;
        this.zadovilno = zadovilno;
        this.bad = bad;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graph = (Graphics2D) g;

        Font font = new Font("Arial", Font.BOLD, 14);
        graph.setFont(font);

        graph.setStroke(new BasicStroke(3));

        int x = 120;

        graph.setColor(Color.GREEN);
        graph.drawLine(x, 250, x, 250 - excellent * 10);
        graph.setColor(Color.RED);
        graph.drawString(String.valueOf(excellent), x - 5, 250 - excellent * 10 - 5);

        x += 100;
        graph.setColor(Color.YELLOW);
        graph.drawLine(x, 250, x, 250 - good * 10);
        graph.setColor(Color.RED);
        graph.drawString(String.valueOf(good), x - 5, 250 - good * 10 - 5);

        x += 100;
        graph.setColor(Color.ORANGE);
        graph.drawLine(x, 250, x, 250 - zadovilno * 10);
        graph.setColor(Color.RED);
        graph.drawString(String.valueOf(zadovilno), x - 5, 250 - zadovilno * 10 - 5);

        x += 100;
        graph.setColor(Color.RED);
        graph.drawLine(x, 250, x, 250 - bad * 10);
        graph.drawString(String.valueOf(bad), x - 5, 250 - bad * 10 - 5);

        graph.setColor(Color.BLACK);
        graph.drawLine(0, 250, 600, 250);
    }

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

    public static void lab_4() {
        Scanner scanner = new Scanner(System.in);

        int excellent = getIntInput(scanner, "Введіть кількість студентів з оцінкою 'відмінно': ");
        int good = getIntInput(scanner, "Введіть кількість студентів з оцінкою 'добре': ");
        int zadovilno = getIntInput(scanner, "Введіть кількість студентів з оцінкою 'задовільно': ");
        int bad = getIntInput(scanner, "Введіть кількість студентів з оцінкою 'незадовільно': ");

        JFrame frame = new JFrame("Графік успішності студентів");
        Lab_4 graph = new Lab_4(excellent, good, zadovilno, bad);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(graph);
        frame.setVisible(true);

        scanner.close();
    }
}
