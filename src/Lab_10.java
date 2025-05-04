import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Lab_10 {
    public static void lab_10() {
        JFrame frame = new JFrame("Простий Текстовий Редактор");
        frame.setSize(700, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);


        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        JComboBox<String> fontBox = new JComboBox<>(fonts);
        fontBox.setSelectedItem("SansSerif");


        JSpinner fontSizeSpinner = new JSpinner(new SpinnerNumberModel(16, 8, 72, 1));


        JButton saveButton = new JButton("Зберегти");
        JButton openButton = new JButton("Відкрити");


        Runnable updateFont = () -> {
            String fontFamily = (String) fontBox.getSelectedItem();
            int fontSize = (int) fontSizeSpinner.getValue();
            textArea.setFont(new Font(fontFamily, Font.PLAIN, fontSize));
        };


        fontBox.addActionListener(e -> updateFont.run());
        fontSizeSpinner.addChangeListener(e -> updateFont.run());

        saveButton.addActionListener(e -> {
            try (PrintWriter writer = new PrintWriter(new FileWriter("OUTPUT.txt"))) {
                writer.println((String) fontBox.getSelectedItem());
                writer.println((int) fontSizeSpinner.getValue());
                writer.println(textArea.getText());
                JOptionPane.showMessageDialog(frame, "Файл успішно збережено!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Помилка при збереженні файлу!", "Помилка", JOptionPane.ERROR_MESSAGE);
            }
        });

        openButton.addActionListener(e -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("OUTPUT.txt"))) {
                String fontName = reader.readLine();
                String fontSizeLine = reader.readLine();
                if (fontName != null && fontSizeLine != null) {
                    fontBox.setSelectedItem(fontName);
                    int fontSize = Integer.parseInt(fontSizeLine.trim());
                    fontSizeSpinner.setValue(fontSize);
                    textArea.setFont(new Font(fontName, Font.PLAIN, fontSize));

                    StringBuilder textContent = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        textContent.append(line).append("\n");
                    }
                    textArea.setText(textContent.toString());
                }
                JOptionPane.showMessageDialog(frame, "Файл успішно відкрито!");
            } catch (IOException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Помилка при відкритті файлу!", "Помилка", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Шрифт:"));
        topPanel.add(fontBox);
        topPanel.add(new JLabel("Розмір:"));
        topPanel.add(fontSizeSpinner);
        topPanel.add(saveButton);
        topPanel.add(openButton);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }


}
