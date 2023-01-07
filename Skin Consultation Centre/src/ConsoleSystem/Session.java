package ConsoleSystem;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Session {

    private String sessionID;
    private int licenceNumber;
    private Date sessionDateTime;
    private int maxPatients;

    // session ArrayList
    public static ArrayList<Session> sessionList = new ArrayList<Session>();
    //    // session constructor
    public Session(String sessionID, int licenceNumber, Date sessionDate, int maxPatients) {
        this.sessionID = sessionID;
        this.licenceNumber = licenceNumber;
        this.sessionDateTime = sessionDate;
        this.maxPatients = maxPatients;
    }

    // Getters and Setters

    // get sessionID
    public String getSessionID() {
        return sessionID;
    }

    // get licenceNumber
    public int getLicenceNumber() {
        return licenceNumber;
    }

    // get sessionDate
    public Date getSessionDateAndTime() {
        return sessionDateTime;
    }

    // get maxPatients
    public int getMaxPatients() {
        return this.maxPatients;
    }


    // set sessionID
    public static void setSessionID(String sessionID) {
        sessionID = sessionID;
    }

    // set doctorID
    public void setlicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }


    // set sessionDateAndTime
    public void setSessionDateAndTime(Date sessionDate) {
        this.sessionDateTime = sessionDate;
    }

    // set maxPatients
    public void setMaxPatients(int maxPatients) {
        this.maxPatients = maxPatients;
    }





    //check the session date already exist or not by pass the session date and return true or false
    public static boolean checkSessionDate(Date sessionDate) {
        for (Session session : sessionList) {
            if (session.getSessionDateAndTime().equals(sessionDate)) {
                return false;
            }
        }
        return true;
    }

    //find the session object by passing the sessionID and return the session object

    public static Session findSessionObject(String sessionID) {
        for (Session session : sessionList) {
            if (session.getSessionID().equals(sessionID)) {
                return session;
            }
        }
        return null;
    }
    // check the session id already get or not
    public static boolean sessionIDCheck(String sessionID) {
        for (Session session : sessionList) {
            if (session.getSessionID().equals(sessionID)) {
                return false;
            }
        }
        return true;

    }


    // add session
    public static void addSessionObject(String sessionID, int licenceNumber, Date sessionDateTime, int maxPatients) {
        // check the doctorID is valid
        if (sessionIDCheck(sessionID)) {
            if (Doctor.checkDoctorAlreadyInList(licenceNumber)) {
                if (checkSessionDate(sessionDateTime)) {
                    if (maxPatients > 0) {
                        // create a new session object
                        Session session = new Session(sessionID, licenceNumber, sessionDateTime,
                                maxPatients);
                        // add the session object to the sessionList
                        sessionList.add(session);
                        // write the session object to the session.txt
                        saveSessionIntoFile();
                        // print a success message
                        System.out.println("Session added successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Max patients should be greater than 0");
                    }
                } else {
                    // print an error message
                    System.out.println("Error: Session date must be invalid.");
                }
            } else {
                // print an error message
                System.out.println("Error: licence number does not exist.");
            }
        } else {
            // print an error message
            System.out.println("Error: Session ID already exists.");
        }
    }


    @Override
    public String toString() {
        return getSessionID() + "," + getLicenceNumber() + "," + getSessionDateAndTime() + "," + getMaxPatients();
    }

    // display all sessions
    public static void displayAllSessions() {
        for (Session session : sessionList) {
            System.out.println(session);
        }
    }

    // save session into file
    public static void saveSessionIntoFile() {
        // delete the array list and save the information
        try {
            FileWriter fileWriter = new FileWriter("session.txt");
            Writer output = new BufferedWriter(fileWriter);

            //DELETE THE CONTENT OF THE FILE
            output.write("");
            // write the doctorArrayList to the file
            for (int i = 0; i < sessionList.size(); i++) {
                output.write(sessionList.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) { // if any missing file or any other error
            JOptionPane.showMessageDialog(null, "Error in saving this file");
        }
    }

    // load the session from the session.txt
    public static void loadSessionFromFile() {

        // clear the sessionList
        sessionList.clear();
        try {
            FileReader fileReader = new FileReader("session.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // ARRAY LIST OF DOCTORS SHOULD BE EMPTY
            while ((line = bufferedReader.readLine()) != null) {
                String[] sessionDetails = line.split(",");
                String sessionID = sessionDetails[0];
                int licenceNumber = Integer.parseInt(sessionDetails[1]);
                Date sessionDateTime = Doctor.StringToDate(sessionDetails[2]);
                int maxPatients = Integer.parseInt(sessionDetails[3]);
                Session session = new Session(sessionID, licenceNumber, sessionDateTime, maxPatients);
                sessionList.add(session);
            }
            bufferedReader.close();
        } catch (Exception e) { // LOOP NOT CRASHING IF FILE NOT FOUND

        }
    }

}
