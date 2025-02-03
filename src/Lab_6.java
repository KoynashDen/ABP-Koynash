import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab_6 {
    public static void lab_6() {

        JFrame frame = new JFrame("Изменение шрифта");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS)); // Используем BoxLayout для вертикального расположения

        JLabel label = new JLabel("Люблю АОП", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 20));
        label.setForeground(Color.GREEN);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        frame.add(label);


        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());
        radioPanel.setAlignmentX(Component.CENTER_ALIGNMENT);


        ButtonGroup radioGroup = new ButtonGroup();

        JRadioButton fontButton = new JRadioButton("Змінити тип шрифта");
        JRadioButton colorButton = new JRadioButton("Змінити колір шрифта");
        JRadioButton styleButton = new JRadioButton("Змінити стиль шрифта");


        radioGroup.add(fontButton);
        radioGroup.add(colorButton);
        radioGroup.add(styleButton);


        radioPanel.add(fontButton);
        radioPanel.add(colorButton);
        radioPanel.add(styleButton);

        frame.add(radioPanel);


        fontButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font("Times New Roman", Font.PLAIN, 20)); // меняем шрифт на Times New Roman
            }
        });


        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setForeground(Color.RED); // меняем цвет шрифта на красный
            }
        });


        styleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setFont(new Font(label.getFont().getName(), Font.ITALIC, 20)); // меняем стиль на курсив
            }
        });

        frame.setVisible(true);
    }

}
