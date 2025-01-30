import javax.swing.*;
import java.awt.*;

public class Lab_5 {
    public static void lab_5() {
        JFrame frame = new JFrame("Оформлення замовлення");
        frame.setSize(450, 310);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(220, 230, 200));

        ImageIcon imageIcon = new ImageIcon("src/resources/korzina.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(380, 10, 50, 50);
        frame.add(imageLabel);

        JLabel titleLabel = new JLabel("Оформлення замовлення");
        titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 18));
        titleLabel.setForeground(new Color(0, 128, 0));
        titleLabel.setBounds(20, 10, 250, 25);
        frame.add(titleLabel);

        JLabel contactLabel = new JLabel("Контактні дані");
        contactLabel.setFont(new Font("Serif", Font.BOLD, 14));
        contactLabel.setBounds(50, 40, 150, 20);
        frame.add(contactLabel);

        JSeparator separator = new JSeparator();
        separator.setForeground(new Color(111, 205, 39));
        separator.setBounds(20, 65, 400, 10);
        frame.add(separator);

        JLabel nameLabel = new JLabel("Прізвище та ім'я:", SwingConstants.RIGHT);
        nameLabel.setBounds(20, 80, 120, 20);
        frame.add(nameLabel);
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 80, 250, 22);
        frame.add(nameField);

        JLabel cityLabel = new JLabel("Місто:", SwingConstants.RIGHT);
        cityLabel.setBounds(20, 110, 120, 20);
        frame.add(cityLabel);
        String[] cities = {"Київ", "Львів", "Одеса", "Харків"};
        JComboBox<String> cityDropdown = new JComboBox<>(cities);
        cityDropdown.setBounds(150, 110, 150, 22);
        cityDropdown.setSelectedIndex(-1);
        frame.add(cityDropdown);

        JLabel phoneLabel = new JLabel("Телефон:", SwingConstants.RIGHT);
        phoneLabel.setBounds(20, 140, 120, 20);
        frame.add(phoneLabel);
        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 140, 200, 22);
        frame.add(phoneField);

        JLabel emailLabel = new JLabel("E-mail:", SwingConstants.RIGHT);
        emailLabel.setBounds(20, 170, 120, 20);
        frame.add(emailLabel);
        JTextField emailField = new JTextField();
        emailField.setBounds(150, 170, 200, 22);
        frame.add(emailField);

        JCheckBox newsletterCheckBox = new JCheckBox("Я хочу отримувати розсилку інтернет-магазину To4ka");
        newsletterCheckBox.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 10));
        newsletterCheckBox.setBounds(20, 210, 380, 20);
        newsletterCheckBox.setBackground(new Color(220, 230, 200));
        frame.add(newsletterCheckBox);

        JButton submitButton = new JButton("OK");
        submitButton.setBounds(340, 230, 80, 30);
        frame.add(submitButton);

        submitButton.addActionListener(e -> {
            if (nameField.getText().isEmpty() || cityDropdown.getSelectedIndex() == -1 ||
                    phoneField.getText().isEmpty() || emailField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Будь ласка, заповніть всі поля!");
            } else {
                System.out.println("Прізвище та ім'я: " + nameField.getText());
                System.out.println("Місто: " + cities[cityDropdown.getSelectedIndex()]);
                System.out.println("Телефон: " + phoneField.getText());
                System.out.println("E-mail: " + emailField.getText());
                System.out.println("Розсилка: " + (newsletterCheckBox.isSelected() ? "ТАК" : "НІ"));
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }
}
