package GUI;

import ConsoleSystem.Patient;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SkinCareCenter extends JFrame {
    SkinCareCenter(){
        {
            JFrame frame = new JFrame("Skin Care Center");
            frame.setLayout(new FlowLayout());
            // IconImage
            ImageIcon imageIcon = new ImageIcon("src\\GUI\\Image\\icon.png");

            frame.setBackground(new Color(0x6060E8)); // set the background color of the frame
            frame.setForeground(new Color(0x6060E8)); // set the foreground color of the frame

            // create a panel for the label top left  of the frame
            // panel top left  1
            JPanel panelTopLeft1 = new JPanel(); // patient name
            panelTopLeft1.setBounds(0, 10, 800, 40); // set the size of the panel
            panelTopLeft1.setBackground(new Color(0x212121));// set the background color of the panel
            panelTopLeft1.setLayout(null);// set the layout of the panel
            panelTopLeft1.setVisible(true);// set the visibility of the panel
            panelTopLeft1.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

            // panel top left  2
            JPanel panelTopLeft2 = new JPanel(); // patient surname
            panelTopLeft2.setBounds(0, 70, 800, 40); // set the size of the panel
            panelTopLeft2.setBackground(new Color(0x212121));// set the background color of the panel
            panelTopLeft2.setLayout(null);// set the layout of the panel
            panelTopLeft2.setVisible(true);// set the visibility of the panel
            panelTopLeft2.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

            // panel top left  3
            JPanel panelTopLeft3 = new JPanel(); // patient id
            panelTopLeft3.setBounds(0, 130, 800, 40); // set the size of the panel
            panelTopLeft3.setBackground(new Color(0x212121));// set the background color of the panel
            panelTopLeft3.setLayout(null);// set the layout of the panel
            panelTopLeft3.setVisible(true);// set the visibility of the panel
            panelTopLeft3.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

            // panel top left  4
            JPanel panelTopLeft4 = new JPanel(); // patient contact number
            panelTopLeft4.setBounds(0, 190, 800, 40); // set the size of the panel
            panelTopLeft4.setBackground(new Color(0x212121));// set the background color of the panel
            panelTopLeft4.setLayout(null);// set the layout of the panel
            panelTopLeft4.setVisible(true);// set the visibility of the panel
            panelTopLeft4.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

            // panel top left  5
            JPanel panelTopLeft5 = new JPanel();  // patient address
            panelTopLeft5.setBounds(0, 250, 800, 40); // set the size of the panel
            panelTopLeft5.setBackground(new Color(0x212121));// set the background color of the panel
            panelTopLeft5.setLayout(null);// set the layout of the panel
            panelTopLeft5.setVisible(true);// set the visibility of the panel
            panelTopLeft5.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

            // panel top left  6
            JPanel panelTopLeft6 = new JPanel();  // patient email
            panelTopLeft6.setBounds(0, 310, 800, 40); // set the size of the panel
            panelTopLeft6.setBackground(new Color(0x212121));// set the background color of the panel
            panelTopLeft6.setLayout(null);// set the layout of the panel
            panelTopLeft6.setVisible(true);// set the visibility of the panel
            panelTopLeft6.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

            // panel top left  7
            JPanel panelTopLeft7 = new JPanel(); // patient dateOfBirth
            panelTopLeft7.setBounds(0, 370, 800, 40); // set the size of the panel
            panelTopLeft7.setBackground(new Color(0x212121));// set the background color of the panel
            panelTopLeft7.setLayout(null);// set the layout of the panel
            panelTopLeft7.setVisible(true);// set the visibility of the panel
            panelTopLeft7.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel
            // date calander panel

            // panel top left  8
            JPanel panelTopLeft8 = new JPanel(); // gender
            panelTopLeft8.setBounds(0, 490, 800, 40); // set the size of the panel
            panelTopLeft8.setBackground(new Color(0x212121));// set the background color of the panel
            panelTopLeft8.setLayout(null);// set the layout of the panel
            panelTopLeft8.setVisible(true);// set the visibility of the panel
            panelTopLeft8.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

            // panel top left  9
            JPanel panelTopLeft9 = new JPanel();
            panelTopLeft9.setBounds(0, 590, 800, 100); // set the size of the panel

            ImageIcon titleImage = new ImageIcon("src\\GUI\\Image\\icon.png"); // create an image icon
            JLabel titleImageLabel = new JLabel(titleImage); // create a label to display the image
            titleImageLabel.setIcon(titleImage); // set the image to the label
            titleImageLabel.setVisible(true); // set the label to be visible


            // Labels for the panel top left
            JLabel labelTopLeft1 = new JLabel(" * Patient Name");
            labelTopLeft1.setBounds(0, 0, 250, 30); // set the size of the label
            labelTopLeft1.setForeground(Color.WHITE); // set the color of the text
            labelTopLeft1.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
            labelTopLeft1.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
            labelTopLeft1.setVisible(true); // set the visibility of the label

            JLabel labelTopLeft2 = new JLabel(" * Patient surname");
            labelTopLeft2.setBounds(0, 0, 300, 30); // set the size of the label
            labelTopLeft2.setForeground(Color.WHITE); // set the color of the text
            labelTopLeft2.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
            labelTopLeft2.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
            labelTopLeft2.setVisible(true); // set the visibility of the label

            JLabel labelTopLeft3 = new JLabel(" * Patient ID");
            labelTopLeft3.setBounds(0, 0, 300, 30); // set the size of the label
            labelTopLeft3.setForeground(Color.WHITE); // set the color of the text
            labelTopLeft3.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
            labelTopLeft3.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
            labelTopLeft3.setVisible(true); // set the visibility of the label

            JLabel labelTopLeft4 = new JLabel(" * Patient Contact Number");
            labelTopLeft4.setBounds(0, 0, 300, 30); // set the size of the label
            labelTopLeft4.setForeground(Color.WHITE); // set the color of the text
            labelTopLeft4.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
            labelTopLeft4.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text

            JLabel labelTopLeft5 = new JLabel(" * Patient Address");
            labelTopLeft5.setBounds(0, 0, 300, 30); // set the size of the label
            labelTopLeft5.setForeground(Color.WHITE); // set the color of the text
            labelTopLeft5.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
            labelTopLeft5.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
            labelTopLeft5.setVisible(true); // set the visibility of the label

            JLabel labelTopLeft6 = new JLabel(" * Patient Email");
            labelTopLeft6.setBounds(0, 0, 300, 30); // set the size of the label
            labelTopLeft6.setForeground(Color.WHITE); // set the color of the text
            labelTopLeft6.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
            labelTopLeft6.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
            labelTopLeft6.setVisible(true); // set the visibility of the label


            JLabel labelTopLeft7 = new JLabel(" * Patient Date of Birth");
            labelTopLeft7.setBounds(0, 0, 300, 30); // set the size of the label
            labelTopLeft7.setForeground(Color.WHITE); // set the color of the text
            labelTopLeft7.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
            labelTopLeft7.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
            labelTopLeft7.setVisible(true); // set the visibility of the label

            JLabel labelTopLeft8 = new JLabel(" * Gender");
            labelTopLeft8.setBounds(0, 0, 250, 30); // set the size of the label
            labelTopLeft8.setForeground(Color.WHITE); // set the color of the text
            labelTopLeft8.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
            labelTopLeft8.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
            labelTopLeft8.setVisible(true); // set the visibility of the label


            // Text fields for the panel top left
            JTextField textFieldTopLeft1 = new JTextField(); // patient name
            textFieldTopLeft1.setPreferredSize(new Dimension(300, 40)); // set the size of the text field
            textFieldTopLeft1.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
            textFieldTopLeft1.setVisible(true); // set the visibility of the text field
            textFieldTopLeft1.setBackground(new Color(0xA6A0A8)); // set the background color of the text field


            JTextField textFieldTopLeft2 = new JTextField(); // patient surname
            textFieldTopLeft2.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
            textFieldTopLeft2.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
            textFieldTopLeft2.setVisible(true); // set the visibility of the text field
            textFieldTopLeft2.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

            JTextField textFieldTopLeft3 = new JTextField(); // patient ID
            textFieldTopLeft3.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
            textFieldTopLeft3.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
            textFieldTopLeft3.setVisible(true); // set the visibility of the text field
            textFieldTopLeft3.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

            JTextField textFieldTopLeft4 = new JTextField(); // patient contact number
            textFieldTopLeft4.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
            textFieldTopLeft4.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
            textFieldTopLeft4.setVisible(true); // set the visibility of the text field
            textFieldTopLeft4.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

            JTextField textFieldTopLeft5 = new JTextField(); // patient address
            textFieldTopLeft5.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
            textFieldTopLeft5.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
            textFieldTopLeft5.setVisible(true); // set the visibility of the text field
            textFieldTopLeft5.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

            JTextField textFieldTopLeft6 = new JTextField(); // patient email
            textFieldTopLeft6.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
            textFieldTopLeft6.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
            textFieldTopLeft6.setVisible(true); // set the visibility of the text field
            textFieldTopLeft6.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

            // patient date of birth

            JTextField textFieldTopLeft7 = new JTextField(); // patient date of birth
            textFieldTopLeft7.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
            textFieldTopLeft7.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
            textFieldTopLeft7.setVisible(true); // set the visibility of the text field
            textFieldTopLeft7.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

            // Radio buttons for the panel top left
            JRadioButton radioButtonTopLeft1 = new JRadioButton(" Male");
            radioButtonTopLeft1.setBounds(0, 0, 50, 30); // set the size of the radio button
            radioButtonTopLeft1.setForeground(Color.WHITE); // set the color of the text
            radioButtonTopLeft1.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
            radioButtonTopLeft1.setVisible(true); // set the visibility of the radio button
            radioButtonTopLeft1.setBackground(new Color(0x2E2E2E)); // set the background color of the radio button

            JRadioButton radioButtonTopLeft2 = new JRadioButton("Female");
            radioButtonTopLeft2.setBounds(100, 0, 50, 30); // set the size of the radio button
            radioButtonTopLeft2.setForeground(Color.WHITE); // set the color of the text
            radioButtonTopLeft2.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
//        radioButtonTopLeft2.setVisible(true); // set the visibility of the radio button
            radioButtonTopLeft2.setBackground(new Color(0x2E2E2E)); // set the background color of the radio button

            // Button group for the radio buttons
            ButtonGroup buttonGroupTopLeft = new ButtonGroup();
            buttonGroupTopLeft.add(radioButtonTopLeft1);
            buttonGroupTopLeft.add(radioButtonTopLeft2);


            // create a panel for the bottom of the frame
            JPanel panelBottom = new JPanel();
            panelBottom.setBounds(0, 710, 1000, 50); // set the size of the panel
            panelBottom.setBackground(new Color(0x212121));// set the background color of the panel
            panelBottom.setLayout(null);// set the layout of the panel
            panelBottom.setVisible(true);// set the visibility of the panel

            JButton btnBack = new JButton(" Back ");
            btnBack.setBounds(10, 10, 100, 30);
            btnBack.setBackground(new Color(0x5E0393));
            btnBack.setForeground(new Color(0xFFFFFF));
            btnBack.setFont(new Font("Serif", Font.BOLD, 20));
            btnBack.setFocusPainted(false);
            btnBack.addActionListener(e -> {
                frame.dispose();
                new HomePage();
            });

            JButton btnAddDataPatient = new JButton(" Add Patient ");
            btnAddDataPatient.setBounds(790, 10, 180, 30);
            btnAddDataPatient.setBackground(new Color(0x5E0393));
            btnAddDataPatient.setForeground(new Color(0xFFFFFF));
            btnAddDataPatient.setFont(new Font("Serif", Font.BOLD, 20));
            btnAddDataPatient.setFocusPainted(false);

            btnAddDataPatient.addActionListener(e -> {
                String patientName = textFieldTopLeft1.getText();
                String patientSurname = textFieldTopLeft2.getText();
                String patientID = textFieldTopLeft3.getText();
                String patientContactNumber = textFieldTopLeft4.getText();
                String patientAddress = textFieldTopLeft5.getText();
                String patientEmail = textFieldTopLeft6.getText();
                Date patientDateOfBirth = null;
                try {
                    patientDateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(textFieldTopLeft7.getText());
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                String patientGender = null;
                if (e.getSource() == radioButtonTopLeft1) {
                    patientGender = radioButtonTopLeft1.getText();
                } else if (e.getSource() == radioButtonTopLeft2) {
                    patientGender = radioButtonTopLeft2.getText();
                }
//            String patientDateOfBirth = textFieldTopLeft7.getText();
                Patient.addPatientObject(patientName, patientSurname,patientDateOfBirth ,patientContactNumber,patientID, patientAddress, patientEmail, patientGender);
                Patient.savePatientDetails();
                // add patient to the data in to patient class addObjectPatient
                frame.dispose();
                new ConsultationAdd();
            });

            // normal creat frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set the default close operation
            frame.setSize(1000, 800); // set the size of the frame

            frame.setIconImage(imageIcon.getImage()); // set the icon of the frame
            frame.getContentPane().setLayout(null); // set the layout of the frame
            frame.setResizable(false);// prevent the frame from being resized
            frame.setLayout(null); // set the layout of the frame


            // add thew pane to the frame
            frame.add(panelTopLeft1);
            frame.add(panelTopLeft2);
            frame.add(panelTopLeft3);
            frame.add(panelTopLeft4);
            frame.add(panelTopLeft5);
            frame.add(panelTopLeft6);
            frame.add(panelTopLeft7);
            frame.add(panelTopLeft8);
            frame.add(panelTopLeft9);


            frame.add(panelBottom);


            // add the button to the panel
            panelBottom.add(btnBack);
            panelBottom.add(btnAddDataPatient);

            // add the label to the panel
            panelTopLeft1.add(labelTopLeft1);
            panelTopLeft2.add(labelTopLeft2);
            panelTopLeft3.add(labelTopLeft3);
            panelTopLeft4.add(labelTopLeft4);
            panelTopLeft5.add(labelTopLeft5);
            panelTopLeft6.add(labelTopLeft6);
            panelTopLeft7.add(labelTopLeft7);
            panelTopLeft8.add(labelTopLeft8);


            // add text feild to the panel
            panelTopLeft1.add(textFieldTopLeft1);
            panelTopLeft2.add(textFieldTopLeft2);
            panelTopLeft3.add(textFieldTopLeft3);
            panelTopLeft4.add(textFieldTopLeft4);
            panelTopLeft5.add(textFieldTopLeft5);
            panelTopLeft6.add(textFieldTopLeft6);
            panelTopLeft7.add(textFieldTopLeft7);
            panelTopLeft8.add(radioButtonTopLeft1);
            panelTopLeft8.add(radioButtonTopLeft2);


            // add the label image
            panelTopLeft9.add(titleImageLabel);
            // visible the frame

            frame.setVisible(true);

        }}
}
