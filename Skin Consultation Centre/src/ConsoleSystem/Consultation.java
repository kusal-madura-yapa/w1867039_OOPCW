package ConsoleSystem;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Consultation extends Session {

    private String consultationID;

    private int patientCount;

    private Date sessionDate;

    private String patientID;
    private int requestedTime;
    private double sessionCost;
    private String description;

    // consultation List
    public static ArrayList<Consultation> consultationList = new ArrayList<Consultation>();


    // consultation constructor
    public Consultation(String patientID, String sessionID, int licenceNumber, Date sessionDate, int maxPatients, String consultationID, int patientCount, int requestedTime, String description ,double sessionCost) {
        super(sessionID, licenceNumber, sessionDate, maxPatients);
        this.patientID = patientID;
        this.consultationID = consultationID;
        this.patientCount = patientCount;
        this.requestedTime = requestedTime;
        this.description = description;
        this.sessionCost = sessionCost;
    }

    // Getters and Setters


    // get patientID
    public String getPatientID() {
        return patientID;
    }
    // get consultationID
    public String getConsultationID() {
        return consultationID;
    }

    // get patientCount

    public int getPatientCount() {
        return patientCount;
    }

    // get requestedTime

    public int getRequestedTime() {
        return requestedTime;
    }

    // get description

    public String getDescription() {
        return description;
    }

    // get sessionCost
    public double getSessionCost() {
        return sessionCost;
    }

    // set consultationID

    // set patientID
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    public void setConsultationID(String consultationID) {
        this.consultationID = consultationID;
    }

    // set patientCount

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    // set requestedTime

    public void setRequestedTime(int requestedTime) {
        this.requestedTime = requestedTime;
    }

    // set description

    public void setDescription(String description) {
        this.description = description;
    }

    // set sessionCost
    public void setSessionCost(double sessionCost) {
        this.sessionCost = sessionCost;
    }
    // consultation Id check
    public static boolean consultationIDCheck(String consultationID) {
        for (Consultation consultation : consultationList) {
            if (consultation.getConsultationID().equals(consultationID)) {
                return false;
            }
        }
        return true;
    }

    // patient count check
    public static boolean MaxmumPationtCheck(String SessionID, int maxPatient, int patientCount, int licenceNumber, Date sessionDate) {

        for (Session session : Session.sessionList) {
            if (session.getSessionID().equals(SessionID)) {
                maxPatient = session.getMaxPatients();

                maxPatient = maxPatient - patientCount;
                int temp = maxPatient;
                if (maxPatient < 0) {
                    return false;

                } else {
                    Session.sessionList.remove(session);
                    Session.addSessionObject(SessionID, licenceNumber, sessionDate, temp);
                    return true;
                }
            }
            break;
        }
        return true;
    }


    // Description encryption
    public static String encryptDescription(String description) {
        String encryptedDescription = "";
        for (int i = 0; i < description.length(); i++) {
            encryptedDescription += (char) (description.charAt(i) + 1);
        }
        return encryptedDescription;
    }

    // Description decryption
    public static String decryptDescription(String description) {
        String decryptedDescription = "";
        for (int i = 0; i < description.length(); i++) {
            decryptedDescription += (char) (description.charAt(i) - 1);
        }
        return decryptedDescription;
    }

    // get session max patient
    public static int getmaxPatientFromSessionID(String sessionID) {
        int maxPatient = 0;
        for (Session session : Session.sessionList) {
            if (session.getSessionID().equals(sessionID)) {
                maxPatient = session.getMaxPatients();
            }
        }
        return maxPatient;
    }

    // get session date in Date type
    public static Date getSessionDateFromSessionID(String sessionID) {
        Date sessionDate = null;
        for (Session session : Session.sessionList) {
            if (session.getSessionID().equals(sessionID)) {
                sessionDate = session.getSessionDateAndTime();
            }
        }
        return sessionDate;
    }
    // add consultation object

    /**
     * @param consultationID // consultation id
     * @param patientId      // patient id
     * @param sessionID      // session id
     * @param licenceNumber  //  licence number
     * @param sessionDate    // session date
     * @param maxPatients    // max patient
     * @param consultationID // consultation id
     * @param patientCount   // patient count
     * @param requestedTime  // requested time
     * @param description    // description
     */
    public static void addConsultationObject(String patientId, String sessionID, int licenceNumber, Date sessionDate, int maxPatients, String consultationID, int patientCount, int requestedTime, String description) {
        if (!Session.sessionIDCheck(sessionID)) {
            if (Doctor.checkDoctorAlreadyInList(licenceNumber)) {
                maxPatients = getmaxPatientFromSessionID(sessionID);
                sessionDate = getSessionDateFromSessionID(sessionID);
                if (MaxmumPationtCheck(sessionID, maxPatients, patientCount, licenceNumber, sessionDate)) {
                    if (Patient.checkPatientId(patientId)) {
                        System.out.println("Patient ID is valid");
                        if (consultationIDCheck(consultationID)) {
                            System.out.println("Consultation ID is valid");
//                            encryptDescription(description);
                            double price =  priceCalculation(patientId,requestedTime, patientCount);
                            System.out.println("Price is : " + price);
                            Consultation consultation = new Consultation(patientId, sessionID, licenceNumber, sessionDate, maxPatients, consultationID, patientCount, requestedTime, description, price);
                            consultationList.add(consultation);
                            System.out.println("Consultation added successfully");
                            saveConsultationIntoFile();
                        } else {
                            System.out.println("Consultation ID already in used");
                        }
                    } else {
                        System.out.println("Patient ID not found");
                    }
                } else {
                    System.out.println("Maximum patient number exceeded");
                }
            } else {
                System.out.println("Doctor is not in the list");
            }
        } else {
            System.out.println("Session ID does not exist");
        }
    }

    // Price Calculation if patient is old one 25 euro new one 15 euro.

    public static double priceCalculation(String patientID, int requestedTime, int patientCount) {
        double price = 0;
        double requestTime = 0.0;
        requestTime = requestedTime;
        for (Consultation consultation :  Consultation.consultationList) {
            if (consultation.getPatientID().equals(patientID)) {
                price = (requestTime/60.0)*25;
                price= price * patientCount;
                return price;
            }
            if (!consultation.getPatientID().equals(patientID)) {
                price = (requestTime/60.0)*15;
                price= price * patientCount;
                return price;
            }
        }

      return price;

    }


    // toString method
    @Override
    public String toString() {
        return getPatientID()+","+getSessionID() + "," + getLicenceNumber() + "," + getSessionDateAndTime() + "," + getMaxPatients() + "," + getConsultationID() + "," + getPatientCount() + "," + getRequestedTime() + "," + getDescription()+","+getSessionCost();
    }

    // save consultation into file
    public static void saveConsultationIntoFile() {
        try {
            FileWriter fileWriter = new FileWriter("ConsultationDetails.txt");
            Writer output = new BufferedWriter(fileWriter);

            //FILE CLERAING
            output.write("");
            for (int i = 0; i < consultationList.size(); i++) {
                output.write(consultationList.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) { // if any missing file or any other error
            JOptionPane.showMessageDialog(null, "Error in saving this file");
        }
    }

    // load consultation from file
    public static void loadConsultationFromFile() {
        try {
            FileReader fileReader = new FileReader("ConsultationDetails.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // ARRAY LIST EMPTY PATIENT DETAILS
            consultationList.clear();
            // read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                String[] consultationDetails = line.split(",");
                // add the consultation details to the array list
                String patientID = consultationDetails[0];
                String sessionID = consultationDetails[1];
                int licenceNumber = Integer.parseInt(consultationDetails[2]);
                Date sessionDate = Doctor.StringToDate(consultationDetails[3]);
                int maxPatients = Integer.parseInt(consultationDetails[4]);
                String consultationID = consultationDetails[5];
                int patientCount = Integer.parseInt(consultationDetails[6]);
                int requestedTime = Integer.parseInt(consultationDetails[7]);
                String description = consultationDetails[8];
                double price = Double.parseDouble(consultationDetails[9]);
                Consultation consultation = new Consultation(patientID, sessionID, licenceNumber, sessionDate, maxPatients, consultationID, patientCount, requestedTime, description,price);
                consultationList.add(consultation);
            }
            bufferedReader.close();
        } catch (Exception e) { // if any missing file or any other error
            System.out.println("Error in loading this file");
        }
    }

    // delete consultation object
    public static void deleteConsultationObject(String consultationID) {
        if (consultationIDCheck(consultationID)) {
            for (int i = 0; i < consultationList.size(); i++) {
                if (consultationList.get(i).getConsultationID().equals(consultationID)) {
                    consultationList.remove(i);
                    saveConsultationIntoFile();
                }
            }
        } else {
            System.out.println("Consultation ID does not exist");
        }
    }
}
