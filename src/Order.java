import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String warehouse;
    private LocalDate dateOfOrder;
    private double price;
    private int NIP;
    private List<Drug> drugs = new ArrayList<>();
    private List<CommunityPharmacyEmployee> communityPharmacyEmployees;
    private List<Document> dokuments;

    public Order(int id, String warehouse, LocalDate dateOfOrder, double price, int NIP) {
        this.id = id;
        this.warehouse = warehouse;
        this.dateOfOrder = dateOfOrder;
        this.price = price;
        this.NIP = NIP;
    }

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

    public void createDocument(int id){
        this.addDocument(new Document(id));
    }
    public void addDocument(Document newDocument) {
        if(!dokuments.contains(newDocument)) {
            dokuments.add(newDocument);
        }
    }

    @Override
    public String toString() {
        var info = "Order: " + id + "\n";

        for(Drug drug : drugs) {
            info += "   " +  drug.getDrugName() + "\n";
        }

        return info;
    }

    //faktura zamówienia
    public class Document {
        private int id;

        public Document(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Invoice{" +
                    "id=" + id + " Sender: " + warehouse + " Date of order: " + dateOfOrder + " Price: " + price +
                    '}';
        }
    }
}
