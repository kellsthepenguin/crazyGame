package crazyPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class crazyApp {
    private JButton clickMeButton;
    private JPanel panel1;

    public crazyApp() {
        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // namutree0345 part
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("crazyApp");
        int width;
        int height;

        Dimension dim = new Dimension(500, 500);

        frame.setMaximumSize(dim);
        frame.setMinimumSize(dim);
        frame.setSize(dim);
        frame.setContentPane(new crazyApp().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
