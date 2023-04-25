import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String warehouse;
    private LocalDate dateOfOrder;
    private LocalDate dateOfPayment;
    private double price;
    private int NIP;
    private List<Drug> drugs = new ArrayList<>();
    private List<CommunityPharmacyEmployee> communityPharmacyEmployees = new ArrayList<>();
    private List<Document> documents = new ArrayList<>();

    public Order(int id, String warehouse, LocalDate dateOfOrder, LocalDate dateOfPayment, double price, int NIP) {
        this.id = id;
        this.warehouse = warehouse;
        this.dateOfOrder = dateOfOrder;
        this.dateOfPayment = dateOfPayment;
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

    public void createDocument(int id, DocumentType documentType){
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

        for(CommunityPharmacyEmployee communityPharmacyEmployee : communityPharmacyEmployees) {
            info += "   Order by: " + communityPharmacyEmployee.getId() + "\n";
        }

        for(Drug drug : drugs) {
            info += "   Drug: " + drug.getIndexNumber() + " - " +  drug.getDrugName() + "\n";
        }

        for(Document document : documents) {
            documentsInfo += "   Document: " + document.id + " - " +  document + "\n";
        }

        return documents.isEmpty() ? info : info + documentsInfo;
    }
    public enum DocumentType {
        INVOICE("Invoice"),
        PAYMENTCONFIRMATION("Payment confirmation");
        public String label;
        private DocumentType(String label){
            this.label = label;
        }
        public String getLabel(){
            return label;
        }

    }
    public class Document {

        private final DocumentType documentType;
        private int id;
        private String name;
        private String body;

        public Document(int id, DocumentType documentType) {
            this.id = id;
            this.documentType = documentType;
        }

        @Override
        public String toString() {
            String info = "Document " + id + " ";
            switch (documentType){
                case INVOICE:
                    return info += documentType.getLabel() + " Ordered by:" + communityPharmacyEmployees.toString() + " Sender: " + warehouse + " Date of order: " + dateOfOrder + " Price: " + price;
                case PAYMENTCONFIRMATION:
                    return info += documentType.getLabel() + " Date of payment: " + dateOfPayment + " Price: " + price;
                default:
                    throw new IllegalStateException("Unexpected value: " + documentType);
            }
        }
    }
}
