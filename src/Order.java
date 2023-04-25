import javax.print.Doc;
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
    private List<CommunityPharmacyEmployee> communityPharmacyEmployees = new ArrayList<>();
    private List<Document> documents = new ArrayList<>();

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

    public void createDocument(int id, Document.DocumentType documentType){
        this.addDocument(new Document(id, documentType));
    }
    public void addDocument(Document newDocument) {
        if(!documents.contains(newDocument)) {
            documents.add(newDocument);
        }
    }

    @Override
    public String toString() {
        var info = "Order: " + id + "\n";
        var documentsInfo = " ";

        for(Drug drug : drugs) {
            info += "   Drug: " + drug.getIndexNumber() + " - " +  drug.getDrugName() + "\n";
        }

        for(Document document : documents) {
            documentsInfo += "   Document: " + document.id + " - " +  document + "\n";
        }

        return documents.isEmpty() ? info : info + documentsInfo;
    }

    public class Document {
        private int id;
        private String name;
        private String body;
        public enum DocumentType {
            INVOICE,
            PAYMENTCONFIRMATION
        }

        public Document(int id, DocumentType documentType) {
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
