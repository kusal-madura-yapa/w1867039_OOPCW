package ConsoleSystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Scanner;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {


    public static String consoleCommand;


    //main method.
    public static void main(String[] args) {
        WestminsterSkinConsultationManager westminsterSkinConsultationManager = new WestminsterSkinConsultationManager();
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
                "DF - Find Doctor\n" +
                "DL - Load  Doctors Details.\n" +
                "DO - Sort the Doctors Details.\n" +
                "DS - Save the Doctors Details.\n" +
                "CA - Add Consultation\n" +
                "CD - Delete Consultation\n" +
//                "PA - Add Patient\n" +
//                "PP - Display Patient\n" +
//                "PL - Load  Patients Details.\n" +
//                "PS - Save the Patients Details.\n" +


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
                Doctor.printDoctorList();
                break;
            case "DF": // in find include the delete option also
                findDoctor();
                break;
            case "DS":
                Doctor.loadDoctorListFromFile();
                Doctor.saveDoctorListToFile();
                break;

            case "CA":
                addConsultation();
                break;

            case "CD":
                deleteConsultation();
                break;

//            case "PL":
//                Patient.loadPatientListFromFile();
//                consoleMenu();
//            case "PA":
//                addPatient();
//                consoleMenu();
//                break;
//            case "PS":
//                Patient.savePatientDetails();
//                consoleMenu();
//                break;
//            case "PP":
//                Patient.displayPatientDetails();
//                consoleMenu();
//                break;
            case "E":
                Patient.savePatientDetails();
                System.out.println("Thank you for using Westminster Skin Consultation Manager");
                System.exit(0);
            default:
                System.out.println("Please enter a valid letter");
                consoleMenu();
                break;
        }consoleMenu();
    }


    /**
     * Add a new Doctor only 10 allowed in the system
     * get the details of the doctor
     * add the doctor to the doctor array list
     */
    @Override
    public void addDoctor() {
        if (Doctor.doctorArrayList.size() < 10) {
            boolean boolcatch = false;
            do {
                try {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Please enter the Doctor's name: ");
                    String name = input.nextLine();
                    System.out.println("Please enter the Doctor's surname: ");
                    String surname = input.nextLine();
                    System.out.println("Please enter the Doctor's Date of Birth format (dd/mm/yyyy) :  ");
                    String DateOfBirth = input.nextLine();
                    System.out.println("Please enter the Doctor's contact number: ");
                    String contactNumber = input.nextLine();
                    System.out.println("Please enter the Doctor's specialization [ Dermatologist, Medical , Cosmetic , General , Pediatrician");
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


//    // Patient part
//    @Override
//    public void addPatient() {
//        try {
//            Scanner input = new Scanner(System.in);
//            System.out.println("Please enter the Patient's name: ");
//            String name = input.nextLine();
//            System.out.println("Please enter the Patient's surname: ");
//            String surname = input.nextLine();
//            System.out.println("Please enter the Patient's Date of Birth: ");
//            String DateOfBirth = input.nextLine();
//            System.out.println("Please enter the Patient's contact number: ");
//            String contactNumber = input.nextLine();
//            System.out.println("Please enter the Patient's address: ");
//            String address = input.nextLine();
//            System.out.println("Please enter the Patient's patient number: ");
//            String patientNumber = input.nextLine();
//            System.out.println("Please enter the Patient's Email address: ");
//            String emailAddress = input.nextLine();
//            System.out.println("Please enter the Patient Gender Enter Male Or Female");
//            String patientGender = input.nextLine();
//            Patient.addPatientObject(name, surname, DateOfBirth, contactNumber, address, patientNumber, emailAddress, patientGender);
//            consoleMenu();
//            System.out.println("Patient added successfully");
//        } catch (Exception e) {
//            System.out.println("Invalid input");
//        }
//        consoleMenu();
//    }


    // add Consultation part

    /**
     * Add a new Consultation only 10 allowed in the system
     * get the details of the Consultation
     * add the Consultation to the Consultation array list
     */
    @Override
    public void addConsultation() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the Consultation's Id : ");
            String consultationId = input.nextLine();
            System.out.println("Please enter the Consultation patient Id : ");
            String patientId = input.nextLine();
            System.out.println("Please enter the Consultation's Doctor Id : ");
            String doctorId = input.nextLine();
            System.out.println("Please enter the Consultation's Date Format [DD/MM/YYYY] : ");
            String consultationDate = input.nextLine();
            System.out.println("Please enter the Consultation's Time Format 1H / 2H / 3H or Maximum 4H : ");
            String consultationTime = input.nextLine();
            System.out.println("Please enter the Consultation's Description : ");
            String consultationDescription = input.nextLine();
            Consultation.addConsultationObject(consultationId, patientId, doctorId, consultationDate, consultationTime, consultationDescription);
            consoleMenu();
            System.out.println("Consultation added successfully");

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        consoleMenu();
    }
    /**
     * Delete a Consultation
     * get the details of the consultation
     * delete the consultation from the consultation array list
     */
    @Override
    public void deleteConsultation() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the Consultation's Id : ");
            String consultationId = input.nextLine();
            Consultation.findConsultation(consultationId);
            System.out.println("Are you want to Delete the consultation,If yes please enter [Y] or enter any key: ");
            String delete = input.nextLine();
            if (delete.equals("Y")) {
                Consultation.deleteConsultationObject(consultationId);
                System.out.println("Consultation deleted successfully");
            } else {
                System.out.println("Consultation not deleted");
            }
            consoleMenu();
        } catch (Exception e) {
            System.out.println("Invalid input");
        }
        consoleMenu();
    }


}





