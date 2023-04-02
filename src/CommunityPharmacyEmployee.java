import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CommunityPharmacyEmployee extends AssociationClass implements Serializable{
    private int id;
    public int[] magazineIds;
    //atrybuty obiektowe
    private List<String> names; //atrybut powtarzalny
    private String surName; //atrybut prosty, pojedynczy
    private LocalDate birthDate; //atrybut konkretny
    private double salaryPerHour;
    private LocalDate dateOfTerminationOfEmployment; //atrybut opcjonalny
    private LocalDate dateOfEmployment; //atrybut złożony

    private List<Order> orders = new ArrayList<>();

    //atrybuty klasowe
    private static boolean hasSecondaryEducation = true;
    private static int minAgeForEmployment = 18;


    public CommunityPharmacyEmployee() {

    }
    public CommunityPharmacyEmployee(List<String> names, String surName, LocalDate birthDate, double salaryPerHour, LocalDate dateOfEmployment) {
        this.names = names;
        this.surName = surName;
        this.birthDate = birthDate;
        this.salaryPerHour = salaryPerHour;
        this.dateOfEmployment = dateOfEmployment;
    }

    //metoda abstracyjna

    public abstract double calculateSalary();

    //metoda obiektowa

    public List<String> getNames() {
        return names;
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

    public void addOrder(Order newOrder) {
        if(!orders.contains(newOrder)) {
            orders.add(newOrder);
            newOrder.addEmployee(this);
        }
    }

    public void removeOrder(Order toRemove) {
        if(orders.contains(toRemove)) {
            orders.remove(toRemove);
            toRemove.removeEmployee(this);
        }
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

    public LocalDate getDateOfTerminationOfEmployment() {
        return dateOfTerminationOfEmployment;
    }

    public void setDateOfTerminationOfEmployment(LocalDate dateOfTerminationOfEmployment) {
        this.dateOfTerminationOfEmployment = dateOfTerminationOfEmployment;
    }

    public String isStillWorking(){
        return getNames() + " " + getSurName() + " " + (getDateOfTerminationOfEmployment() == null ? "still working" : String.valueOf(getDateOfTerminationOfEmployment()));
    }

}
