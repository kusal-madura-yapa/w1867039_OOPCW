package GUI;

import ConsoleSystem.Doctor;
import ConsoleSystem.Patient;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewPatients {

    ViewPatients(){
        // Create a new JFrame container.
        JFrame frame = new JFrame("Welcome Westminster Center for Skin Patient Details.");
        Patient.loadPatientListFromFile();

        // create a table
        JTable tablePatient = new JTable();
        Object[] columns = {"Firstname ", "Surname ", "DateOfBirth", "Contact Number", "Patient ID", "Address","Email","Gender"};
        // create a table model and design the table as not edit by using the override method
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablePatient.setModel(model);



        // add the table to the scroll pane for show the data in the table
        JScrollPane pane = new JScrollPane(tablePatient);
        pane.setBounds(0, 0, 1000, 455); // set the size of the panel
        pane.setForeground(new Color(0x474783)); // set the color of the scroll pane

        // create a panel for the bottom of the frame
        JPanel panelBottom = new JPanel();
        panelBottom.setBounds(0, 460, 1000, 50);
        panelBottom.setBackground(new Color(0x212121));
        panelBottom.setLayout(null); // set the layout of the panel
        panelBottom.setVisible(true); // set the visibility of the panel


        // IconImage
        ImageIcon imageIcon = new ImageIcon("src\\GUI\\Image\\icon.png");


        // normal creat frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 550);
        frame.setBackground(new Color(0x6060E8));
        frame.setIconImage(imageIcon.getImage()); // set the icon of the frame
        frame.getContentPane().setLayout(null);


        frame.setResizable(false);// prevent the frame from being resized
        frame.setLayout(null); // set the layout of the frame

        model.setColumnIdentifiers(columns); // set the column identifiers of the table
        tablePatient.setModel(model); // set the model of the table

        tablePatient.setBackground(new Color(0xAD91E7)); // set the background color of the table
        tablePatient.setForeground(new Color(0x000000)); // set the foreground color of the table
        tablePatient.setGridColor(new Color(0xFFFFFF)); // set the grid color of the table
        tablePatient.setSelectionBackground(new Color(0xFFFFFF)); // set the selection background color of the table
        tablePatient.setAutoCreateRowSorter(false); // set the auto create row sorter of the table
        tablePatient.setFont(new Font("Serif", Font.PLAIN, 15)); // set the font of the table
        tablePatient.setRowHeight(40); // set the row height of the table
        tablePatient.setAutoCreateRowSorter(true); // set the auto create row sorter of the table
        frame.getContentPane().add(pane); // add the scroll pane to the frame

        // get the data in patient array list and add to the table
        Patient.patientArrayList.forEach(patient -> {
            Object[] row = new Object[7];
            row[0] = patient.getName();
            row[1] = patient.getSurname();
            row[2] = patient.getDateOfBirth();
            row[3] = patient.getContactNumber();
            row[4] = patient.getPatientId();
            row[5] = patient.getPatientAddress();
            row[6] = patient.getPatientEmail();
            row[7] = patient.getPatientGender();
            model.addRow(row);
        });


        // frame visible.
        frame.setVisible(true);


        // create a button for the bottom of the frame
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(0, 10, 100, 30);
        btnBack.setBackground(new Color(0x5E0393));
        btnBack.setForeground(new Color(0xFFFFFF));
        btnBack.setFont(new Font("Serif", Font.BOLD, 20));
        btnBack.addActionListener(e -> {
            frame.dispose();
            new HomePage();
        });
        // add the button to the panel
        panelBottom.add(btnBack);
        // add the panel to the frame
        frame.add(panelBottom);

    }




}
