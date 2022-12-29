package GUI;

import javax.swing.*;
import java.awt.*;

public class Aboutus {

    Aboutus() {
        JFrame frame = new JFrame("Westminster Center for Skin.");
        // normal creat frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        frame.setResizable(false);// prevent the frame from being resized
        frame.setLayout(new FlowLayout()); // set the layout of the frame
    }
}
