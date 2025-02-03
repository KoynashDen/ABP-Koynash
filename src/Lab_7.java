import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Lab_7 {
    public static class FirstForm {
        private JFrame frame;
        private JTextField countryField;
        private JTextField areaField;
        private JButton addButton;
        private JButton showButton;
        private ArrayList<String> countries;
        private ArrayList<Double> areas;

        public FirstForm() {
            countries = new ArrayList<>();
            areas = new ArrayList<>();

            frame = new JFrame("Введення даних");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 250);
            frame.setLayout(new FlowLayout());

            JLabel countryLabel = new JLabel("Назва країни:");
            countryField = new JTextField(15);

            JLabel areaLabel = new JLabel("Площа країни:");
            areaField = new JTextField(15);

            addButton = new JButton("Додати");
            showButton = new JButton("Показати країну з найменшою площею");

            frame.add(countryLabel);
            frame.add(countryField);
            frame.add(areaLabel);
            frame.add(areaField);
            frame.add(addButton);
            frame.add(showButton);

            addButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String country = countryField.getText();
                    double area = Double.parseDouble(areaField.getText());
                    countries.add(country);
                    areas.add(area);
                    countryField.setText("");
                    areaField.setText("");
                }
            });

            showButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SecondForm secondForm = new SecondForm(countries, areas);
                    secondForm.displaySmallestCountry();
                }
            });

            frame.setVisible(true);
        }

    }


    public static class SecondForm {
        private ArrayList<String> countries;
        private ArrayList<Double> areas;

        public SecondForm(ArrayList<String> countries, ArrayList<Double> areas) {
            this.countries = countries;
            this.areas = areas;
        }

        public void displaySmallestCountry() {
            if (countries.isEmpty() || areas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Немає введених даних!");
                return;
            }


            int smallestIndex = 0;
            for (int i = 1; i < areas.size(); i++) {
                if (areas.get(i) < areas.get(smallestIndex)) {
                    smallestIndex = i;
                }
            }

            String smallestCountry = countries.get(smallestIndex);
            double smallestArea = areas.get(smallestIndex);


            JOptionPane.showMessageDialog(null, "Країна з найменшою площею: " + smallestCountry + " з площею " + smallestArea + " км²");
        }
    }
   
}
