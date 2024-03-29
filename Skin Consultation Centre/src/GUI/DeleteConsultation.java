package GUI;

import ConsoleSystem.Consultation;

import javax.swing.*;
import java.awt.*;

public class DeleteConsultation extends JFrame {

    DeleteConsultation(){
        JFrame frame = new JFrame("Westminster Center for Skin Delete and Edit Consultation");
        // IconImage
        ImageIcon imageIcon = new ImageIcon("src\\GUI\\Image\\icon.png");
        frame.setIconImage(imageIcon.getImage()); // set the icon of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);
        frame.setBackground(new Color(0x6060E8));
        frame.setResizable(false);// prevent the frame from being resized
        frame.setLayout(null); // set the layout of the frame

        JPanel DeletconsultationPanel = new JPanel();  // Consultation ID
        DeletconsultationPanel.setBounds(10, 190, 460, 40); // set the size of the panel
        DeletconsultationPanel.setBackground(new Color(0x212121));// set the background color of the panel
        DeletconsultationPanel.setLayout(null);// set the layout of the panel
        DeletconsultationPanel.setVisible(true);// set the visibility of the panel
        DeletconsultationPanel.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel


        JLabel DeleteconsultationIDLabel = new JLabel("Consultation ID:"); // create a label for the consultation ID
        DeleteconsultationIDLabel.setBounds(10, 10, 100, 20); // set the size of the label
        DeleteconsultationIDLabel.setForeground(new Color(0xFFFFFF)); // set the color of the label
        DeleteconsultationIDLabel.setVisible(true); // set the visibility of the label
        DeletconsultationPanel.add(DeleteconsultationIDLabel); // add the label to the panel

        JTextField DeleteconsultationIDTextField = new JTextField(); // create a text field for the consultation ID
        DeleteconsultationIDTextField.setBounds(10, 10, 100, 20); // set the size of the text field
        DeleteconsultationIDTextField.setForeground(new Color(0x474783)); // set the color of the text field
        DeleteconsultationIDTextField.setVisible(true); // set the visibility of the text field
        DeletconsultationPanel.add(DeleteconsultationIDTextField); // add the text field to the panel


        JPanel deleteButtonPanel = new JPanel();  // Delete Button
        deleteButtonPanel.setBounds(10, 240, 460, 40); // set the size of the panel
        deleteButtonPanel.setBackground(new Color(0x212121));// set the background color of the panel
        deleteButtonPanel.setLayout(null);// set the layout of the panel
        deleteButtonPanel.setVisible(true);// set the visibility of the panel
        deleteButtonPanel.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        JButton deleteButton = new JButton("Delete"); // create a button for the delete button
        deleteButton.setBounds(10, 10, 100, 20); // set the size of the button
        deleteButton.setForeground(new Color(0xFFFFFF)); // set the color of the button
        deleteButton.setBackground(new Color(0x474783)); // set the background color of the button
        deleteButton.setVisible(true); // set the visibility of the button
        deleteButtonPanel.add(deleteButton); // add the button to the panel
        deleteButton.addActionListener(e -> {
            Consultation.deleteConsultationObject(DeleteconsultationIDTextField.getText());
            frame.dispose();
            new ConsultationAdd();
        });

        JButton backButton = new JButton("Back"); // create a button for the back button
        backButton.setBounds(10, 10, 100, 20); // set the size of the button
        backButton.setForeground(new Color(0xFFFFFF)); // set the color of the button
        backButton.setBackground(new Color(0x474783)); // set the background color of the button
        backButton.setVisible(true); // set the visibility of the button
        deleteButtonPanel.add(backButton); // add the button to the panel
        backButton.addActionListener(e -> {
            frame.dispose();
            new HomePage();
        });


        frame.add(DeletconsultationPanel); // add the panel to the frame




        frame.add(deleteButtonPanel); // add the panel to the frame

        frame.setVisible(true); // set the visibility of the frame
        frame.getContentPane().setLayout(null);



    }




}
