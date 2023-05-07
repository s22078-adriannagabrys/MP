import java.util.*;

//Overlapping
enum DrugType {
    DRUG("Drug"), OTC("OTC"), SUPPLEMENT("Supplement"), POM("Prescribed only medicine"), ANTIPSYCHOTIC("Antipsychotic"), MEDICALDEVICE("Medical device");
    public String label;
    private DrugType(String label){
        this.label = label;
    }
    public String getLabel(){
        return label;
    }
}

public class Drug {
    private String drugName;
    private int indexNumber;
    private double weight;
    private double price;

    private EnumSet<DrugType> drug =  EnumSet.of(DrugType.DRUG);
    private List<Magazine> magazines = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public Drug(String drugName, int indexNumber, double weight, double price) {
        this.drugName = drugName;
        this.indexNumber = indexNumber;
        this.weight = weight;
        this.price = price;
    }

    //asocjacja zwykła
    public void addMagazine(Magazine newMagazine) {
        if(!magazines.contains(newMagazine)) {
            magazines.add(newMagazine);
            newMagazine.addDrug(this);
        }
    }
    public void removeMagazine(Magazine toRemove) {
        if(magazines.contains(toRemove)) {
            magazines.remove(toRemove);
            toRemove.removeDrug(this);
        }
    }

    public List<Magazine> getMagazines() {
        return magazines;
    }

    //asocjacja z atrybutem
    public void addOrder(Order newOrder) {
        if(!orders.contains(newOrder)) {
            orders.add(newOrder);
            newOrder.addDrug(this);
        }
    }

    public void removeOrder(Order toRemove) {
        if(orders.contains(toRemove)) {
            orders.remove(toRemove);
            toRemove.removeDrug(this);
        }
    }

    public String getDrugName() {
        return drugName;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public List<CommunityPharmacyEmployee> getEmployees() {
        Set<CommunityPharmacyEmployee> employeeSet = new HashSet<>();
        for (Order order : orders){
            employeeSet.addAll(order.getCommunityPharmacyEmployees());
        }
        return new ArrayList<>(employeeSet);
    }

    @Override
    public String toString() {
        var info = "Drug: " + drugName + "\n";

        for(Magazine magazine : magazines) {
            info += "   " +  magazine.getIndex() + "\n";
        }

        return info;
    }

    //kategoria po ilości - wieloaspektowe

}
