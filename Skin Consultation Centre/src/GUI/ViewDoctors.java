package GUI;


import ConsoleSystem.Doctor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Objects;

public class ViewDoctors {

    ViewDoctors() {


        JTable table = new JTable();
        Object[] columns = {"Firstname ", "Surname ", "DateOfBirth", "Contact Number", "Specialization", "License Number"};
        DefaultTableModel model = new DefaultTableModel();




        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(new Color(0x474783));
        pane.setBackground(new Color(0xFFFFFF));
        pane.setBounds(10, 10, 800, 505);


        // IconImage
        ImageIcon imageIcon = new ImageIcon("src\\GUI\\Image\\icon.png");

        // Create a new JFrame container.
        JFrame frame = new JFrame("Welcome Westminster Center for Skin.");
        // normal creat frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setBackground(new Color(0x262628));
        frame.setIconImage(imageIcon.getImage());
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.setResizable(false);// prevent the frame from being resized
        frame.setLayout(null); // set the layout of the frame

        model.setColumnIdentifiers(columns);
        table.setModel(model);

        table.setBackground(new Color(0x9797B9));
        table.setForeground(new Color(0x4F4FDA));
        table.setGridColor(new Color(0x30307A));
        table.setSelectionBackground(new Color(0x39395D));
        table.setFont(new Font("Serif", Font.BOLD, 20));
        table.setRowHeight(30);
        table.setAutoCreateRowSorter(true);
        frame.getContentPane().add(pane);

        Doctor.doctorArrayList.forEach(doctor -> {
            Object[] row = new Object[6];
            row[0] = doctor.getName();
            row[1] = doctor.getSurname();
            row[2] = doctor.getDateOfBirth();
            row[3] = doctor.getContactNumber();
            row[4] = doctor.getSpecialization();
            row[5] = doctor.getLicenceNumber();
            model.addRow(row);
        });


        // frame visible.
        frame.setVisible(true);

    }


}
