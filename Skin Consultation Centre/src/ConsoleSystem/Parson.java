package ConsoleSystem;

public class Parson {
    private String name;
    private String surname;
    private String dateOfBirth;
    private String contactNumber;

    public Parson(String name, String surname, String DateOfBirth, String contactNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = DateOfBirth;
        this.contactNumber = contactNumber;

    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getDateOfBirth(){
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

    public void setDateOfBirth(String DateOfBirth){
        this.dateOfBirth = DateOfBirth;
    }

    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }







}

