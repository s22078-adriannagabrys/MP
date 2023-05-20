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

        Pharmacist pharmacist1 = new Pharmacist(1, names, "Kowalska", LocalDate.of(2000, 11, 16), 28.00, LocalDate.of(2019, 12, 1));
        Pharmacist pharmacist2 = new Pharmacist(2, new ArrayList<>(Arrays.asList("Alex", "Charles")), "Nowak", LocalDate.of(2000, 11, 16), 30.00, LocalDate.of(2019, 12, 1));
        Pharmacist pharmacist3 = new Pharmacist(3, new ArrayList<>(Arrays.asList("Wiktoria")),"Polak", LocalDate.of(2000, 11, 16), 28.00, LocalDate.of(2019, 12, 1));
        Pharmacist pharmacist4 = new Pharmacist();
        pharmacist4.setNames("Julia", "Karolina");
        pharmacist4.setSurName("Zawada");

//        Drug drug1 = new Drug("Aspirin", 12345, 5, 16.00);
//        Drug drug2 = new Drug("Ibuprofen", 30001, 5, 16.00);
//        Drug drug3 = new Drug("Paracetamol", 56723, 5, 16.00);
//        Drug drug4 = new Drug("Amoxicilin", 15243, 5, 16.00);

        List<Drug> drugList = new ArrayList();
//        drugList.add(drug1);
//        drugList.add(drug2);
//        drugList.add(drug3);
//        drugList.add(drug4);

        Magazine magazine1 = new Magazine(1);



    }
}
