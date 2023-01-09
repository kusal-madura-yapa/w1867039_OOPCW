package GUI;

import ConsoleSystem.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class RemoveSession extends JFrame {
    RemoveSession(){
        JFrame frame = new JFrame("Westminster Center Add Session");
        // load the data from the file
        Session.loadSessionFromFile();

        // panel top left  1
        JPanel removePanelTopLeft1 = new JPanel(); // Session ID
        removePanelTopLeft1.setBounds(0, 10, 800, 40); // set the size of the panel
        removePanelTopLeft1.setBackground(new Color(0x212121));// set the background color of the panel
        removePanelTopLeft1.setLayout(null);// set the layout of the panel
        removePanelTopLeft1.setVisible(true);// set the visibility of the panel
        removePanelTopLeft1.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel



        // panel top left  5
        JPanel removePanelForTableOfSesssion = new JPanel();  // patient address
        removePanelForTableOfSesssion.setBounds(0, 250, 1000, 300); // set the size of the panel
        removePanelForTableOfSesssion.setBackground(new Color(0x212121));// set the background color of the panel
        removePanelForTableOfSesssion.setLayout(null);// set the layout of the panel
        removePanelForTableOfSesssion.setVisible(true);// set the visibility of the panel
        removePanelForTableOfSesssion.setLayout(new GridLayout(1, 2, 10, 10)); // set the layout of the panel



        JTable reomveTable = new JTable();
        Object[] columns = {"Session ID", "Licence Number", "Session Date and Time", "Max Patients"};
        // create a table model and design the table as not edit by using the override method
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        reomveTable.setModel(model);
        JScrollPane pane = new JScrollPane(reomveTable);
        pane.setBounds(0, 0, 1000, 455);
        pane.setForeground(new Color(0x474783));



        // Labels for the panel top left
        JLabel removelabelTopLeft1 = new JLabel(" * Enter Session ID to remove : ");
        removelabelTopLeft1.setBounds(0, 0, 250, 30); // set the size of the label
        removelabelTopLeft1.setForeground(Color.WHITE); // set the color of the text
        removelabelTopLeft1.setFont(new Font("Arial", Font.BOLD, 20)); // set the font of the text
        removelabelTopLeft1.setHorizontalAlignment(JLabel.LEFT); // set the alignment of the text
        removelabelTopLeft1.setVisible(true); // set the visibility of the label





        // Text fields for the panel top left
        JTextField removeTextFieldTopLeft1   = new JTextField(); // patient name
        removeTextFieldTopLeft1.setPreferredSize(new Dimension(300, 40)); // set the size of the text field
        removeTextFieldTopLeft1.setFont(new Font("Arial", Font.PLAIN, 20)); // set the font of the text field
        removeTextFieldTopLeft1.setVisible(true); // set the visibility of the text field
        removeTextFieldTopLeft1.setBackground(new Color(0xA6A0A8)); // set the background color of the text field


        // create a panel for the bottom of the frame
        JPanel removePanelBottom = new JPanel();
        removePanelBottom.setBounds(0, 710, 1000, 50); // set the size of the panel
        removePanelBottom.setBackground(new Color(0x212121));// set the background color of the panel
        removePanelBottom.setLayout(null);// set the layout of the panel
        removePanelBottom.setVisible(true);// set the visibility of the panel

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
        JButton btnAddDataSession = new JButton(" Remove Session ");
        btnAddDataSession.setBounds(750, 10, 220, 30);
        btnAddDataSession.setBackground(new Color(0x5E0393));
        btnAddDataSession.setForeground(new Color(0xFFFFFF));
        btnAddDataSession.setFont(new Font("Serif", Font.BOLD, 20));
        btnAddDataSession.setFocusPainted(false);
        btnAddDataSession.setVisible(true);
        btnAddDataSession.addActionListener(e -> {
            // get the data from the text field
            String sessionID = removeTextFieldTopLeft1.getText();

            // find and remove the session

            for (int i = 0; i < Session.sessionList.size(); i++) {
                if (Session.sessionList.get(i).getSessionID().equals(sessionID)) {
                    Session.sessionList.remove(i);
                    Session.saveSessionIntoFile();
                    break;
                }
            }

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
        reomveTable.setModel(model);  // set the model of the table

        reomveTable.setBackground(new Color(0xAD91E7)); // set the background color of the table
        reomveTable.setForeground(new Color(0x000000)); // set the foreground color of the table
        reomveTable.setGridColor(new Color(0xFFFFFF)); // set the grid color of the table
        reomveTable.setSelectionBackground(new Color(0xFFFFFF));
        reomveTable.setAutoCreateRowSorter(false); // set the auto create row sorter of the table to false
        reomveTable.setFont(new Font("Serif", Font.PLAIN, 15));
        reomveTable.setRowHeight(40); // set the row height of the table
        reomveTable.setAutoCreateRowSorter(true); // set the auto create row sorter of the table to true
        removePanelForTableOfSesssion.add(pane); // add the scroll pane to the frame
        removePanelForTableOfSesssion.add(removePanelBottom); // add the panel to the frame


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
        frame.add(removePanelTopLeft1);
        frame.add(removePanelForTableOfSesssion);
        frame.add(removePanelBottom);


        // add the label to the panel
        removePanelTopLeft1.add(removelabelTopLeft1);


        // add the text field to the panel
        removePanelTopLeft1.add(removeTextFieldTopLeft1);


        // add the button to the panel
        removePanelBottom.add(btnBack);
        removePanelBottom.add(btnAddDataSession);


        frame.setVisible(true);
    }

}

