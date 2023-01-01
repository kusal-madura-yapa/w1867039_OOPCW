package ConsoleSystem;

import java.util.ArrayList;

public class Consultation {

    private String consultationID;
    private String patientID;
    private String doctorID;
    private String consultationDate;
    private String consultationTime;
    private String consultationDescription;

    // consultation ArrayList
    private static ArrayList<Consultation> consultationList = new ArrayList<Consultation>();

    // consultation constructor
    public Consultation(String consultationID, String patientID, String doctorID, String date, String time, String description) {
        this.consultationID = consultationID;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.consultationDate = date;
        this.consultationTime = time;
        this.consultationDescription = description; // description of the consultation should be a string, and it wants to be encrypted
    }

    // Getters and Setters
    // get consultationID
    public String getConsultationID() {
        return consultationID;
    }

    // get patientID
    public String getPatientID() {
        return patientID;
    }

    // get doctorID
    public String getDoctorID() {
        return doctorID;
    }

    // get date
    public String getConsultationDate() {
        return consultationDate;
    }

    // get time

    public String getConsultationTime() {
        return consultationTime;
    }

    // get description

    public String getConsultationDescription() {
        return consultationDescription;
    }

    // set consultationID
    public void setConsultationID(String consultationID) {
        this.consultationID = consultationID;
    }

    // set patientID
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    // set doctorID
    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    // set date
    public void setConsultationDate(String consultationDate) {
        this.consultationDate = consultationDate;
    }

    // set time
    public void setConsultationTime(String consultationTime) {
        this.consultationTime = consultationTime;
    }

    // set description

    public void setConsultationDescription(String consultationDescription) {
        this.consultationDescription = consultationDescription;
    }


    // add consultation

    /**
     * @param consultationID get the consultation ID
     * @param patientID      get the patient ID
     * @param doctorID       get the doctor ID
     * @param date           get the date
     * @param time           get the time
     * @param description    get the description
     */
    public static void addConsultationObject(String consultationID, String patientID, String doctorID, String date, String time, String description) {
        Consultation consultation = new Consultation(consultationID, patientID, doctorID, date, time, description);
        consultationList.add(consultation);
        System.out.println("Consultation added successfully");
    }


    // find consultation

    /**
     * @param consultationID get the consultation ID anf find in the array list by use of the loop
     */
    public static void findConsultation(String consultationID) {
        for (Consultation consultation : consultationList) {
            if (consultation.getConsultationID().equals(consultationID)) {
                System.out.println("Consultation ID: " + consultation.getConsultationID());
                System.out.println("Patient ID: " + consultation.getPatientID());
                System.out.println("Doctor ID: " + consultation.getDoctorID());
                System.out.println("Date: " + consultation.getConsultationDate());
                System.out.println("Time: " + consultation.getConsultationTime());
                System.out.println("Description: " + consultation.getConsultationDescription());
            }
        }
    }

    // delete consultation

    /**
     * @param consultationID get the consultation ID and delete from the array list by use of the loop
     */
    public static void deleteConsultationObject(String consultationID) {
        for (Consultation consultation : consultationList) {
            if (consultation.getConsultationID().equals(consultationID)) {
                consultationList.remove(consultation);
                System.out.println("Consultation deleted successfully");
            }
        }
    }

    // show available doctors

    /**
     * @param doctorID get the doctor ID and show the available doctors by use of the loop
     */
    public static void showAvailableDoctors(String doctorID) {
        for (Consultation consultation : consultationList) {
            if (consultation.getDoctorID().equals(doctorID)) {
                System.out.println("Doctor ID: " + consultation.getDoctorID());
            }
        }}
}
