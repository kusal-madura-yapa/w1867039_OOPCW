package GUI;

import javax.swing.*;
import java.awt.*;

public class ConsultationAdd extends JFrame {
    ConsultationAdd() {


        JFrame frame = new JFrame("Welcome Westminster Center for Skin.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(0x212121));
        frame.setIconImage(new ImageIcon("src\\GUI\\Image\\icon.png").getImage());
    }

}
