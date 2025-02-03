import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Lab_8 {

    public static void lab_8() {

        JFrame frame = new JFrame("Контекстне меню для змін шрифту");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        JTextPane textPane = new JTextPane();
        textPane.setFont(new Font("Arial", Font.PLAIN, 16));
        textPane.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(textPane);
        frame.add(scrollPane, BorderLayout.CENTER);


        JPopupMenu contextMenu = new JPopupMenu();


        String[] fonts = {"Arial", "Serif"};
        final int[] currentFontIndex = {0};


        final boolean[] isBold = {false};


        JMenuItem changeFontItem = new JMenuItem("Змінити тип шрифту");
        changeFontItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textPane.getSelectedText() != null) {

                    currentFontIndex[0] = (currentFontIndex[0] + 1) % 2;
                    Font newFont = new Font(fonts[currentFontIndex[0]], Font.PLAIN, 16);
                    StyledDocument doc = textPane.getStyledDocument();
                    SimpleAttributeSet attrs = new SimpleAttributeSet();
                    StyleConstants.setFontFamily(attrs, newFont.getFamily());
                    int start = textPane.getSelectionStart();
                    int end = textPane.getSelectionEnd();
                    doc.setCharacterAttributes(start, end - start, attrs, false);
                }
            }
        });
        contextMenu.add(changeFontItem);


        JMenuItem changeColorItem = new JMenuItem("Змінити колір шрифту");
        changeColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textPane.getSelectedText() != null) {

                    Color color = JColorChooser.showDialog(null, "Виберіть колір", Color.BLACK);
                    if (color != null) {
                        StyledDocument doc = textPane.getStyledDocument();
                        SimpleAttributeSet attrs = new SimpleAttributeSet();
                        StyleConstants.setForeground(attrs, color);
                        int start = textPane.getSelectionStart();
                        int end = textPane.getSelectionEnd();
                        doc.setCharacterAttributes(start, end - start, attrs, false);
                    }
                }
            }
        });
        contextMenu.add(changeColorItem);


        JMenuItem changeStyleItem = new JMenuItem("Змінити стиль шрифту");
        changeStyleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textPane.getSelectedText() != null) {

                    isBold[0] = !isBold[0];
                    Font currentFont = textPane.getFont();
                    StyledDocument doc = textPane.getStyledDocument();
                    SimpleAttributeSet attrs = new SimpleAttributeSet();
                    StyleConstants.setBold(attrs, isBold[0]);
                    int start = textPane.getSelectionStart();
                    int end = textPane.getSelectionEnd();
                    doc.setCharacterAttributes(start, end - start, attrs, false);
                }
            }
        });
        contextMenu.add(changeStyleItem);


        textPane.setComponentPopupMenu(contextMenu);


        frame.setVisible(true);
    }
}
