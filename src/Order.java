import java.time.LocalDate;
import java.util.List;

public class Order {
    private int index;
    private String warehouse;
    private LocalDate dateOfOrder;
    private List<Drug> drugs;
    private List<CommunityPharmacyEmployee> communityPharmacyEmployees;

    //asocjacja z atrybutem (Order jest klasą asocjacyjną)
    public void addDrug(Drug newDrug) {
        if(!drugs.contains(newDrug)) {
            drugs.add(newDrug);
            newDrug.addOrder(this);
        }
    }
    public void removeDrug(Drug toRemove) {
        if(drugs.contains(toRemove)) {
            drugs.remove(toRemove);
            toRemove.removeOrder(this);
        }
    }
    public void addEmployee(CommunityPharmacyEmployee newEmployee) {
        if(!communityPharmacyEmployees.contains(newEmployee)) {
            communityPharmacyEmployees.add(newEmployee);
            newEmployee.addOrder(this);
        }
    }
    public void removeEmployee(CommunityPharmacyEmployee toRemove) {
        if(communityPharmacyEmployees.contains(toRemove)) {
            communityPharmacyEmployees.remove(toRemove);
            toRemove.removeOrder(this);
        }
    }
    //faktura zamówienia

    @Override
    public String toString() {
        var info = "Order: " + index + "\n";

        for(Drug drug : drugs) {
            info += "   " +  drug.getDrugName() + "\n";
        }

        return info;
    }
}
