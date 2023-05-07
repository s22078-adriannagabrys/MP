import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

//polimorfizm
public class PharmacyManager extends CommunityPharmacyEmployee implements Serializable {
    private double degreeBonus = 10.00;
    private LocalDate additionDate;
    private String title;
    private boolean has5YearsOfExperience;
    private Integer extraAmountOfDrugsSoldPerMonth;

    public PharmacyManager(int id, List<String> names, String surName, LocalDate birthDate, double salaryPerHour, LocalDate dateOfEmployment) {
        super(id, names, surName, birthDate, salaryPerHour, dateOfEmployment);
    }

    public PharmacyManager(CommunityPharmacyEmployee prevPerson, boolean has5YearsOfExperience, double salaryPerHour){
        super(id, names, surName, birthDate, dateOfEmployment)
    }

    @Override
    public double calculateSalary() {
        return getSalaryPerHour() * degreeBonus + extraAmountOfDrugsSoldPerMonth;
    }
}
