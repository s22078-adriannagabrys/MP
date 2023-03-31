import javax.naming.event.ObjectChangeListener;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pharmacist extends CommunityPharmacyEmployee{
    private double degreeBonus = 5.00;
    private LocalDate additionDate;
    private String title;
    private ArrayList<Drug> drug;
    private int extraAmountOfDrugsSoldPerMonth;

    public Pharmacist(ArrayList<String> names, String surName, LocalDate birthDate, double salaryPerHour, LocalDate dateOfEmployment) {
        super(names, surName, birthDate, salaryPerHour, dateOfEmployment);
        addPharmacist(this);
    }
    public Pharmacist() {
        super();
//        addPharmacist(this);
    }
    //przesłonięcie metody
    @Override
    public double calculateSalary() {
        return getSalaryPerHour() * degreeBonus + extraAmountOfDrugsSoldPerMonth;
    }

    @Override
    public String toString() {
        return "Pharmacist: " + "names: " + getNames() + " surname: " + getSurName();
    }

    //ekstensja
    private static List<Pharmacist> extent = new ArrayList<>();

    //metoda klasowa
    //Ekstensja
    private static void addPharmacist(Pharmacist pharmacist) {
        extent.add(pharmacist);
    }

    private static void removePharmacist(Pharmacist pharmacist) {
        extent.remove(pharmacist);
    }

    public static void showExtent() {

        System.out.println("Extent of the class: " + Pharmacist.class.getName());

        for (Pharmacist pharmacist : extent) {
            System.out.println(pharmacist);
        }
    }

    //trwałość ekstensji

    public static void writeExtent(ObjectOutputStream stream) throws IOException{
        stream.writeObject(extent);
        stream.flush();
        stream.close();
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Pharmacist>) stream.readObject();
    }



    //ewentualnie zrobić dynamiczny przykład klasy ze farmaceuta stanie sie kierownikiem

}
