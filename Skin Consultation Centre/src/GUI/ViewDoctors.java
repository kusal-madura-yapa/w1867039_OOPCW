package GUI;


import ConsoleSystem.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

public class ViewDoctors extends JFrame {

    ViewDoctors() {

        // Create a new JFrame container.
        JFrame frame = new JFrame("Welcome Westminster Center for Skin.");

        // get doctors from the array list
        Doctor.loadDoctorListFromFile();

        // create a table
        JTable table = new JTable();
        Object[] columns = {"Firstname ", "Surname ", "DateOfBirth", "Contact Number", "Specialization", "License Number"};

        // create a table model and design the table as not edit by using the override method
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);


        // add the table to the scroll pane for show the data in the table
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(0, 0, 1000, 455);
        pane.setForeground(new Color(0x474783));


        // create a panel for the bottom of the frame
        JPanel panelBottom = new JPanel();
        panelBottom.setBounds(0, 460, 1000, 50); // set the size of the panel
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

        // IconImage
        ImageIcon imageIcon = new ImageIcon("src\\GUI\\Image\\icon.png");


        // normal creat frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set the default close operation
        frame.setSize(1000, 550); // set the size of the frame
        frame.setBackground(new Color(0x6060E8)); // set the background color of the frame
        frame.setIconImage(imageIcon.getImage()); // set the icon of the frame
        frame.getContentPane().setLayout(null); // set the layout of the frame

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
        frame.getContentPane().add(pane); // add the scroll pane to the frame
        frame.add(panelBottom); // add the panel to the frame


        // add the data in to object and add the object to the table
        Doctor.doctorArrayList.forEach(doctor -> {
            Object[] row = new Object[6];
            row[0] = doctor.getName();
            row[1] = doctor.getSurname();
            row[2] = doctor.getDateOfBirth();
            row[3] = doctor.getContactNumber();
            row[4] = doctor.getSpecialization();
            row[5] = doctor.getLicenceNumber();
            // add row to the model
            model.addRow(row);
        });
        // frame visible.
        frame.setVisible(true);
        // add the button to the panel
        panelBottom.add(btnBack);
    }


}
