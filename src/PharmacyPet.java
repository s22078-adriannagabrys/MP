import java.time.LocalDate;
import java.util.List;

//wielodziedziczenie
interface IDog{
    public abstract void bark();
    public abstract void givePaw();
}

public class PharmacyPet extends CommunityPharmacyEmployee implements IDog{
    private String breed;
    private String colour;
    private String owner;

    public PharmacyPet(int id, List<String> names, String surName, LocalDate birthDate, double salaryPerHour, LocalDate dateOfEmployment, String breed, String colour, String owner) {
        super(id, names, surName, birthDate, salaryPerHour, dateOfEmployment);
        this.breed = breed;
        this.colour = colour;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return String.format("Pharmacy pet: %s %s");
    }

    @Override
    public void bark() {
        System.out.println("Hau!");
    }

    @Override
    public void givePaw() {
        System.out.println("Gives paw");
    }

    @Override
    public double calculateSalary() {
        return getSalaryPerHour() + 5;
    }
}
