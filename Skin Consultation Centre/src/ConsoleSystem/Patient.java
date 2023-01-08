package ConsoleSystem;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Patient extends Parson {
    // patient Unique details
    private String patientId;
    private String patientAddress;
    private String patientEmail;
    private String patientGender;


    // array list to store patients
    public static ArrayList<Patient> patientArrayList = new ArrayList<Patient>();

    /**
     * Constructor for Patient
     * person details and patient details from super class
     *
     * @param name get the name according to the super class
     * @param surname get the surname according to the super class
     * @param DateOfBirth   get the date of birth according to the super class
     * @param contactNumber  get the details of the patient
     * @param patientId get the patient id of the patient
     * @param patientAddress get the patient address of the patient
     * @param patientEmail get the patient email of the patient
     * @param patientGender get the person gender of the patient
     */
    public Patient(String name, String surname, Date DateOfBirth, String contactNumber, String patientId, String patientAddress, String patientEmail, String patientGender) {
        super(name, surname, DateOfBirth, contactNumber);
        this.patientId = patientId;
        this.patientAddress = patientAddress;
        this.patientEmail = patientEmail;
        this.patientGender = patientGender;

    }

    /**
     * @return the patientId
     */
    public String  getPatientId() {
        return patientId;
    }
    /**
     * @return the patientAddress
     */
    public String getPatientAddress() {
        return patientAddress;
    }
    /**
     * @return the patientEmail
     */
    public String getPatientEmail() {
        return patientEmail;}
    /**
     * @return the patientGender
     */
    public String getPatientGender() {
        return patientGender;
    }
    /**
     * @param patientId the patientId to set
     */

    public void setPatientId(String  patientId) {
        this.patientId = patientId;}

    /**
     * @param patientAddress the patientAddress to set
     */
    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;}
    /**
     * @param patientEmail the patientEmail to set
     */
    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;}
    /**
     * @param patientGender the patientGender to set
     */
    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;}




    // check the patient id is unique
    public static boolean checkPatientId(String patientId) {
        for (Patient patient : patientArrayList) {
            if (patient.getPatientId().equals(patientId)) {
                return false;
            }
        }
        return true;
    }


    // check the contact number is unique
    public static boolean checkContactNumber(String contactNumber) {
        for (Patient patient : patientArrayList) {
            if (patient.getContactNumber().equals(contactNumber)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param patientId the patientId to set
     * @param name the name to set
     * @param surname the surname to set
     * @param DateOfBirth the DateOfBirth to set
     * @param contactNumber the contactNumber to set
     * @param patientId the patientId to set
     * @param patientAddress the patientAddress to set
     * @param patientEmail the patientEmail to set
     * @param patientGender the patientGender to set
     */
    // method to add patient details
    public static void addPatientObject(String name, String surname, Date DateOfBirth, String contactNumber, String  patientId, String patientAddress, String patientEmail, String patientGender) {

        if (checkPatientId(patientId)) {
            if (checkContactNumber(contactNumber)) {
                Patient patient = new Patient(name, surname, DateOfBirth, contactNumber, patientId, patientAddress, patientEmail, patientGender);
                patientArrayList.add(patient);

            } else {
                JOptionPane.showMessageDialog(null, "Contact number already exists");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Patient ID already exists");
        }

    }


    // to String method to print patient details
    /**
     * @return the details stored in the array list
     */
    @Override
    public String toString() {
        return getName() + "," + getSurname() + "," + getDateOfBirth() + "," + getContactNumber()  + ","+ getPatientId()+ "," + getPatientAddress() +"," + getPatientEmail() + "," + getPatientGender();
    }
    /**
     *
     * @return the patient details print in the console
     */
    // method to display patient details
    public static void displayPatientDetails() {
        for (Patient patient : patientArrayList) {
            System.out.println(patient.toString());
        }

    }

    // method to save the patent details to a file
    /**
     *
     * handel the persorn data store in to the patient file
     * @throws IOException if the file is not found or not able to write
     * @return the patient details save in the file
     */
    public static void savePatientDetails() {

        try {
            FileWriter fileWriter = new FileWriter("PatientDetails.txt");
            Writer output = new BufferedWriter(fileWriter);
            //FILE CLERAING
            output.write("");
            for (int i = 0; i < patientArrayList.size(); i++) {
                output.write(patientArrayList.get(i).toString() + "\n");
            }
            output.close();
            System.out.println("Patient details saved successfully");
        } catch (Exception e) { // if any missing file or any other error
            JOptionPane.showMessageDialog(null, "Error in saving this file");
        }
    }

    // methode for get the details from the file

    public static void loadPatientListFromFile() {
        try {
            FileReader fileReader = new FileReader("PatientDetails.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // ARRAY LIST EMPTY PATIENT DETAILS
            patientArrayList.clear();
            // read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                String[] patientDetails = line.split(",");
                String name = patientDetails[0];
                String surname = patientDetails[1];
                Date dateOfBirth = Doctor.StringToDate(patientDetails[2]);
                String contactNumber = patientDetails[3];
                String address = patientDetails[4];
                String patientId = patientDetails[5];
                String email= patientDetails[6];
                String gender = patientDetails[7];
                Patient.addPatientObject(name,surname,dateOfBirth,contactNumber,patientId,address,email,gender);
            }
            bufferedReader.close();
            System.out.println("Patient details loaded successfully");
        } catch (Exception e) { // if any missing file or any other error
            System.out.println("Error in loading this file");

        }
    }
}
