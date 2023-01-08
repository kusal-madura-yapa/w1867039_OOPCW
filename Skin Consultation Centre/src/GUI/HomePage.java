package GUI;

import ConsoleSystem.Doctor;
import ConsoleSystem.Patient;
import ConsoleSystem.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    public HomePage() {
        Session.loadSessionFromFile();
        Doctor.loadDoctorListFromFile();
        Patient.loadPatientListFromFile();

        JFrame frame = new JFrame("Welcome Westminster Center for Skin.");

        // JPanel for title icon image
        JPanel titlePanelForImage = new JPanel();
        titlePanelForImage.setBackground(new Color(0x262628)); // set the background color of the panel
        titlePanelForImage.setBounds(0, 0, 100, 110); // set the size of the panel
        ImageIcon titleImage = new ImageIcon("src\\GUI\\Image\\icon.png"); // create an image icon
        JLabel titleImageLabel = new JLabel(titleImage); // create a label to display the image
        titleImageLabel.setIcon(titleImage); // set the image to the label
        titleImageLabel.setVisible(true); // set the label to be visible

        // JPanel for title text top panel
        JPanel titlePanelForTextTop = new JPanel();
        titlePanelForTextTop.setBackground(new Color(0x262628)); // set the background color of the panel
        titlePanelForTextTop.setBounds(100, 0, 900, 30); // set the size of the panel

        // JPanel for title text
        JPanel titlePanelForText = new JPanel();
        titlePanelForText.setBackground(new Color(0x262628)); // set the background color of the panel
        titlePanelForText.setBounds(100, 30, 900, 80); // set the size of the panel

        // create a label to display the title text
        JLabel titleTextLable = new JLabel("Westminster Skin Care Center "); // create a label to display the text
        titleTextLable.setFont(new Font("Arial", Font.BOLD, 30)); // set the font of the text
        titleTextLable.setForeground(Color.WHITE); // set the color of the text
        titleTextLable.setVisible(true); // set the label to be visible
        titleTextLable.setVerticalAlignment(JLabel.TOP); // set the vertical alignment of the text
        titleTextLable.setHorizontalAlignment(JLabel.CENTER); // set the horizontal alignment of the text


        // JPanel for the buttons
        // create a panel to hold the buttons
        JPanel buttonPanelTop = new JPanel();
        buttonPanelTop.setBackground(new Color(0x16163B)); // set the background color of the panel
        buttonPanelTop.setBounds(0, 110, 300, 10); // set the size of the panel

        JPanel buttonPanelBottom = new JPanel();
        buttonPanelBottom.setBackground(new Color(0x16163B)); // set the background color of the panel
        buttonPanelBottom.setBounds(0, 710, 300, 10); // set the size of the panel

        JPanel buttonPanelLeft = new JPanel();
        buttonPanelLeft.setBackground(new Color(0x16163B)); // set the background color of the panel
        buttonPanelLeft.setBounds(0, 110, 10, 600); // set the size of the panel

        JPanel buttonPanelRight = new JPanel();
        buttonPanelRight.setBackground(new Color(0x16163B)); // set the background color of the panel
        buttonPanelRight.setBounds(290, 110, 10, 600); // set the size of the panel

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0x16163B)); // set the background color of the panel
        buttonPanel.setBounds(9, 120, 281, 590); // set the size of the panel
        buttonPanel.setLayout(new GridLayout(5, 1, 50, 70)); // set the layout of the panel

        // create a notice panel
        JPanel noticePanel0 = new JPanel();
        noticePanel0.setBackground(new Color(0xFF3E3542, true)); // set the background color of the panel
        noticePanel0.setBounds(300, 110, 550, 201); // set the size of the panel

        JPanel noticePanel = new JPanel();
        noticePanel.setBackground(new Color(0xFF3E3542, true)); // set the background color of the panel
        noticePanel.setBounds(300, 310, 550, 610); // set the size of the panel


        // create a notice label to display the notice


        JLabel noticeLabel = new JLabel("Center can add/remove a session.According "); // create a label to display the text
        noticeLabel.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        noticeLabel.setForeground(Color.WHITE); // set the color of the text


        JLabel noticeLabel1 = new JLabel("to system its free to set sessions only 10 Doctors . "); // create a label to display the text
        noticeLabel1.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        noticeLabel1.setForeground(Color.WHITE); // set the color of the text



        JLabel noticeLabel2 = new JLabel(" On sessions,user can go and or remove a consultation,"); // create a label to display the text
        noticeLabel2.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        noticeLabel2.setForeground(Color.WHITE); // set the color of the text

        JLabel noticeLabel3 = new JLabel("Consultation ID must remember.Doctor list and Patient . "); // create a label to display the text
        noticeLabel3.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        noticeLabel3.setForeground(Color.WHITE); // set the color of the text

        JLabel noticeLabel4 = new JLabel("List show the current list of patients.in this version"); // create a label to display the text
        noticeLabel4.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        noticeLabel4.setForeground(Color.WHITE); // set the color of the text

        JLabel noticeLabel5 = new JLabel(", the system can view Doctors and patient. "); // create a label to display the text
        noticeLabel5.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        noticeLabel5.setForeground(Color.WHITE); // set the color of the text


        // create a notice panel right top
        JPanel noticePanelRightTop = new JPanel();
        noticePanelRightTop.setBackground(new Color(0xFF3E3542, true)); // set the background color of the panel
        noticePanelRightTop.setBounds(850, 110, 140, 560); // set the size of the panel

        // create a notice panel right bottom
        JPanel noticePanelRightBottom = new JPanel();
        noticePanelRightBottom.setBackground(new Color(0xFF3E3542, true)); // set the background color of the panel
        noticePanelRightBottom.setBounds(850, 670, 140, 50); // set the size of the panel

        // Create panel for footer text
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(0x262628)); // set the background color of the panel
        footerPanel.setBounds(0, 721, 1000, 50); // set the size of the panel


        // create a text field to display note in notice panel
        JTextField noticeText = new JTextField("This is a notice");
        noticeText.setPreferredSize(new Dimension(500, 500));
        noticeText.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        noticeText.setForeground(Color.WHITE); // set the color of the text
        noticeText.setVisible(true); // set the label to be visible


        // buttons
        // create a button for enter doctor page
        JButton AddSessionButton = new JButton("Add Or Remove Session");
        AddSessionButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        AddSessionButton.setForeground(Color.WHITE); // set the color of the text
        AddSessionButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        AddSessionButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10)); // set the border of the button
        AddSessionButton.setFocusPainted(false); // remove the focus paint
        // action listener for the add session page button
        AddSessionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a new frame
                new AddSession();
                frame.setVisible(false);
            }
        });


        // create a button to open the patient page
        JButton ConsultationButton = new JButton("Add Consultation");
        ConsultationButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        ConsultationButton.setForeground(Color.WHITE); // set the color of the text
        ConsultationButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        ConsultationButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10)); // set the border of the button
        ConsultationButton.setFocusPainted(false); // remove the focus paint
        // action listener for the patient page button
        ConsultationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a new frame
                frame.dispose();
                new ConsultationAdd();
            }
        });


        //create a button to SkinCareCenter page
        JButton SkinCareCenterButton = new JButton("Skin Care Center");
        SkinCareCenterButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        SkinCareCenterButton.setForeground(Color.WHITE); // set the color of the text
        SkinCareCenterButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        SkinCareCenterButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10)); // set the border of the button
        SkinCareCenterButton.setFocusPainted(false); // remove the focus paint
        // add action listener to the button
        SkinCareCenterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a new frame
                new SkinCareCenter();
                frame.setVisible(false);

            }
        });
        // create a button to view the doctor list
        JButton doctorListButton = new JButton("Doctor List");
        doctorListButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        doctorListButton.setForeground(Color.WHITE); // set the color of the text
        doctorListButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        doctorListButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10)); // set the border of the button
        doctorListButton.setFocusPainted(false); // remove the focus paint
        // add action listener to the button
        doctorListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a new frame
                new ViewDoctors();
                frame.setVisible(false);
            }
        });
        // create a button to view the patient list
        JButton patientListButton = new JButton("Patient List");
        patientListButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        patientListButton.setForeground(Color.WHITE); // set the color of the text
        patientListButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        patientListButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10)); // set the border of the button
        patientListButton.setFocusPainted(false); // remove the focus paint
        // add action listener to the button
        patientListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create a new frame
                ViewPatients patientList = new ViewPatients();
                frame.setVisible(false);
            }
        });
        // create a button to Exit
        JButton exitButton = new JButton("      Exit      ");
        exitButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        exitButton.setForeground(Color.WHITE); // set the color of the text
        exitButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text\
        exitButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5)); // set the border of the button
        exitButton.setFocusPainted(false); // remove the focus paint
        // add action listener to the button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // exit the program
            }
        });
        // IconImage
        ImageIcon imageIcon = new ImageIcon("src\\GUI\\Image\\icon.png");

        // Create a new JFrame container.

        // normal creat frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setBackground(new Color(0x262628));
        frame.setIconImage(imageIcon.getImage());

        frame.setResizable(false);// prevent the frame from being resized
        frame.setLayout(null); // set the layout of the frame

        frame.add(titlePanelForImage);
        frame.add(titlePanelForTextTop);
        frame.add(titlePanelForText);
        frame.add(buttonPanel);
        frame.add(buttonPanelTop);
        frame.add(buttonPanelBottom);
        frame.add(buttonPanelLeft);
        frame.add(buttonPanelRight);

        frame.add(footerPanel);
        frame.add(noticePanel0);
        frame.add(noticePanel);
        frame.add(noticePanelRightTop);
        frame.add(noticePanelRightBottom);
        // Panel add components
        titlePanelForImage.add(titleImageLabel);
        titlePanelForText.add(titleTextLable);

        // button panel add components
        buttonPanel.add(AddSessionButton);
        buttonPanel.add(ConsultationButton);
        buttonPanel.add(SkinCareCenterButton);
        buttonPanel.add(doctorListButton);
        buttonPanel.add(patientListButton);


        // notice panel add components
        noticePanel.add(noticeLabel);
        noticePanel.add(noticeLabel1);
        noticePanel.add(noticeLabel2);
        noticePanel.add(noticeLabel3);
        noticePanel.add(noticeLabel4);

        noticePanel.add(noticeLabel5);


        //notice panel right add components
        noticePanelRightBottom.add(exitButton);

        // footer panel add components

        // Frame visible
        frame.setVisible(true);

    }

    // Main method to run the program
    public static void main(String[] args) {
        Patient.loadPatientListFromFile();
        new HomePage();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
