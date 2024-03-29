package GUI;

import ConsoleSystem.Consultation;
import ConsoleSystem.Doctor;
import ConsoleSystem.Patient;
import ConsoleSystem.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class ConsultationAdd extends JFrame {
    ConsultationAdd() {


        Doctor.loadDoctorListFromFile();
        JFrame frame = new JFrame("Add Consultation.");


        // create a panel for the label top left  of the frame
        // panel top left  1
        JPanel consultationPanelTopLeft1 = new JPanel(); // patient ID
        consultationPanelTopLeft1.setBounds(10, 10, 790, 40); // set the size of the panel
        consultationPanelTopLeft1.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopLeft1.setLayout(null);// set the layout of the panel
        consultationPanelTopLeft1.setVisible(true);// set the visibility of the panel
        consultationPanelTopLeft1.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  2
        JPanel consultationPanelTopLeft2 = new JPanel(); // Sesstion ID
        consultationPanelTopLeft2.setBounds(10, 70, 790, 40); // set the size of the panel
        consultationPanelTopLeft2.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopLeft2.setLayout(null);// set the layout of the panel
        consultationPanelTopLeft2.setVisible(true);// set the visibility of the panel
        consultationPanelTopLeft2.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  3
        JPanel consultationPanelTopLeft3 = new JPanel(); // Lisesnce Number
        consultationPanelTopLeft3.setBounds(10, 130, 790, 40); // set the size of the panel
        consultationPanelTopLeft3.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopLeft3.setLayout(null);// set the layout of the panel
        consultationPanelTopLeft3.setVisible(true);// set the visibility of the panel
        consultationPanelTopLeft3.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  4
        JPanel consultationPanelTopLeft4 = new JPanel();  // Consultation ID
        consultationPanelTopLeft4.setBounds(10, 190, 790, 40); // set the size of the panel
        consultationPanelTopLeft4.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopLeft4.setLayout(null);// set the layout of the panel
        consultationPanelTopLeft4.setVisible(true);// set the visibility of the panel
        consultationPanelTopLeft4.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  5
        JPanel consultationPanelTopLeft5 = new JPanel();  // patient Count
        consultationPanelTopLeft5.setBounds(10, 250, 790, 40); // set the size of the panel
        consultationPanelTopLeft5.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopLeft5.setLayout(null);// set the layout of the panel
        consultationPanelTopLeft5.setVisible(true);// set the visibility of the panel
        consultationPanelTopLeft5.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  6
        JPanel consultationPanelTopLeft6 = new JPanel(); // requested time
        consultationPanelTopLeft6.setBounds(10, 310, 790, 40); // set the size of the panel
        consultationPanelTopLeft6.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopLeft6.setLayout(null);// set the layout of the panel
        consultationPanelTopLeft6.setVisible(true);// set the visibility of the panel
        consultationPanelTopLeft6.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        // panel top left  7
        JPanel consultationPanelTopLeft7 = new JPanel(); // descripton
        consultationPanelTopLeft7.setBounds(10, 370, 790, 40); // set the size of the panel
        consultationPanelTopLeft7.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopLeft7.setLayout(null);// set the layout of the panel
        consultationPanelTopLeft7.setVisible(true);// set the visibility of the panel
        consultationPanelTopLeft7.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel

        JPanel consultationPanelTopRightLong = new JPanel(); // table patient name and ID
        consultationPanelTopRightLong.setBounds(840, 10, 330, 400); // set the size of the panel
        consultationPanelTopRightLong.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopRightLong.setLayout(null);// set the layout of the panel
        consultationPanelTopRightLong.setVisible(true);// set the visibility of the panel
        
        // create a table
        JTable patientTable = new JTable();
        Object[] columns = {"Firstname ", "Surname ", "Patient ID"};
        // create a table model and design the table as not edit by using the override method
        DefaultTableModel patientModel = new DefaultTableModel(){
            @Override 
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        patientModel.setColumnIdentifiers(columns); // set the column identifiers of the table
        patientTable.setModel(patientModel);  // set the model of the table
        JScrollPane patientPane = new JScrollPane(patientTable);
        patientPane.setBounds(842, 12, 323, 395); 
        patientPane.setForeground(new Color(0x474783));
        patientTable.setModel(patientModel);  // set the model of the table
        patientTable.setBackground(new Color(0xAD91E7)); // set the background color of the table
        patientTable.setForeground(new Color(0x000000)); // set the foreground color of the table
        patientTable.setGridColor(new Color(0xFFFFFF)); // set the grid color of the table
        patientTable.setSelectionBackground(new Color(0xFFFFFF));
        patientTable.setAutoCreateRowSorter(false); // set the auto create row sorter of the table to false
        patientTable.setFont(new Font("Serif", Font.PLAIN, 15));
        patientTable.setRowHeight(40); // set the row height of the table
        patientTable.setAutoCreateRowSorter(true); // set the auto create row sorter of the table to true
        frame.getContentPane().add(patientPane); // add the scroll pane to the frame

        // add objects to the panel
        Patient.patientArrayList.forEach(patient -> {
            Object[] row = new Object[3];
            row[0] = patient.getName();
            row[1] = patient.getSurname();
            row[2] = patient.getPatientId();
                        // add row to the model
            patientModel.addRow(row);
        });


        // panel top left  8
        JPanel consultationPanelTopLeft8 = new JPanel(); //Session ID snd details on session
        consultationPanelTopLeft8.setBounds(10, 430, 560, 380); // set the size of the panel
        consultationPanelTopLeft8.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopLeft8.setLayout(null);// set the layout of the panel
        consultationPanelTopLeft8.setVisible(true);// set the visibility of the panel
        // create a table
        JTable Sessiontable = new JTable();
        Object[] Sessioncolumns = {"Session ID", "Licence Number", "Session Date and Time", "Max Patients"};
        // create a table model and design the table as not edit by using the override method
        DefaultTableModel sessionModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        sessionModel.setColumnIdentifiers(Sessioncolumns); // set the column identifiers of the table
        Sessiontable.setModel(sessionModel);  // set the model of the table
        JScrollPane SessionPane = new JScrollPane(Sessiontable);
        SessionPane.setBounds(13, 432, 553, 375);
        SessionPane.setForeground(new Color(0x474783));
        Sessiontable.setModel(sessionModel);  // set the model of the table
        Sessiontable.setBackground(new Color(0xAD91E7)); // set the background color of the table
        Sessiontable.setForeground(new Color(0x000000)); // set the foreground color of the table
        Sessiontable.setGridColor(new Color(0xFFFFFF)); // set the grid color of the table
        Sessiontable.setSelectionBackground(new Color(0xFFFFFF));
        Sessiontable.setAutoCreateRowSorter(false); // set the auto create row sorter of the table to false
        Sessiontable.setFont(new Font("Serif", Font.PLAIN, 15));
        Sessiontable.setRowHeight(40); // set the row height of the table
        Sessiontable.setAutoCreateRowSorter(true); // set the auto create row sorter of the table to true
        frame.getContentPane().add(SessionPane); // add the scroll pane to the frame

        // add objects to the panel
        Session.sessionList.forEach(session -> {
            Object[] row = new Object[4];
            row[0] = session.getSessionID();
            row[1] = session.getLicenceNumber();
            row[2] = session.getSessionDateAndTime();
            row[3] = session.getMaxPatients();
            // add row to the model
            sessionModel.addRow(row);
        });

        // panel top left  9
        JPanel consultationPanelTopRight9 = new JPanel(); // table Doctor name and license number and specialization
        consultationPanelTopRight9.setBounds(610, 430, 560, 380); // set the size of the panel
        consultationPanelTopRight9.setBackground(new Color(0x212121));// set the background color of the panel
        consultationPanelTopRight9.setLayout(null);// set the layout of the panel
        consultationPanelTopRight9.setVisible(true);// set the visibility of the panel


        // create a table
        JTable DoctorTable = new JTable();
        Object[] DoctorColumns = {"Firstname ", "Surname ", "Specialization", "License Number"};
        // create a table model and design the table as not edit by using the override method
        DefaultTableModel Doctormodel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Doctormodel.setColumnIdentifiers(DoctorColumns); // set the column identifiers of the table
        DoctorTable.setModel(Doctormodel);  // set the model of the table
        JScrollPane DoctorPane = new JScrollPane(DoctorTable);
        DoctorPane.setBounds(612, 432, 553, 375);
        DoctorPane.setForeground(new Color(0x474783));
        DoctorTable.setModel(Doctormodel);  // set the model of the table
        DoctorTable.setBackground(new Color(0xAD91E7)); // set the background color of the table
        DoctorTable.setForeground(new Color(0x000000)); // set the foreground color of the table
        DoctorTable.setGridColor(new Color(0xFFFFFF)); // set the grid color of the table
        DoctorTable.setSelectionBackground(new Color(0xFFFFFF));
        DoctorTable.setAutoCreateRowSorter(false); // set the auto create row sorter of the table to false
        DoctorTable.setFont(new Font("Serif", Font.PLAIN, 15));
        DoctorTable.setRowHeight(40); // set the row height of the table
        DoctorTable.setAutoCreateRowSorter(true); // set the auto create row sorter of the table to true
//        consultationPanelTopRight9(getContentPane().add(pane)); // add the scroll pane to the frame
        frame.getContentPane().add(DoctorPane); // add the scroll pane to the frame

        // add objects to the panel
        Doctor.doctorArrayList.forEach(doctor -> {
            Object[] row = new Object[4];
            row[0] = doctor.getName();
            row[1] = doctor.getSurname();
            row[2] = doctor.getSpecialization();
            row[3] = doctor.getLicenceNumber();
            // add row to the model
            Doctormodel.addRow(row);
        });


        // Labels for the panel top  left
        JLabel consultationlabelTopLeft1 = new JLabel(" * Patient ID");
        consultationlabelTopLeft1.setBounds(0, 0, 250, 30); // set the size of the label
        consultationlabelTopLeft1.setForeground(Color.WHITE); // set the color of the text
        consultationlabelTopLeft1.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        consultationlabelTopLeft1.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        consultationlabelTopLeft1.setVisible(true); // set the visibility of the label

        JLabel consultationlabelTopLeft2 = new JLabel(" * Session ID");
        consultationlabelTopLeft2.setBounds(0, 0, 300, 30); // set the size of the label
        consultationlabelTopLeft2.setForeground(Color.WHITE); // set the color of the text
        consultationlabelTopLeft2.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        consultationlabelTopLeft2.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        consultationlabelTopLeft2.setVisible(true); // set the visibility of the label

        JLabel consultationlabelTopLeft3 = new JLabel(" * License Number");
        consultationlabelTopLeft3.setBounds(0, 0, 300, 30); // set the size of the label
        consultationlabelTopLeft3.setForeground(Color.WHITE); // set the color of the text
        consultationlabelTopLeft3.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        consultationlabelTopLeft3.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        consultationlabelTopLeft3.setVisible(true); // set the visibility of the label

        JLabel consultationlabelTopLeft4 = new JLabel(" * Consultation ID");
        consultationlabelTopLeft4.setBounds(0, 0, 300, 30); // set the size of the label
        consultationlabelTopLeft4.setForeground(Color.WHITE); // set the color of the text
        consultationlabelTopLeft4.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        consultationlabelTopLeft4.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text

        JLabel consultationlabelTopLeft5 = new JLabel(" * Patient Count");
        consultationlabelTopLeft5.setBounds(0, 0, 300, 30); // set the size of the label
        consultationlabelTopLeft5.setForeground(Color.WHITE); // set the color of the text
        consultationlabelTopLeft5.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        consultationlabelTopLeft5.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        consultationlabelTopLeft5.setVisible(true); // set the visibility of the label

        JLabel consultationlabelTopLeft6 = new JLabel(" * Requested Time 30/60/90min");
        consultationlabelTopLeft6.setBounds(0, 0, 300, 30); // set the size of the label
        consultationlabelTopLeft6.setForeground(Color.WHITE); // set the color of the text
        consultationlabelTopLeft6.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        consultationlabelTopLeft6.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        consultationlabelTopLeft6.setVisible(true); // set the visibility of the label

        JLabel consultationlabelTopLeft7 = new JLabel(" * Description");
        consultationlabelTopLeft7.setBounds(0, 0, 300, 30); // set the size of the label
        consultationlabelTopLeft7.setForeground(Color.WHITE); // set the color of the text
        consultationlabelTopLeft7.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        consultationlabelTopLeft7.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        consultationlabelTopLeft7.setVisible(true); // set the visibility of the label



        // Text fields for the panel top left
        JTextField consultationTextFieldTopLeft1 = new JTextField(); // patient id
        consultationTextFieldTopLeft1.setPreferredSize(new Dimension(300, 40)); // set the size of the text field
        consultationTextFieldTopLeft1.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
        consultationTextFieldTopLeft1.setVisible(true); // set the visibility of the text field
        consultationTextFieldTopLeft1.setBackground(new Color(0xA6A0A8)); // set the background color of the text field


        JTextField consultationTextFieldTopLeft2 = new JTextField(); // Session id
        consultationTextFieldTopLeft2.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
        consultationTextFieldTopLeft2.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
        consultationTextFieldTopLeft2.setVisible(true); // set the visibility of the text field
        consultationTextFieldTopLeft2.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

        JTextField consultationTextFieldTopLeft3 = new JTextField(); // License number
        consultationTextFieldTopLeft3.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
        consultationTextFieldTopLeft3.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
        consultationTextFieldTopLeft3.setVisible(true); // set the visibility of the text field
        consultationTextFieldTopLeft3.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

        JTextField consultationTextFieldTopLeft4 = new JTextField(); // Consultation id
        consultationTextFieldTopLeft4.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
        consultationTextFieldTopLeft4.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
        consultationTextFieldTopLeft4.setVisible(true); // set the visibility of the text field
        consultationTextFieldTopLeft4.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

        JTextField consultationtTextFieldTopLeft5 = new JTextField(); //patient count
        consultationtTextFieldTopLeft5.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
        consultationtTextFieldTopLeft5.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
        consultationtTextFieldTopLeft5.setVisible(true); // set the visibility of the text field
        consultationtTextFieldTopLeft5.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

        JTextField consultationTextFieldTopLeft6 = new JTextField(); // requested time
        consultationTextFieldTopLeft6.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
        consultationTextFieldTopLeft6.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
        consultationTextFieldTopLeft6.setVisible(true); // set the visibility of the text field
        consultationTextFieldTopLeft6.setBackground(new Color(0xA6A0A8)); // set the background color of the text field

        // patient date of birth

        JTextField consultationTextFieldTopLeft7 = new JTextField(); // patient date of birth
        consultationTextFieldTopLeft7.setPreferredSize(new Dimension(600, 50)); // set the size of the text field
        consultationTextFieldTopLeft7.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
        consultationTextFieldTopLeft7.setVisible(true); // set the visibility of the text field
        consultationTextFieldTopLeft7.setBackground(new Color(0xA6A0A8)); // set the background color of the text field


        // create a panel for the bottom of the frame
        JPanel panelBottom = new JPanel();
        panelBottom.setBounds(0, 810, 1200, 50); // set the size of the panel
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

        JButton btnAddDataConsultation = new JButton(" Add Consultation ");
        btnAddDataConsultation.setBounds(790, 10, 200, 30);
        btnAddDataConsultation.setBackground(new Color(0x5E0393));
        btnAddDataConsultation.setForeground(new Color(0xFFFFFF));
        btnAddDataConsultation.setFont(new Font("Serif", Font.BOLD, 20));
        btnAddDataConsultation.setFocusPainted(false);
        btnAddDataConsultation.addActionListener(e -> {
            // add the data to the database
            String patientId = consultationTextFieldTopLeft1.getText();
            String sessionId = consultationTextFieldTopLeft2.getText();
            int licenseNumber = parseInt(consultationTextFieldTopLeft3.getText());
            String consultationId = consultationTextFieldTopLeft4.getText();
            int patientCount = parseInt(consultationtTextFieldTopLeft5.getText());
            int patientrequestedTime = parseInt(consultationTextFieldTopLeft6.getText());
            String description = consultationTextFieldTopLeft7.getText();

                try {
                    Date date = new Date();
                    int maxPatientCount = 0;
                    Consultation.addConsultationObject(patientId, sessionId, licenseNumber,date, maxPatientCount ,consultationId, patientCount, patientrequestedTime, description);
                    frame.dispose();
                    new ViewConsultation();
//                    new ViewConsultation();
                } catch (Exception ex) {


            }
        });
        // viwe the data in the consultation table
        JButton btnViewConsultation = new JButton(" View Consultation ");
        btnViewConsultation.setBounds(1000, 10, 200, 30);
        btnViewConsultation.setBackground(new Color(0x5E0393));
        btnViewConsultation.setForeground(new Color(0xFFFFFF));
        btnViewConsultation.setFont(new Font("Serif", Font.BOLD, 20));
        btnViewConsultation.setFocusPainted(false);
        btnViewConsultation.addActionListener(e -> {
            frame.dispose();
            new ViewConsultation();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 900);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(0xFFFEFE));
        frame.setIconImage(new ImageIcon("src\\GUI\\Image\\icon.png").getImage());

        // Delete consultation
        JButton btnDeleteConsultation = new JButton(" Delete Consultation ");
        btnDeleteConsultation.setBounds(580, 10, 200, 30);
        btnDeleteConsultation.setBackground(new Color(0x5E0393));
        btnDeleteConsultation.setForeground(new Color(0xFFFFFF));
        btnDeleteConsultation.setFont(new Font("Serif", Font.BOLD, 20));
        btnDeleteConsultation.setFocusPainted(false);
        btnDeleteConsultation.addActionListener(e -> {
            frame.dispose();
            new DeleteConsultation();
        });


        // Add the panel to frame
        frame.add(consultationPanelTopLeft1);
        frame.add(consultationPanelTopLeft2);
        frame.add(consultationPanelTopLeft3);
        frame.add(consultationPanelTopLeft4);
        frame.add(consultationPanelTopLeft5);
        frame.add(consultationPanelTopLeft6);
        frame.add(consultationPanelTopLeft7);
        frame.add(consultationPanelTopLeft8);
        frame.add(consultationPanelTopRight9);
        frame.add(panelBottom);
        frame.add(consultationPanelTopRightLong);



        // add the label to the panel
        consultationPanelTopLeft1.add(consultationlabelTopLeft1);
        consultationPanelTopLeft2.add(consultationlabelTopLeft2);
        consultationPanelTopLeft3.add(consultationlabelTopLeft3);
        consultationPanelTopLeft4.add(consultationlabelTopLeft4);
        consultationPanelTopLeft5.add(consultationlabelTopLeft5);
        consultationPanelTopLeft6.add(consultationlabelTopLeft6);
        consultationPanelTopLeft7.add(consultationlabelTopLeft7);

        panelBottom.add(btnBack);
        panelBottom.add(btnAddDataConsultation);
        panelBottom.add(btnViewConsultation);
        panelBottom.add(btnDeleteConsultation);

        // add the text field to the panel
        consultationPanelTopLeft1.add(consultationTextFieldTopLeft1);
        consultationPanelTopLeft2.add(consultationTextFieldTopLeft2);
        consultationPanelTopLeft3.add(consultationTextFieldTopLeft3);
        consultationPanelTopLeft4.add(consultationTextFieldTopLeft4);
        consultationPanelTopLeft5.add(consultationtTextFieldTopLeft5);
        consultationPanelTopLeft6.add(consultationTextFieldTopLeft6);
        consultationPanelTopLeft7.add(consultationTextFieldTopLeft7);



        frame.setVisible(true);
    }

}
