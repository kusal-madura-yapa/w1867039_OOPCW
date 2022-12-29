package ConsoleSystem;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Doctor extends Parson implements Serializable {

    // Doctor unique attributes (specialization, licence number)
    private String specialization;
    private int licenceNumber;

    // array list to store doctors
    public static ArrayList<Doctor> doctorArrayList = new ArrayList<Doctor>();

    /**
     * Constructor for Doctor
     * person details and doctor details from super class
     *
     * @param name           get the name according to the super class
     * @param surname        get the surname according to the super class
     * @param DateOfBirth    get the date of birth according to the super class
     * @param contactNumber  get the details of the doctor
     * @param specialization get the specialization of the doctor
     * @param licenceNumber  get the licence number of the doctor
     */
    public Doctor(String name, String surname, String DateOfBirth, String contactNumber, String specialization, int licenceNumber) {
        super(name, surname, DateOfBirth, contactNumber);
        this.specialization = specialization;
        this.licenceNumber = licenceNumber;
    }


    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @return licenceNumber the licenceNumber to set
     */
    public int getLicenceNumber() {
        return licenceNumber;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     * @param licenceNumber the licenceNumber to set
     */
    public void setLicenceNumber(int licenceNumber) {
        this.licenceNumber = licenceNumber;
    }


    /**
     * This method is used to add a doctor to the doctorArrayList
     *
     * @param name name of the doctor
     *             surname surname of the doctor
     *             DateOfBirth date of birth of the doctor
     *             contactNumber contact number of the doctor
     *             specialization specialization of the doctor
     *             licenceNumber licence number of the doctor
     *             doctorArrayList array list of doctors
     *             doctor doctor object
     *             doctorArrayList.add(doctor) add doctor object to the doctorArrayList
     *             System.out.println("Doctor added successfully") print message to the console
     *             this method is used to add a new doctor to the system
     */
    public static void addDoctorObject(String name, String surname, String DateOfBirth, String contactNumber, String specialization, int licenceNumber) {
        Doctor doctor = new Doctor(name, surname, DateOfBirth, contactNumber, specialization, licenceNumber);
        doctorArrayList.add(doctor);
        System.out.println("Doctor added successfully");

    }

    /**
     * @return getName() + " " + getSurname() + " " + getDateOfBirth() + " " + getContactNumber() + " " + getSpecialization() + " " + getLicenceNumber()
     */
    @Override
    public String toString() {
        System.out.println("Doctor details");
        return getName() + " " + getSurname() + " " + getDateOfBirth() + " " + getContactNumber() + " " + getSpecialization() + " " + getLicenceNumber();
    }

    /**
     * This method is used to print all the doctors in the doctorArrayList
     * using the toString method in the Doctor class
     */
    public static void printDoctorList() {
        for (Doctor doctor : doctorArrayList) {
            System.out.println(doctor);
        }
    }

    /**
     * findDoctorObject method is used to find a doctor in the doctorArrayList
     *
     * @param licenceNumber licence number of the doctor
     * @return doctor object
     * @return null if doctor is not found
     */
    public static void findDoctorObject(int licenceNumber) {
        for (int i = 0; i < doctorArrayList.size(); i++) {
            if (doctorArrayList.get(i).getLicenceNumber() == licenceNumber) {
                System.out.println(doctorArrayList.get(i));
                // if you need to delete a doctor from the doctorArrayList
                // you can use the remove method
                doctorRemoveProcess(i);
                saveDoctorListToFileAfterDelete();
            }
        }
    }

    /**
     * This method is used to remove a doctor from the doctorArrayList
     *
     * @param index index of the doctor in the doctorArrayList
     *              doctorArrayList.remove(i) remove the doctor from the doctorArrayList
     *              System.out.println("Doctor removed successfully") print message to the console
     */
    public static void doctorRemoveProcess(int index) {
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to remove this doctor from the system? (Y/N)");
        String answer = input.nextLine();
        if (answer.equals("Y") || answer.equals("y")) {
            doctorArrayList.remove(index);
            System.out.println("Doctor removed successfully");
            countDoctorList();
        } else if (answer.equals("N") || answer.equals("n")) {
            System.out.println("Doctor not removed");
            countDoctorList();
        } else {
            System.out.println("Invalid input");
        }
    }

    /**
     * This method is used to count the number of doctors in the doctorArrayList
     *
     * @print doctorArrayList.size() number of doctors in the doctorArrayList
     */
    public static void countDoctorList() {
        int lastNumberOfDoctors = doctorArrayList.size();
        System.out.println("Still we have " + lastNumberOfDoctors + " number of  doctors in the system.");
    }


    /**
     * this methode sort the array list of doctors by their surName
     *
     * @param doctorArrayList array list of doctors
     *                        previous arrayList updated as the sorted arrayList.
     */
    public static void sortDoctorListBySurName(ArrayList<Doctor> doctorArrayList) {

        for (int i = 0; i < doctorArrayList.size(); i++) {
            for (int j = 0; j < doctorArrayList.size(); j++) {
                // compare the surName of the doctors in the array list check if the surName of the doctor
                // in the index i is less than the surName of the doctor in the index j based on the ASCII table
                // if the ascii value is less than 0 then swap the doctors in the array list.
                if (doctorArrayList.get(i).getSurname().compareTo(doctorArrayList.get(j).getSurname()) < 0) {
                    Doctor temp = doctorArrayList.get(i);
                    doctorArrayList.set(i, doctorArrayList.get(j));
                    doctorArrayList.set(j, temp);
                }
            }
        }
        System.out.println("Doctors list sorted by surname");
    }

    // when delete a doctor from the system the doctorArrayList will be updated and need to update the doctorArrayList in the file

    public static void saveDoctorListToFileAfterDelete() {
        try {
            FileWriter fileWriter = new FileWriter("doctors.txt");
            Writer output = new BufferedWriter(fileWriter);
            for (int i = 0; i < doctorArrayList.size(); i++) {
                output.write(doctorArrayList.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) { // if any missing file or any other error
            JOptionPane.showMessageDialog(null, "Error in saving this file");
        }
    }

    /**
     * this methode going to sve the arrayList data in to a file called doctors.txt
     */
    public static void saveDoctorListToFile() {
        try {
            FileWriter fileWriter = new FileWriter("doctors.txt");
            Writer output = new BufferedWriter(fileWriter);
            for (int i = 0; i < doctorArrayList.size(); i++) {
                output.write(doctorArrayList.get(i).toString() + "\n");
            }
            output.close();
        } catch (Exception e) { // if any missing file or any other error
            JOptionPane.showMessageDialog(null, "Error in saving this file");
        }
    }

    /**
     * this methode going to load the arrayList data from a file called doctors.txt
     */

    public static void loadDoctorListFromFile()  {

        try {
            FileReader fileReader = new FileReader("doctors.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] doctorDetails = line.split(" ");
                Doctor.addDoctorObject(doctorDetails[0], doctorDetails[1], doctorDetails[2], doctorDetails[3], doctorDetails[4], Integer.parseInt(doctorDetails[5]));
            }
            bufferedReader.close();
        } catch (Exception e) { // if any missing file or any other error
            System.out.println("Error in loading this file");

        }
    }


}

