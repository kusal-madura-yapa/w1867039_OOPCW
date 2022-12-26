package ConsoleSystem;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
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
    public Patient(String name, String surname, String DateOfBirth, String contactNumber, String patientId, String patientAddress, String patientEmail, String patientGender) {
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
    public static void addPatientObject(String name, String surname, String DateOfBirth, String contactNumber, String  patientId, String patientAddress, String patientEmail, String patientGender) {
        Patient patient = new Patient(name, surname, DateOfBirth, contactNumber, patientId, patientAddress, patientEmail, patientGender);
        patientArrayList.add(patient);
    }


    // to String method to print patient details
    /**
     * @return the details stored in the array list
     */
    @Override
    public String toString() {
        System.out.println("Patient Details");
        return getName() + " " + getSurname() + " " + getDateOfBirth() + " " + getContactNumber() + " " + getPatientId() + " " + getPatientAddress() + " " + getPatientEmail() + " " + getPatientGender();
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
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Patient patient : patientArrayList) {
                bufferedWriter.write(patient.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    // methode for get the details from the file

    public static void loadPatientListFromFile() {
        try {
            FileReader fileReader = new FileReader("Patient.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] patientDetails = line.split(" ");
                String name = patientDetails[0];
                String surname = patientDetails[1];
                String DateOfBirth = patientDetails[2];
                String contactNumber = patientDetails[3];
                String patientId = patientDetails[4];
                String patientAddress = patientDetails[5];
                String patientEmail = patientDetails[6];
                String patientGender = patientDetails[7];

                Patient patient = new Patient(name, surname, DateOfBirth, contactNumber, patientId, patientAddress, patientEmail, patientGender);
                patientArrayList.add(patient);
            }
            bufferedReader.close();
        } catch (Exception e) { // if any missing file or any other error
            JOptionPane.showMessageDialog(null, "Error in loading this file");
        }
    }
}
