import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

//klasa abstrakcyjna
public abstract class CommunityPharmacyEmployee implements Serializable{
    //atrybuty obiektowe
    private int id;
    private List<String> names; //atrybut powtarzalny
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
    public CommunityPharmacyEmployee(int id, List<String> names, String surName, LocalDate birthDate, double salaryPerHour, LocalDate dateOfEmployment) {
        this.id = id;
        this.names = names;
        this.surName = surName;
        this.birthDate = birthDate;
        this.salaryPerHour = salaryPerHour;
        this.dateOfEmployment = dateOfEmployment;
    }

    //metoda abstracyjna

    public abstract double calculateSalary();

    //metoda obiektowa

    public String getNames() {
        String allNames = " ";
        for(String name: names){
            allNames+= name + " ";
        }
        return allNames;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    //przeładowanie metody
    public void setNames(String... names){
        List<String> newNames = new ArrayList<>();
        for(String arg : names){
            newNames.add(arg);
        }
        this.names = newNames;
    }
    //kwalifikator

    public int getId() {
        return id;
    }
    private List<Order> orders = new ArrayList<>();
//    private List<Drug> drugs = new ArrayList<>();
    private List<Pharmacy> pharmacies = new ArrayList<>();


    public List<Order> getOrders() {
        return orders;
    }

    //asocjacja kwalifikowana pracownik-apteka
    public void addPharmacy(Pharmacy newPharmacy) {
        if(!pharmacies.contains(newPharmacy)) {
            pharmacies.add(newPharmacy);
            newPharmacy.addEmployeeQualif(this);
        }
    }
    public void removePharmacy(Pharmacy toRemove) {
        if(pharmacies.contains(toRemove)) {
            pharmacies.remove(toRemove);
            toRemove.removeEmployee(this);
        }
    }

    public List<Pharmacy> getPharmacies() {
        return pharmacies;
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
    public static void setHasSecondaryEducation(boolean hasSecondaryEducation) {
        CommunityPharmacyEmployee.hasSecondaryEducation = hasSecondaryEducation;
    }
    public static void setMinAgeForEmployment(int minAgeForEmployment) {
        CommunityPharmacyEmployee.minAgeForEmployment = minAgeForEmployment;
    }
    public LocalDate getDateOfTerminationOfEmployment() {
        return dateOfTerminationOfEmployment;
    }
    public String isStillWorking(){
        return getNames() + " " + getSurName() + " " + (getDateOfTerminationOfEmployment() == null ? "still working" : String.valueOf(getDateOfTerminationOfEmployment()));
    }

}
