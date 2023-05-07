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

    public List<Order> getOrders() {
        return orders;
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
            toRemove.removeDrug();
        }
    }
    public CommunityPharmacyEmployee getEmployee() {
        CommunityPharmacyEmployee newEmployee = null;
        for (Order order : orders){
            newEmployee = order.getCommunityPharmacyEmployee();
        }
        return newEmployee;
    }
    public String getDrugName() {
        return drugName;
    }

    public int getIndexNumber() {
        return indexNumber;
    }


    @Override
    public String toString() {
        var info = "Drug: " + drugName ;

//        for(Magazine magazine : magazines) {
//            info += "  Magazine: " +  magazine.getIndex() + "\n";
//        }

        return info;
    }

    //kategoria po ilości - wieloaspektowe

}
