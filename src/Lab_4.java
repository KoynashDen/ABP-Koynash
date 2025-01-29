import javax.swing.*;
import java.awt.*;

public class Lab_4 extends JPanel {
    private int excellent = 8;
    private int good = 12;
    private int zadovilno = 4;
    private int bad = 6;

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
        graph.setColor(Color.yellow);
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

        graph.setColor(Color.black);
        graph.drawLine(0, 250, 600, 250);
    }
    public static void lab_4() {
        JFrame frame = new JFrame("Графік успішності студентів");
        Lab_4 graph = new Lab_4();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(graph);
        frame.setVisible(true);
    }
}
