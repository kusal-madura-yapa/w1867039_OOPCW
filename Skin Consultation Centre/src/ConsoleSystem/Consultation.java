package ConsoleSystem;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Consultation extends Session {

    private String consultationID;

    private int patientCount;


    private int requestedTime;

    private String description;

    // consulatationList
    public static ArrayList<Consultation> consultationList = new ArrayList<Consultation>();

    // patent list for future usage first time patient can get the discount.
    public static ArrayList<String> patientList = new ArrayList<String>();


    // consultation constructor
    public Consultation(String sessionID, int licenceNumber, Date sessionDate, int maxPatients, String consultationID, int patientCount, int requestedTime, String description) {
        super(sessionID, licenceNumber, sessionDate, maxPatients);
        this.consultationID = consultationID;
        this.patientCount = patientCount;
        this.requestedTime = requestedTime;
        this.description = description;
    }

    // Getters and Setters
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

    // set consultationID

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
                if (!(maxPatient <= 0)) {
                    for (int i = 0; i < Session.sessionList.size(); i++) {
                        if (Session.sessionList.get(i).getSessionID().equals(SessionID)) {
                            Session.sessionList.remove(i);
                            Session.saveSessionIntoFile();
                            break;
                        }
                    }
                    Session.addSessionObject(SessionID, licenceNumber, sessionDate, maxPatient);
                    return true;
                }
            }
        }
        return false;
    }

    // added patient store in arraylist
    public static void addPatientIDAddedDiscount(String patientID) {
                        patientList.add(patientID);
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



    // add consultation
    /**
     * @param consultationID
     * @param patientId
     * @param sessionID
     * @param licenceNumber
     * @param sessionDate
     * @param maxPatients
     * @param consultationID
     * @param patientCount
     * @param requestedTime
     * @param description
     */

    public static void addConsultationObject(String patientId, String sessionID, int licenceNumber, Date sessionDate, int maxPatients, String consultationID, int patientCount, int requestedTime, String description) {
        if (!sessionIDCheck(sessionID)) {
            if (Doctor.checkDoctorAlreadyInList(licenceNumber)) {
                if (MaxmumPationtCheck(sessionID, maxPatients, patientCount, licenceNumber, sessionDate)) {
                    if (Patient.checkPatientId(patientId)) {
                        if (consultationIDCheck(consultationID)) {
//                        upDateTime(sessionID, requestedTime);
                            encryptDescription(description);
                            Consultation consultation = new Consultation(sessionID, licenceNumber, sessionDate, maxPatients, consultationID, patientCount, requestedTime, description);
                            consultationList.add(consultation);
                            // price method
                            addPatientIDAddedDiscount(patientId);
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


    // toString method
    @Override
    public String toString() {
        return getSessionID() + "," + getLicenceNumber() +  "," + getMaxPatients() + "," + getConsultationID() + "," + getPatientCount() + "," + getRequestedTime() + "," + getDescription();
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
                String sessionID = consultationDetails[0];
                int licenceNumber = Integer.parseInt(consultationDetails[1]);
                Date sessionDate = Doctor.StringToDate(consultationDetails[2]);
                int maxPatients = Integer.parseInt(consultationDetails[3]);
                String consultationID = consultationDetails[4];
                int patientCount = Integer.parseInt(consultationDetails[5]);
                int requestedTime = Integer.parseInt(consultationDetails[6]);
                String description = consultationDetails[7];
                Consultation consultation = new Consultation(sessionID, licenceNumber, sessionDate, maxPatients, consultationID, patientCount, requestedTime, description);
                consultationList.add(consultation);

            }
            bufferedReader.close();
        } catch (Exception e) { // if any missing file or any other error
            System.out.println("Error in loading this file");

        }
    }



}
