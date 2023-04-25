import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Pharmacy pharmacy1 = new Pharmacy(1, "Medea");
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Ewa");
        File file = new File("C:\\Users\\s22078\\Desktop\\MAS1\\MP_01.txt");
//        File file = new File("G:\\Adrianna\\Pulpit\\MAS\\MAS.txt.txt");

        Pharmacist pharmacist1 = new Pharmacist(1, names, "Kowalska", LocalDate.of(2000, 11, 16), 28.00, LocalDate.of(2019, 12, 1));
        Pharmacist pharmacist2 = new Pharmacist(2, new ArrayList<>(Arrays.asList("Alex", "Charles")), "Nowak", LocalDate.of(2000, 11, 16), 30.00, LocalDate.of(2019, 12, 1));
        Pharmacist pharmacist3 = new Pharmacist(3, new ArrayList<>(Arrays.asList("Wiktoria")),"Polak", LocalDate.of(2000, 11, 16), 28.00, LocalDate.of(2019, 12, 1));
        Pharmacist pharmacist4 = new Pharmacist();
        pharmacist4.setNames("Julia", "Karolina");
        pharmacist4.setSurName("Zawada");

//        System.out.println("Pharmacist: " + pharmacist1 + ": " + pharmacist1.isStillWorking());

        Drug drug1 = new Drug("Aspirin", 12345, 5, 16.00);
        Drug drug2 = new Drug("Ibuprofen", 30001, 5, 16.00);
        Drug drug3 = new Drug("Paracetamol", 56723, 5, 16.00);
        Drug drug4 = new Drug("Amoxicilin", 15243, 5, 16.00);

        List<Drug> drugList = new ArrayList();
        drugList.add(drug1);
        drugList.add(drug2);
        drugList.add(drug3);
        drugList.add(drug4);

        Magazine magazine1 = new Magazine(1);


//        try {
//            var out = new ObjectOutputStream(new FileOutputStream(file));
//            Pharmacist.writeExtent(out);
//            out.close();
//
//            var in = new ObjectInputStream(new FileInputStream(file));
//            Pharmacist.readExtent(in);
//            in.close();
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Pharmacist.showExtent();;

        //asocjacja zwykła

        System.out.println("Asocjacja zwykła Magazine-Drug");
        magazine1.addDrug(drug1);
        magazine1.addDrug(drug2);
        magazine1.addDrug(drug3);
        magazine1.addDrug(drug4);
        System.out.println(magazine1);

        magazine1.removeDrug(drug1);
        System.out.println(magazine1);

        //asocjacja kwalifikowana

        System.out.println("Asocjacja kwalifikowana CommunityPharmacyEmployee-Pharmacy (kwalifikator id)");
        pharmacy1.addEmployeeQualif(pharmacist1);
        pharmacy1.addEmployeeQualif(pharmacist2);
        pharmacy1.addEmployeeQualif(pharmacist3);
        System.out.println(pharmacy1);

        pharmacy1.removeEmployee(pharmacist1);
        System.out.println(pharmacy1);

        //asocjacja z atrybutem

        System.out.println("Asocjacja z atrybutem CommunityPharmacyEmployee-Order-Drug");
        Order order1 = pharmacist1.orderDrugs(1, drugList, "Adamed", LocalDate.of(2023, 11, 16), LocalDate.of(2023, 11, 16), 100, 678987221);
        Order order2 = pharmacist2.orderDrugs(2, drugList, "Hasco", LocalDate.of(2023, 11, 16), LocalDate.of(2023, 11, 16), 100, 678987221);
        System.out.println(order1);
        System.out.println(order2);

        //kompozycja

        System.out.println("Kompozycja Order-Dokument");
        order1.createDocument(1, Order.DocumentType.INVOICE);
        order1.createDocument(2, Order.DocumentType.PAYMENTCONFIRMATION);
        order2.createDocument(1, Order.DocumentType.INVOICE);
        System.out.println(order1);
        System.out.println(order2);
    }
}
