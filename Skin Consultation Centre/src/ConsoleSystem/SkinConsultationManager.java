package ConsoleSystem;

public interface SkinConsultationManager {
 /*
    * This interface is used to manage the westminster center skin consultation
  */
    //
    public void consoleMenu(); // console menu
    public void consoleCommandSwitch(String consoleCommand); // switch the console command
    public void deleteConsultation(); // delete consultation
    public void addConsultation(); // add consultation
    public void addDoctor(); // add doctor
    public void findDoctor(); // find doctor
    public void addPatient(); // add patient
    public void addSessionByManager(); // add session by manager


}
