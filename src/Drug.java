import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Override
    public String toString() {
        var info = "Drug: " + drugName + "\n";

        for(Magazine magazine : magazines) {
            info += "   " +  magazine.getIndex() + "\n";
        }

        return info;
    }
}
