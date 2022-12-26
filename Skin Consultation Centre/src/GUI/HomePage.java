package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    public HomePage() {

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
        buttonPanel.setLayout(new GridLayout(3, 1, 50, 70)); // set the layout of the panel

        // create a notice panel
        JPanel noticePanel = new JPanel();
        noticePanel.setBackground(new Color(0xFF9956AF, true)); // set the background color of the panel
        noticePanel.setBounds(300, 110, 550, 610); // set the size of the panel


        // create a notice label to display the notice
        JLabel noticeLabel = new JLabel("Notice: This is a notice");
        noticeLabel.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        noticeLabel.setForeground(Color.WHITE); // set the color of the text
        noticeLabel.setVisible(true); // set the label to be visible


        // create a notice panel right top
        JPanel noticePanelRightTop = new JPanel();
        noticePanelRightTop.setBackground(new Color(0xFF9956AF, true)); // set the background color of the panel
        noticePanelRightTop.setBounds(850, 110, 140, 560); // set the size of the panel

        // create a notice panel right bottom
        JPanel noticePanelRightBottom = new JPanel();
        noticePanelRightBottom.setBackground(new Color(0xFF9956AF, true)); // set the background color of the panel
        noticePanelRightBottom.setBounds(850, 670, 140, 50); // set the size of the panel

        // Create panel for footer text
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(0x262628)); // set the background color of the panel
        footerPanel.setBounds(0, 721, 1000, 50); // set the size of the panel


//        // buttons
//        // create a button for enter doctor page
//        JButton enterDoctorPageButton = new JButton("Go to Doctor Page");
//        enterDoctorPageButton.setBounds(100, 100, 100, 10); // set the size of the button
//        enterDoctorPageButton.setBackground(new Color(0xFF814301)); // set the background color of the button
//        enterDoctorPageButton.setForeground(Color.WHITE); // set the color of the text
//        enterDoctorPageButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
//        enterDoctorPageButton.setFocusPainted(false); // remove the focus paint
//        enterDoctorPageButton.setBorder(BorderFactory.createLineBorder(Color.WHITE,10)); // set the border of the button

//        // create a button to open the patient page
//        JButton patientButton = new JButton("Go to Patient Page");
//        patientButton.setBackground(new Color(0xFF814301)); // set the background color of the button
//        patientButton.setForeground(Color.WHITE); // set the color of the text
//        patientButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
//        patientButton.setBorder(BorderFactory.createLineBorder(Color.WHITE,10)); // set the border of the button
//        patientButton.setFocusPainted(false); // remove the focus paint


        //create a button to SkinCareCenter page
        JButton SkinCareCenterButton = new JButton("Skin Care Center");
        SkinCareCenterButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        SkinCareCenterButton.setForeground(Color.WHITE); // set the color of the text
        SkinCareCenterButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        SkinCareCenterButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10)); // set the border of the button
        SkinCareCenterButton.setFocusPainted(false); // remove the focus paint
        // add action listener to the button
        SkinCareCenterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // create a new frame
                SkinCareCenter skinCareCenter = new SkinCareCenter();
            }
        });


        // create a button to view the doctor list
        JButton doctorListButton = new JButton("Doctor List");
        doctorListButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        doctorListButton.setForeground(Color.WHITE); // set the color of the text
        doctorListButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        doctorListButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10)); // set the border of the button
        doctorListButton.setFocusPainted(false); // remove the focus paint


        // create a button to view the patient list
        JButton patientListButton = new JButton("Patient List");
        patientListButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        patientListButton.setForeground(Color.WHITE); // set the color of the text
        patientListButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        patientListButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 10)); // set the border of the button
        patientListButton.setFocusPainted(false); // remove the focus paint

        // create a button to Exit
        JButton exitButton = new JButton("      Exit      ");
        exitButton.setBackground(new Color(0x5E0393)); // set the background color of the button
        exitButton.setForeground(Color.WHITE); // set the color of the text
        exitButton.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text\
        exitButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5)); // set the border of the button
        exitButton.setFocusPainted(false); // remove the focus paint
        // add action listener to the button
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // exit the program
            }
        });


        // IconImage
        ImageIcon imageIcon = new ImageIcon("src\\GUI\\Image\\icon.png");

        // Create a new JFrame container.
        JFrame frame = new JFrame("Welcome Westminster Center for Skin.");
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
        frame.add(noticePanel);
        frame.add(noticePanelRightTop);
        frame.add(noticePanelRightBottom);
        // Panel add components
        titlePanelForImage.add(titleImageLabel);
        titlePanelForText.add(titleTextLable);

        // button panel add components
//        buttonPanel.add(enterDoctorPageButton);
//        buttonPanel.add(patientButton);
        buttonPanel.add(SkinCareCenterButton);
        buttonPanel.add(doctorListButton);
        buttonPanel.add(patientListButton);


        // notice panel add components
        noticePanel.add(noticeLabel);


        //notice panel right add components
        noticePanelRightBottom.add(exitButton);

        // footer panel add components

        // Frame visible
        frame.setVisible(true);

    }


    // add the about us action listener to the button
    public void actionPerformedForAboutUs() {
        Aboutus aboutus = new Aboutus();
        this.setVisible(false);

    }

    // Main method to run the program
    public static void main(String[] args) {
        new HomePage();
    }
}
