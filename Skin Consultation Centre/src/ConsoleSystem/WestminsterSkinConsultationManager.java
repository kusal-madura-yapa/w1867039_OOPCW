package ConsoleSystem;

import javax.swing.*;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    public static String consoleCommand;
    //main method.
    public static void main(String[] args) {

        WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();
        Doctor.loadDoctorListFromFile();
        Patient.loadPatientListFromFile();
        Consultation.loadConsultationFromFile();
        Session.loadSessionFromFile();
        Consultation.loadConsultationFromFile();
        westminsterSkinConsultationManager.consoleMenu();

    }
    @Override
    public void consoleMenu() {

        System.out.println("===============================================================\n" +
                "Welcome to Westminster Skin Consultation Manager\n" +
                "===============================================================\n" +
                "Please select one of the following Letters to Execute:\n" +
                "DA - Add Doctor\n" +
                "DP - Display Doctor\n" +
                "DF - Find Doctor and Delete \n" +
                "DL - Load  Doctors Details.\n" +
                "DO - Sort the Doctors Details.\n" +
                "DS - Save the Doctors Details.\n" +
                "CA - Add Consultation\n" +
                "CD - Delete Consultation\n" +
                "AS - Add Session\n" +
                "SD - Display Session\n" +
                "PA - Add Patient\n" +
                "PP - Display Patient\n" +
                "PL - Load  Patients Details.\n" +
                "PS - Save the Patients Details.\n" +


                "E. Exit the Program.\n" +

                "===============================================================");
        Scanner userInput = new Scanner(System.in);
        consoleCommand = userInput.next();
        consoleCommandSwitch(consoleCommand);
    }
    /**
     * @param consoleCommand it will execute the command
     *                       according to the user input
     *                       and call the relevant method
     *                       to execute the command.
     */
    @Override
    public void consoleCommandSwitch(String consoleCommand) {

        switch (consoleCommand) {
            case "DA":
                addDoctor();
                break;
            case "DL":
                Doctor.loadDoctorListFromFile();
                break;
            case "DO":
                Doctor.sortDoctorListBySurName(Doctor.doctorArrayList);
            case "DP":
                Doctor.sortDoctorListBySurName(Doctor.doctorArrayList);
                Doctor.printDoctorList();
                break;
            case "DF": // in find include the delete option also
                findDoctor();
                break;
            case "DS":
                Doctor.sortDoctorListBySurName(Doctor.doctorArrayList);
                Doctor.saveDoctorListToFile();
                break;
            case "CA":
                addConsultation();
                break;
            case "CD":
                deleteConsultation();
                break;
            case "AS":
                addSessionByManager();
                break;
            case "SD":
                Session.displayAllSessions();
                break;

            case "E":
                System.out.println("Thank you for using Westminster Skin Consultation Manager");
                System.exit(0);
            case "PL":
                Patient.loadPatientListFromFile();
                consoleMenu();
            case "PA":
                addPatient();
                consoleMenu();
                break;
            case "PS":
                Patient.savePatientDetails();
                consoleMenu();
                break;
            case "PP":
                Patient.displayPatientDetails();
                consoleMenu();
                break;
            default:
                System.out.println("Please enter a valid letter");
                consoleMenu();
                break;
        }
        consoleMenu();
    }
    /**
     * Add a new Doctor only 10 allowed in the system
     * get the details of the doctor
     * add the doctor to the doctor array list
     */
    @Override
    public void addDoctor() {
        if (Doctor.doctorArrayList.size() <= 10) {
            boolean boolcatch = false;
            do {
                try {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please enter the Doctor's name: ");
                    String name = input.nextLine();
                    System.out.println("Please enter the Doctor's surname: ");
                    String surname = input.nextLine();
                    System.out.println("Please enter the Doctor's Date of Birth format (dd/mm/yyyy) :  ");
                    String dateOfBirth = input.nextLine();
                    Date DateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
                    System.out.println("Please enter the Doctor's contact number: ");
                    String contactNumber = input.nextLine();
                    System.out.println("Please enter the Doctor's specialization Dermatologist, Medical , Cosmetic , General , Pediatrician");
                    String specialization = input.nextLine();
                    System.out.println("Please enter the Doctor's licence number: ");
                    int licenceNumber = input.nextInt();
                    Doctor.addDoctorObject(name, surname, DateOfBirth, contactNumber, specialization, licenceNumber);
                    consoleMenu();
                    System.out.println("Doctor added successfully");
                    boolcatch = true;
                } catch (Exception e) {
                    System.out.println("Invalid input");
                    break;
                }
            } while (!boolcatch);
        } else {
            System.out.println("Doctor list is full");
        }
        consoleMenu();
    }

    /**
     * Find a Doctor
     * get the details of the doctor
     * add the doctor to the doctor array list
     */
    @Override
    public void findDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Doctor's licence number: ");
        int licenceNumber = scanner.nextInt();
        Doctor.findDoctorObject(licenceNumber);
        ;
    }

    /**
     * Add a new Patient only 10 allowed in the system
     * get the details of the patient
     * add the patient to the patient array list
     */

    @Override
    public void addSessionByManager() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the session ID : ");
            String sessionID = input.nextLine();
            System.out.println("Please enter the Doctor's licence number: ");
            int licenceNumber = input.nextInt();
            System.out.println("Please enter the Doctor's session Date and time dd/MM/yyyy/HH:mm : ");
            String SessionDate = input.nextLine();
            Date sessionDateTime = new SimpleDateFormat("dd/MM/yyyy/HH:mm").parse(SessionDate);
            System.out.println("Please enter the maximum patient going to see during the session : ");
            int maxPatients = input.nextInt();
//            Session session = new Session(licenceNumber,sessionDuration, sessionDate, maxPatients,sessionStartTime);
            Session.addSessionObject(sessionID, licenceNumber, sessionDateTime, maxPatients);
            System.out.println("Session added successfully");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
    // add Consultation part

    /**
     * Add a new Consultation only 10 allowed in the system
     * get the details of the Consultation
     * add the Consultation to the Consultation array list
     */
    @Override
    public void addConsultation() {
        Consultation.loadConsultationFromFile();
        Session.loadSessionFromFile();
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the Patient ID : ");
            String patientID = input.nextLine();
            System.out.println("Please enter the Consultation ID : ");
            String consultationID = input.nextLine();
            System.out.println("Please enter the Session ID: ");
            String sessionID = input.nextLine();
            System.out.println("Please enter the Doctor Licence Number: ");
            int licenceNumber = input.nextInt();
            System.out.println("Please enter the count of patient : ");
            int patientCount = input.nextInt();
            System.out.println("Please enter the Consultation duration in 30/60/120 minutes : ");
            int consultationDuration = input.nextInt();
            System.out.println("Please enter the Consultation description : ");
            String consultationDescription = input.next();
            consultationDescription += input.nextLine();
            System.out.println("\n");
            // no need to interrupt the user can get this details buy session id it already applies in below method
            int maxPatient = 10;
            Date sessionDateTime = new Date();
            Consultation.addConsultationObject(patientID, sessionID, licenceNumber, sessionDateTime, maxPatient, consultationID, patientCount, consultationDuration, consultationDescription);
            consoleMenu();
            System.out.println("Consultation added successfully");
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        consoleMenu();
    }


    // Delete Consultation part

    /**
     * Delete a Consultation
     * get the details of the Consultation
     * delete the Consultation from the Consultation array list
     */

    @Override
    public void deleteConsultation() {
        Consultation.loadConsultationFromFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Consultation ID to delete : ");
        String consultationID = scanner.nextLine();
        Consultation.deleteConsultationObject(consultationID);

    }

    // Patient part
    @Override
    public void addPatient() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the Patient's name: ");
            String name = input.nextLine();
            System.out.println("Please enter the Patient's surname: ");
            String surname = input.nextLine();
            System.out.println("Please enter the Patient's Date of Birth: ");
            String dateOfBirth = input.nextLine();
            Date DateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateOfBirth);
            System.out.println("Please enter the Patient's contact number: ");
            String contactNumber = input.nextLine();
            System.out.println("Please enter the Patient's address: ");
            String address = input.nextLine();
            System.out.println("Please enter the Patient's patient ID: ");
            String patientId = input.nextLine();
            System.out.println("Please enter the Patient's Email address: ");
            String emailAddress = input.nextLine();
            System.out.println("\n");
            String patientGender = "Male";
            Patient.addPatientObject(name, surname, DateOfBirth, contactNumber, address, patientId, emailAddress, patientGender);
            System.out.println("Patient added successfully");

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }
}





