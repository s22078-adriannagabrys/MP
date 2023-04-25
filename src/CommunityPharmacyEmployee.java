import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public int[] magazineIds;
    private List<Order> orders = new ArrayList<>();
    private List<Drug> drugs = new ArrayList<>();
    private List<Pharmacy> pharmacies = new ArrayList<>();

    //asocjacja z atrybutem pracownik-zamówienie
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

    public Order orderDrugs(int id, List<Drug> drugList, String warehouse, LocalDate date, LocalDate paymentDate, double price, int NIP){
        Order newOrder = new Order(id, warehouse, date, paymentDate, price, NIP);
        for(Drug newDrug : drugList){
            newOrder.addDrug(newDrug);
            newOrder.addEmployee(this);
        }
        return newOrder;
    }

}
