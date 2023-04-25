import java.io.Serializable;

public class Technician extends CommunityPharmacyEmployee implements Serializable {
    @Override
    public double calculateSalary() {
        return getSalaryPerHour();
    }
}
