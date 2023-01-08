package GUI;

import ConsoleSystem.Doctor;
import ConsoleSystem.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class AddSession extends JFrame {
    AddSession(){
        JFrame frame = new JFrame("Westminster Center Add Session");
        // load the data from the file
        Session.loadSessionFromFile();

        // panel top left  1
        JPanel panelTopLeft1 = new JPanel(); // Session ID
        panelTopLeft1.setBounds(0, 10, 800, 40); // set the size of the panel
        panelTopLeft1.setBackground(new Color(0x212121));// set the background color of the panel
        panelTopLeft1.setLayout(null);// set the layout of the panel
        panelTopLeft1.setVisible(true);// set the visibility of the panel
        panelTopLeft1.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  2
        JPanel panelTopLeft2 = new JPanel(); // Licence Number
        panelTopLeft2.setBounds(0, 70, 800, 40); // set the size of the panel
        panelTopLeft2.setBackground(new Color(0x212121));// set the background color of the panel
        panelTopLeft2.setLayout(null);// set the layout of the panel
        panelTopLeft2.setVisible(true);// set the visibility of the panel
        panelTopLeft2.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  3
        JPanel panelTopLeft3 = new JPanel(); // Session Date and Time
        panelTopLeft3.setBounds(0, 130, 800, 40); // set the size of the panel
        panelTopLeft3.setBackground(new Color(0x212121));// set the background color of the panel
        panelTopLeft3.setLayout(null);// set the layout of the panel
        panelTopLeft3.setVisible(true);// set the visibility of the panel
        panelTopLeft3.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  4
        JPanel panelTopLeft4 = new JPanel(); // Max Patients
        panelTopLeft4.setBounds(0, 190, 800, 40); // set the size of the panel
        panelTopLeft4.setBackground(new Color(0x212121));// set the background color of the panel
        panelTopLeft4.setLayout(null);// set the layout of the panel
        panelTopLeft4.setVisible(true);// set the visibility of the panel
        panelTopLeft4.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  5
        JPanel panelForTableOfSesssion = new JPanel();  // patient address
        panelForTableOfSesssion.setBounds(0, 250, 1000, 300); // set the size of the panel
        panelForTableOfSesssion.setBackground(new Color(0x212121));// set the background color of the panel
        panelForTableOfSesssion.setLayout(null);// set the layout of the panel
        panelForTableOfSesssion.setVisible(true);// set the visibility of the panel
        panelForTableOfSesssion.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel



        JTable table = new JTable();
        Object[] columns = {"Session ID", "Licence Number", "Session Date and Time", "Max Patients"};
        // create a table model and design the table as not edit by using the override method
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 1000, 455);
        pane.setForeground(new Color(0x474783));



        // Labels for the panel top left
        JLabel labelTopLeft1 = new JLabel(" * Session ID: ");
        labelTopLeft1.setBounds(0, 0, 250, 30); // set the size of the label
        labelTopLeft1.setForeground(Color.WHITE); // set the color of the text
        labelTopLeft1.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        labelTopLeft1.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        labelTopLeft1.setVisible(true); // set the visibility of the label

        JLabel labelTopLeft2 = new JLabel(" * Licence Number: ");
        labelTopLeft2.setBounds(0, 0, 300, 30); // set the size of the label
        labelTopLeft2.setForeground(Color.WHITE); // set the color of the text
        labelTopLeft2.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        labelTopLeft2.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        labelTopLeft2.setVisible(true); // set the visibility of the label

        JLabel labelTopLeft3 = new JLabel(" * Date and Time dd/MM/yyyy/HH:mm : ");
        labelTopLeft3.setBounds(0, 0, 300, 30); // set the size of the label
        labelTopLeft3.setForeground(Color.WHITE); // set the color of the text
        labelTopLeft3.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        labelTopLeft3.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        labelTopLeft3.setVisible(true); // set the visibility of the label

        JLabel labelTopLeft4 = new JLabel(" * Maximum Patients: ");
        labelTopLeft4.setBounds(0, 0, 300, 30); // set the size of the label
        labelTopLeft4.setForeground(Color.WHITE); // set the color of the text
        labelTopLeft4.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        labelTopLeft4.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text



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


        // create a panel for the bottom of the frame
        JPanel panelBottom = new JPanel();
        panelBottom.setBounds(0, 710, 1000, 50); // set the size of the panel
        panelBottom.setBackground(new Color(0x212121));// set the background color of the panel
        panelBottom.setLayout(null);// set the layout of the panel
        panelBottom.setVisible(true);// set the visibility of the panel

        // create a button
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(0, 10, 100, 30);
        btnBack.setBackground(new Color(0x5E0393));
        btnBack.setForeground(new Color(0xFFFFFF));
        btnBack.setFont(new Font("Serif", Font.BOLD, 20));
        btnBack.setVisible(true);
        btnBack.addActionListener(e -> {
            frame.dispose();
            new HomePage();
        });

        // Add the session
        JButton btnAddDataSession = new JButton(" Add Session ");
        btnAddDataSession.setBounds(550, 10, 180, 30);
        btnAddDataSession.setBackground(new Color(0x5E0393));
        btnAddDataSession.setForeground(new Color(0xFFFFFF));
        btnAddDataSession.setFont(new Font("Serif", Font.BOLD, 20));
        btnAddDataSession.setFocusPainted(false);
        btnAddDataSession.setVisible(true);
        btnAddDataSession.addActionListener(e -> {
            // get the data from the text field
            String sessionID = textFieldTopLeft1.getText();
            int licenceNumber = parseInt(textFieldTopLeft2.getText());
            Date sessionDateAndTime;
            try {
                sessionDateAndTime = new SimpleDateFormat("dd/MM/yyyy/HH:mm").parse(textFieldTopLeft3.getText());
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            int maxPatient = parseInt(textFieldTopLeft4.getText());
            Doctor.loadDoctorListFromFile();
            Session.addSessionObject(sessionID, licenceNumber, sessionDateAndTime, maxPatient);
            Session.saveSessionIntoFile();
            JOptionPane.showMessageDialog(null, "Session added successfully");
            frame.dispose();
            new AddSession();
        });

        // remove the session button
        JButton btnRemoveDataSession = new JButton(" Remove Page ");
        btnRemoveDataSession.setBounds(790, 10, 180, 30);
        btnRemoveDataSession.setBackground(new Color(0x5E0393));
        btnRemoveDataSession.setForeground(new Color(0xFFFFFF));
        btnRemoveDataSession.setFont(new Font("Serif", Font.BOLD, 20));
        btnRemoveDataSession.setFocusPainted(false);
        btnRemoveDataSession.setVisible(true);
        btnRemoveDataSession.addActionListener(e -> {
            // get the data from the text field
            frame.dispose();
            new RemoveSession();
        });
        // IconImage
        ImageIcon imageIcon = new ImageIcon("src\\GUI\\Image\\icon.png");

        // creat the frame and set the title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setBackground(new Color(0x262628));
        frame.setIconImage(imageIcon.getImage());


        frame.setResizable(false);// prevent the frame from being resized
        frame.setLayout(null); // set the layout of the frame



        model.setColumnIdentifiers(columns); // set the column identifiers of the table
        table.setModel(model);  // set the model of the table

        table.setBackground(new Color(0xAD91E7)); // set the background color of the table
        table.setForeground(new Color(0x000000)); // set the foreground color of the table
        table.setGridColor(new Color(0xFFFFFF)); // set the grid color of the table
        table.setSelectionBackground(new Color(0xFFFFFF));
        table.setAutoCreateRowSorter(false); // set the auto create row sorter of the table to false
        table.setFont(new Font("Serif", Font.PLAIN, 15));
        table.setRowHeight(40); // set the row height of the table
        table.setAutoCreateRowSorter(true); // set the auto create row sorter of the table to true
        panelForTableOfSesssion.add(pane); // add the scroll pane to the frame
        panelForTableOfSesssion.add(panelBottom); // add the panel to the frame


        // add the data in to object and add the object to the table
        for (Session session : Session.sessionList) {
            Object[] row = new Object[4];
            row[0] = session.getSessionID();
            row[1] = session.getLicenceNumber();
            row[2] = session.getSessionDateAndTime();
            row[3] = session.getMaxPatients();
            model.addRow(row);
        }


        // add the panel to the frame
        frame.add(panelTopLeft1);
        frame.add(panelTopLeft2);
        frame.add(panelTopLeft3);
        frame.add(panelTopLeft4);
        frame.add(panelForTableOfSesssion);
        frame.add(panelBottom);


        // add the label to the panel
        panelTopLeft1.add(labelTopLeft1);
        panelTopLeft2.add(labelTopLeft2);
        panelTopLeft3.add(labelTopLeft3);
        panelTopLeft4.add(labelTopLeft4);

        // add the text field to the panel
        panelTopLeft1.add(textFieldTopLeft1);
        panelTopLeft2.add(textFieldTopLeft2);
        panelTopLeft3.add(textFieldTopLeft3);
        panelTopLeft4.add(textFieldTopLeft4);

        // add the button to the panel
        panelBottom.add(btnBack);
        panelBottom.add(btnAddDataSession);
        panelBottom.add(btnRemoveDataSession);


        frame.setVisible(true);
    }


}
