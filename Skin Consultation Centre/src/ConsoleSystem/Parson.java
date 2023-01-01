package ConsoleSystem;

import javax.swing.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public  class  Parson {
    private  String name;
    private String surname;

    Date dateOfBirth = new Date();


//    SimpleDateFormat formatterOfDate = new SimpleDateFormat("dd/MM/yyyy");\
//    String date = formatterOfDate.format(dateOfBirth);



    private  String contactNumber;

    public Parson(String name, String surname, Date DateOfBirth, String contactNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = DateOfBirth;
        this.contactNumber = contactNumber;

    }

    public  String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public  Date getDateOfBirth(){
        return dateOfBirth;
    }



    public String getContactNumber(){
        return contactNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setDateOfBirth(Date DateOfBirth){
        this.dateOfBirth = DateOfBirth;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }


}

