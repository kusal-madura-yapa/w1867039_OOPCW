package ConsoleSystem;

import java.util.Scanner;

public class WestminsterSkinConsultationManager {


    public static String consoleCommand;


    //main method.
    public static void main(String[] args) {
        consoleMenu();
    }


    public static void consoleMenu() {
        System.out.println("===============================================================\n" +
                "Welcome to Westminster Skin Consultation Manager\n" +
                "===============================================================\n" +
                "Please select one of the following Letters to Execute:\n" +
                "A. Add a new Doctor.\n" +
                "P. Print the list of the doctors.\n" +
                "F. Find a Doctor and Delete a doctor.\n" +
                "S. Sort Doctors by SurName and Save.\n" +
                "L. Load the Doctors from the file.\n" +
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
    public static void consoleCommandSwitch(String consoleCommand) {

        switch (consoleCommand) {
            case "A":
                addDoctor();
                break;
            case "P":
                Doctor.sortDoctorListBySurName(Doctor.doctorArrayList);
                Doctor.printDoctorList();
                consoleMenu();
                break;
            case "F":
                findDoctor();
                consoleMenu();
                break;
            case "S":
//               Doctor.sortDoctorListBySurName(Doctor.doctorArrayList);
                Doctor.saveDoctorListToFile();
                consoleMenu();
            case "E":
                Doctor.sortDoctorListBySurName(Doctor.doctorArrayList);
                System.exit(0);
                break;
            case "L":
//              Doctor.loadDoctorListFromFile();
                consoleMenu();
                break;
            default:
                System.out.println("Please enter a valid letter");
                consoleMenu();
                break;
        }
    }


    /**
     * Add a new Doctor only 10 allowed in the system
     * get the details of the doctor
     * add the doctor to the doctor array list
     */
    public static void addDoctor() {
        if (Doctor.doctorArrayList.size() < 10) {
            boolean boolcatch = false;
        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Please enter the Doctor's name: ");
                String name = input.nextLine();
                System.out.println("Please enter the Doctor's surname: ");
                String surname = input.nextLine();
                System.out.println("Please enter the Doctor's Date of Birth: ");
                String DateOfBirth = input.nextLine();
                System.out.println("Please enter the Doctor's contact number: ");
                String contactNumber = input.nextLine();
                System.out.println("Please enter the Doctor's specialization: ");
                String specialization = input.nextLine();
                System.out.println("Please enter the Doctor's licence number: ");
                int licenceNumber = input.nextInt();
                Doctor.addDoctorObject(name, surname, DateOfBirth, contactNumber, specialization, licenceNumber);
                consoleMenu();
                System.out.println("Doctor added successfully");
                boolcatch = true;
            } catch (Exception e) {
                System.out.println("Invalid input");
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
    public static void findDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the Doctor's licence number: ");
        int licenceNumber = scanner.nextInt();
        Doctor.findDoctorObject(licenceNumber);
        consoleMenu();
    }
}





