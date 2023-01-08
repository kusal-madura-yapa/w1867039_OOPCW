package ConsoleSystem;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Doctor extends Parson implements Serializable {

    // Doctor unique attributes (specialization, licence number)
    private String specialization;// specialization of the doctor
    private int licenceNumber;// licence number of the doctor

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
    public Doctor(String name, String surname, Date DateOfBirth, String contactNumber, String specialization, int licenceNumber) {
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
    public static void addDoctorObject(String name, String surname, Date DateOfBirth, String contactNumber, String specialization, int licenceNumber) {
        Doctor doctor = new Doctor(name, surname, DateOfBirth, contactNumber, specialization, licenceNumber);
        doctorArrayList.add(doctor);
        System.out.println("Doctor added successfully");

    }

    /**
     * @return getName() + " " + getSurname() + " " + getDateOfBirth() + " " + getContactNumber() + " " + getSpecialization() + " " + getLicenceNumber()
     */
    @Override
    public String toString() {
        return getName() + "," + getSurname() + "," + getDateOfBirth() + "," + getContactNumber() + "," + getSpecialization() + "," + getLicenceNumber();
    }

    /**
     * This method is used to print all the doctors in the doctorArrayList
     * using the toString method in the Doctor class
     */
    public static void printDoctorList() {

        for (Doctor doctor : doctorArrayList) {
            System.out.println(doctor.toString());
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

    }

    // when delete a doctor from the system the doctorArrayList will be updated and need to update the doctorArrayList in the file

    public static void saveDoctorListToFileAfterDelete() {
        try {
            FileWriter fileWriter = new FileWriter("doctors.txt");
            Writer output = new BufferedWriter(fileWriter);

            //DELETE THE CONTENT OF THE FILE
            output.write("");

            // write the doctorArrayList to the file
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
            //DELETE THE CONTENT OF THE FILE
            output.write("");
            for (int i = 0; i < Doctor.doctorArrayList.size(); i++) {
                output.write(doctorArrayList.get(i).toString() + "\n");
            }
            output.flush();
            System.out.println("Doctor list saved to file");
            output.close();
        } catch (Exception e) { // if any missing file or any other error
            JOptionPane.showMessageDialog(null, "Error in saving this file");
        }
    }

    /**
     * this methode going to load the arrayList data from a file called doctors.txt
     */

    public static Date StringToDate(String inputStringDate) {
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
        //Parsing the given String to Date object
        Date date;
        try {
            date = formatter.parse(inputStringDate);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * this methode going to load the arrayList data from a file called doctors.txt
     */
    public static void loadDoctorListFromFile() {
        doctorArrayList.clear();
        try {
            FileReader fileReader = new FileReader("doctors.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            // ARRAY LIST OF DOCTORS SHOULD BE EMPTY

            while ((line = bufferedReader.readLine()) != null) {
                String[] doctorDetails = line.split(",");
                String name = doctorDetails[0];
                String surname = doctorDetails[1];
//                Date dateOfBirth = null;
                Date dateOfBirth = StringToDate(doctorDetails[2]);

                String contactNumber = doctorDetails[3];
                String specialization = doctorDetails[4];
                int licenceNumber = Integer.parseInt(doctorDetails[5]);
                Doctor doctor = new Doctor(name, surname, dateOfBirth, contactNumber, specialization, licenceNumber);
                doctorArrayList.add(doctor);
            }
            System.out.println("Doctors list loaded from file");
            bufferedReader.close();
        } catch (Exception e) { // LOOP NOT CRASHING IF FILE NOT FOUND
            JOptionPane.showMessageDialog(null, "Error in saving this file");
        }
    }
    /**
     * this methode going check if the doctor is already in the arrayList and return true if the doctor is already in the arrayList
     */

    public static boolean checkDoctorAlreadyInList(int licenceNumber) {
        for (Doctor doctor : doctorArrayList) {
            if (doctor.getLicenceNumber() == licenceNumber) {
                return true;
            }
        }
        return false;
    }

}

