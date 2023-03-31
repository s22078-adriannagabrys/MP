import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class CommunityPharmacyEmployee implements Serializable {
    //atrybuty obiektowe
    private ArrayList<String> names; //atrybut powtarzalny
    private String surName; //atrybut prosty, pojedynczy

    private LocalDate birthDate; //atrybut konkretny
    private double salaryPerHour;
    private LocalDate dateOfTerminationOfEmployment; //atrybut opcjonalny
    private LocalDate dateOfEmployment; //atrybut złożony

    //atrybuty klasowe
    private static boolean hasSecondaryEducation = true;
    private static int minAgeForEmployment = 18;

    public CommunityPharmacyEmployee() {
    }

    public CommunityPharmacyEmployee(ArrayList<String> names, String surName, LocalDate birthDate, double salaryPerHour, LocalDate dateOfEmployment) {
        this.names = names;
        this.surName = surName;
        this.birthDate = birthDate;
        this.salaryPerHour = salaryPerHour;
        this.dateOfEmployment = dateOfEmployment;
    }

    //metoda abstracyjna

    public abstract double calculateSalary();

    //metoda obiektowa

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    //przeładowanie metody
    public void setNames(String... names){
        ArrayList<String> newNames = new ArrayList<>();
        for(String arg : names){
            newNames.add(arg);
        }
        this.names = newNames;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public LocalDate getDateOfTerminationOfEmployment() {
        return dateOfTerminationOfEmployment;
    }

    public void setDateOfTerminationOfEmployment(LocalDate dateOfTerminationOfEmployment) {
        this.dateOfTerminationOfEmployment = dateOfTerminationOfEmployment;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    public static boolean isHasSecondaryEducation() {
        return hasSecondaryEducation;
    }

    public static void setHasSecondaryEducation(boolean hasSecondaryEducation) {
        CommunityPharmacyEmployee.hasSecondaryEducation = hasSecondaryEducation;
    }

    public static int getMinAgeForEmployment() {
        return minAgeForEmployment;
    }

    public static void setMinAgeForEmployment(int minAgeForEmployment) {
        CommunityPharmacyEmployee.minAgeForEmployment = minAgeForEmployment;
    }


}
