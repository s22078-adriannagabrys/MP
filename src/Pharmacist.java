import javax.naming.event.ObjectChangeListener;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//polimorfizm
public class Pharmacist extends CommunityPharmacyEmployee implements Serializable{

    private double degreeBonus = 5.00;
    private LocalDate additionDate;
    private String title;
    private Integer extraAmountOfDrugsSoldPerMonth;

    public Pharmacist(int id, List<String> names, String surName, LocalDate birthDate, double salaryPerHour, LocalDate dateOfEmployment) {
        super(id, names, surName, birthDate, salaryPerHour, dateOfEmployment);
    }
    public Pharmacist() {
        super();
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



    //ewentualnie zrobić dynamiczny przykład klasy ze farmaceuta stanie sie kierownikiem

}
