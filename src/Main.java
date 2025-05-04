import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Меню лабораторних");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);
            frame.setLayout(new GridLayout(4, 2, 10, 10));
            frame.getContentPane().setBackground(new Color(230, 230, 250));

            for (int i = 1; i <= 11; i++) {
                int labNumber = i;
                JButton button = new JButton("Лабораторка " + i);
                button.setFont(new Font("Arial", Font.BOLD, 14));
                button.setBackground(new Color(100, 149, 237));
                button.setForeground(Color.WHITE);
                button.setFocusPainted(false);
                button.addActionListener(e -> openLab(labNumber, frame));
                frame.add(button);
            }

            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static void openLab(int labNumber, JFrame parentFrame) {
        parentFrame.dispose();
        switch (labNumber) {
            case 1 -> Lab_1.lab_1();
            case 2 -> Lab_2.lab_2();
            case 3 -> Lab_3.lab_3();
            case 4 -> Lab_4.lab_4();
            case 5 -> Lab_5.lab_5();
            case 6 -> Lab_6.lab_6();
            case 7 -> new Lab_7.FirstForm();
            case 8 -> SwingUtilities.invokeLater(Lab_8::lab_8);
            case 9 -> org.example.App.main();
            case 10 -> Lab_10.lab_10();
            case 11 -> org.example.Lab_11.lab_11();
            default -> JOptionPane.showMessageDialog(null, "Неправильний номер лабораторної", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }
}
