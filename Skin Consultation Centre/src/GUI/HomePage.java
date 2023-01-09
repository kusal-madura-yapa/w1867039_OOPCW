package GUI;

import ConsoleSystem.Consultation;
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
        Consultation.loadConsultationFromFile();

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
        JPanel HomebuttonPanelTop = new JPanel();
        HomebuttonPanelTop.setBackground(new Color(0x16163B)); // set the background color of the panel
        HomebuttonPanelTop.setBounds(0, 110, 300, 10); // set the size of the panel
 
        JPanel homeButtonPanelBottom = new JPanel();
        homeButtonPanelBottom.setBackground(new Color(0x16163B)); // set the background color of the panel
        homeButtonPanelBottom.setBounds(0, 710, 300, 10); // set the size of the panel

        JPanel HomeButtonPanelLeft = new JPanel();
        HomeButtonPanelLeft.setBackground(new Color(0x16163B)); // set the background color of the panel
        HomeButtonPanelLeft.setBounds(0, 110, 10, 600); // set the size of the panel

        JPanel homeButtonPanelRight = new JPanel();
        homeButtonPanelRight.setBackground(new Color(0x16163B)); // set the background color of the panel
        homeButtonPanelRight.setBounds(290, 110, 10, 600); // set the size of the panel

        JPanel homeButtonPanel  = new JPanel();
        homeButtonPanel.setBackground(new Color(0x16163B)); // set the background color of the panel
        homeButtonPanel.setBounds(9, 120, 281, 590); // set the size of the panel
        homeButtonPanel.setLayout(new GridLayout(5, 1, 50, 70)); // set the layout of the panel

        // create a notice panel
        JPanel homenoticePanel0 = new JPanel();
        homenoticePanel0.setBackground(new Color(0xFF3E3542, true)); // set the background color of the panel
        homenoticePanel0.setBounds(300, 110, 550, 201); // set the size of the panel
 
        JPanel  homeSecnoticePanel = new JPanel();
        homeSecnoticePanel.setBackground(new Color(0xFF3E3542, true)); // set the background color of the panel
        homeSecnoticePanel.setBounds(300, 310, 550, 610); // set the size of the panel


        // create a notice label to display the notice
        JLabel homeNoticeLabel = new JLabel("Center can add/remove a session.According "); // create a label to display the text
        homeNoticeLabel.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        homeNoticeLabel.setForeground(Color.WHITE); // set the color of the text


        JLabel  homeNoticeLabel1 = new JLabel("to system its free to set sessions only 10 Doctors . "); // create a label to display the text
        homeNoticeLabel1.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        homeNoticeLabel1.setForeground(Color.WHITE); // set the color of the text



        JLabel homeNoticeLabel2 = new JLabel(" On sessions,user can go and or remove a consultation,"); // create a label to display the text
        homeNoticeLabel2.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        homeNoticeLabel2.setForeground(Color.WHITE); // set the color of the text

        JLabel homeNoticeLabel3 = new JLabel("Consultation ID must remember.Doctor list and Patient . "); // create a label to display the text
        homeNoticeLabel3.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        homeNoticeLabel3.setForeground(Color.WHITE); // set the color of the text

        JLabel homeNoticeLabel4  = new JLabel("List show the current list of patients.in this version"); // create a label to display the text
        homeNoticeLabel4.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        homeNoticeLabel4.setForeground(Color.WHITE); // set the color of the text

        JLabel homeNoticeLabel5 = new JLabel(", the system can view Doctors and patient. "); // create a label to display the text
        homeNoticeLabel5.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        homeNoticeLabel5.setForeground(Color.WHITE); // set the color of the text

  
        // create a notice panel right top
        JPanel homeNoticePanelRightTop = new JPanel();
        homeNoticePanelRightTop.setBackground(new Color(0xFF3E3542, true)); // set the background color of the panel
        homeNoticePanelRightTop.setBounds(850, 110, 140, 560); // set the size of the panel

        // create a notice panel right bottom
        JPanel homeNoticePanelRightBottom = new JPanel();
        homeNoticePanelRightBottom.setBackground(new Color(0xFF3E3542, true)); // set the background color of the panel
        homeNoticePanelRightBottom.setBounds(850, 670, 140, 50); // set the size of the panel
 
        // Create panel for footer text
        JPanel homeFooterPanel = new JPanel();
        homeFooterPanel.setBackground(new Color(0x262628)); // set the background color of the panel
        homeFooterPanel.setBounds(0, 721, 1000, 50); // set the size of the panel

 
        // create a text field to display note in notice panel
        JTextField homeNoticeText = new JTextField("This is a notice");
        homeNoticeText.setPreferredSize(new Dimension(500, 500));
        homeNoticeText.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        homeNoticeText.setForeground(Color.WHITE); // set the color of the text
        homeNoticeText.setVisible(true); // set the label to be visible
 

        // buttons
        // create a button for enter doctor page
        JButton homeAddSessionButton = new JButton("Add Or Remove Session");
        homeAddSessionButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        homeAddSessionButton.setForeground(Color.WHITE); // set the color of the text
        homeAddSessionButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        homeAddSessionButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10)); // set the border of the button
        homeAddSessionButton.setFocusPainted(false); // remove the focus paint
        // action listener for the add session page button
        homeAddSessionButton.addActionListener(new ActionListener() {
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
        frame.add(homeButtonPanel);
        frame.add(HomebuttonPanelTop);
        frame.add(homeButtonPanelBottom);
        frame.add(HomeButtonPanelLeft);
        frame.add(homeButtonPanelRight);

        frame.add(homeFooterPanel);
        frame.add(homenoticePanel0);
        frame.add(homeSecnoticePanel);
        frame.add(homeNoticePanelRightTop);
        frame.add(homeNoticePanelRightBottom);
        // Panel add components
        titlePanelForImage.add(titleImageLabel);
        titlePanelForText.add(titleTextLable);

        // button panel add components
        homeButtonPanel.add(homeAddSessionButton);
        homeButtonPanel.add(ConsultationButton);
        homeButtonPanel.add(SkinCareCenterButton);
        homeButtonPanel.add(doctorListButton);
        homeButtonPanel.add(patientListButton);


        // notice panel add components
        homeSecnoticePanel.add(homeNoticeLabel);
        homeSecnoticePanel.add(homeNoticeLabel1);
        homeSecnoticePanel.add(homeNoticeLabel2);
        homeSecnoticePanel.add(homeNoticeLabel3);
        homeSecnoticePanel.add(homeNoticeLabel4);

        homeSecnoticePanel.add(homeNoticeLabel5);


        //notice panel right add components
        homeNoticePanelRightBottom.add(exitButton);

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
