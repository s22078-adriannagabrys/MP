import java.io.Serializable;
import java.time.LocalDate;

//polimorfizm
public class PharmacyManager extends CommunityPharmacyEmployee implements Serializable {
    private double degreeBonus = 10.00;
    private LocalDate additionDate;
    private String title;
    private Integer extraAmountOfDrugsSoldPerMonth;


    @Override
    public double calculateSalary() {
        return getSalaryPerHour() * degreeBonus + extraAmountOfDrugsSoldPerMonth;
    }
}
