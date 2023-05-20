import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class CommunityPharmacyEmployee implements Serializable{
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

    public CommunityPharmacyEmployee(int id, List<String> names, String surName, LocalDate birthDate,
                                      double salaryPerHour, LocalDate dateOfEmployment) {
        this.id = id;
        this.names = names;
        this.surName = surName;
        this.birthDate = birthDate;
        this.salaryPerHour = salaryPerHour;
        this.dateOfEmployment = dateOfEmployment;
    }

    //metoda abstracyjna

    public double calculateSalary(){
        return salaryPerHour;
    }

    //metoda obiektowa

    public double getSalaryPerHour() {
        return salaryPerHour;
    }
    public LocalDate getDateOfTerminationOfEmployment() {
        return dateOfTerminationOfEmployment;
    }
    public String isStillWorking(){
        return getNames() + " " + getSurName() + " " + (getDateOfTerminationOfEmployment() == null ? "still working" : String.valueOf(getDateOfTerminationOfEmployment()));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        String allNames = " ";
        for(String name: names){
            allNames+= name + " ";
        }
        return allNames;
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
//    public Order orderDrug(int id, Drug newDrug, String warehouse, LocalDate date, LocalDate paymentDate, double price, int NIP){
//        Order newOrder = new Order(id, warehouse, date, paymentDate, price, NIP);
//        newOrder.addDrug(newDrug);
//        newDrug.addOrder(newOrder);
//        newOrder.addEmployee(this);
//        return newOrder;
//    }
//    public Drug getDrug() {
//        Drug newDrug = null;
//        for (Order order : orders){
//            newDrug = order.getDrug();
//        }
//        return newDrug;
//    }
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

    public String getSurName() {
        return surName;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    //dynamic
    Pharmacist pharmacists;
    public void removePharmacist(){
        pharmacists = null;
    }
    PharmacyManager manager;
    public void removeManager(){
        manager = null;
    }
    Technician technician;
    public void addTechnician(String title){
        technician = new Technician(title);
    }
    public void removeTechnician(){
        technician = null;
    }
    public void changeClassToManager(String title, boolean has5YearsOfExperience,int extraAmountOfDrugsSoldPerMonth){
        manager = new PharmacyManager(title, has5YearsOfExperience, extraAmountOfDrugsSoldPerMonth);
        removePharmacist();
    }
    public void changeClassToPharmacist(String title, int extraAmountOfDrugsSoldPerMonth, int diplomaIndex){
        pharmacists = new Pharmacist(title, extraAmountOfDrugsSoldPerMonth, diplomaIndex);
        removeManager();
    }

    public boolean has5YearsOfExperience() throws Exception{
        try {
            return manager.isHas5YearsOfExperience();
        } catch (Exception ex){
            throw new Exception("Is not an Manager");
        }
    }

    public int getDiplomaIndex() throws Exception{
        try{
            return pharmacists.getDiplomaIndex();
        } catch (Exception ex){
            throw new Exception("Is not a Pharmacist");
        }
    }
    public class Pharmacist{
        private double degreeBonus = 5.00;
        private String title;
        private int extraAmountOfDrugsSoldPerMonth;

        private int diplomaIndex;

        public Pharmacist(String title, int extraAmountOfDrugsSoldPerMonth, int diplomaIndex) {
            this.title = title;
            this.extraAmountOfDrugsSoldPerMonth = extraAmountOfDrugsSoldPerMonth;
            this.diplomaIndex = diplomaIndex;
        }
        public double calculateSalary() {
            return getSalaryPerHour() * degreeBonus + extraAmountOfDrugsSoldPerMonth;
        }

        public String getTitle() {
            return title;
        }

        public int getExtraAmountOfDrugsSoldPerMonth() {
            return extraAmountOfDrugsSoldPerMonth;
        }

        public int getDiplomaIndex() {
            return diplomaIndex;
        }
    }

    public class PharmacyManager{
        private double degreeBonus = 10.00;
        private String title;
        private boolean has5YearsOfExperience;
        private int extraAmountOfDrugsSoldPerMonth;

        public PharmacyManager(String title, boolean has5YearsOfExperience,
                               int extraAmountOfDrugsSoldPerMonth) {
            this.title = title;
            this.has5YearsOfExperience = has5YearsOfExperience;
            this.extraAmountOfDrugsSoldPerMonth = extraAmountOfDrugsSoldPerMonth;
        }
        public double calculateSalary() {
            return getSalaryPerHour() * degreeBonus + extraAmountOfDrugsSoldPerMonth;
        }

        public boolean isHas5YearsOfExperience() {
            return has5YearsOfExperience;
        }

        public int getExtraAmountOfDrugsSoldPerMonth() {
            return extraAmountOfDrugsSoldPerMonth;
        }
    }

    public class Technician{
        private String title;

        public Technician(String title) {
            this.title = title;
        }
        public double calculateSalary() {
            return getSalaryPerHour();
        }
    }
}
