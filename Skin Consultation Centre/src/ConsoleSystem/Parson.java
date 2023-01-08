package ConsoleSystem;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parson {
    private String name; // name of the person
    private String surname; // surname of the person
    Date dateOfBirth; // date of birth of the person
    private String contactNumber; // contact number of the person

    // constructor for the person
    public Parson(String name, String surname, Date DateOfBirth, String contactNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = DateOfBirth;
        this.contactNumber = contactNumber;

    }

    // getter and setter for the person
    // getters
    // get the name of the person
    public String getName() {
        return name;
    }

    // get the surname of the person
    public String getSurname() {
        return surname;
    }

    // get the date of birth of the person
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    // get the contact number of the person
    public String getContactNumber() {
        return contactNumber;
    }

    // setters
// set the name of the person
    public void setName(String name) {
        this.name = name;
    }

    // set the surname of the person
    public void setSurname(String surname) {
        this.surname = surname;
    }

    // set the date of birth of the person
    public void setDateOfBirth(Date DateOfBirth) {
        this.dateOfBirth = DateOfBirth;
    }

    // set the contact number of the person
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


}

