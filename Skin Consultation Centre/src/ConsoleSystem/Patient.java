package ConsoleSystem;

import java.util.ArrayList;
public class Patient extends Parson {
    // patient Unique details
    private int patientId;
    private String patientAddress;
    private String patientEmail;
    private String patientGender;

    // array list to store patients
    public static ArrayList<Patient> patientArrayList = new ArrayList<Patient>();

    /**
     * Constructor for Patient
     * person details and patient details from super class
     *
     * @param name
     * @param surname
     * @param DateOfBirth
     * @param contactNumber  get the details of the patient
     * @param patientId
     * @param patientAddress
     * @param patientEmail
     * @param patientGender
     */
    public Patient(String name, String surname, String DateOfBirth, String contactNumber, int patientId, String patientAddress, String patientEmail, String patientGender) {
        super(name, surname, DateOfBirth, contactNumber);
        this.patientId = patientId;
        this.patientAddress = patientAddress;
        this.patientEmail = patientEmail;
        this.patientGender = patientGender;

    }

    /**
     * @return the patientId
     */
    public int getPatientId() {
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

    public void setPatientId(int patientId) {
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

}
