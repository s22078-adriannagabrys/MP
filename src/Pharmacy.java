import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pharmacy {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Ewa");
        File file2 = new File("C:\\Users\\s22078\\Desktop\\MAS1\\MP_01.txt");
        File file = new File("G:\\Adrianna\\Pulpit\\MAS\\MAS.txt.txt");

        Pharmacist pharmacist1 = new Pharmacist(names, "Kowalska", LocalDate.of(2000,11,16), 28.00, LocalDate.of(2019,12,1));
        Pharmacist pharmacist2 = new Pharmacist(names, "Nowak", LocalDate.of(2000,11,16), 30.00, LocalDate.of(2019,12,1));
        Pharmacist pharmacist3 = new Pharmacist(names, "Polak", LocalDate.of(2000,11,16), 28.00, LocalDate.of(2019,12,1));
        Pharmacist pharmacist4 = new Pharmacist();
        pharmacist4.setNames("Julia", "Karolina");
        pharmacist4.setSurName("Zawada");

        System.out.println("Pharmacist: " + pharmacist1 + ": " + pharmacist1.isStillWorking());

        Drug drug1 = new Drug("Aspirin", 12345, 5, 16.00);
        Drug drug2 = new Drug("Ibuprofen", 12345, 5, 16.00);
        Drug drug3 = new Drug("Paracetamol", 12345, 5, 16.00);
        Drug drug4 = new Drug("Amoxicilin", 12345, 5, 16.00);

        List<Drug> drugList = new ArrayList();
        drugList.add(drug1);
        drugList.add(drug2);
        drugList.add(drug3);
        drugList.add(drug4);

        System.out.println("Sorted list of drugs: " + sortDrugList(drugList));
        try {
            // Write the extent to the given stream
            var out = new ObjectOutputStream(new FileOutputStream(file));
            Pharmacist.writeExtent(out);
            out.close();

            // Read the extent from the given stream
            var in = new ObjectInputStream(new FileInputStream(file));
            Pharmacist.readExtent(in);
            in.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Pharmacist.showExtent();
    }

    //metoda klasowa

    public static List<Drug> sortDrugList(List<Drug> list) {
        Drug temp;
        boolean sorted = false;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getDrugName().compareTo(list.get(i + 1).getDrugName()) > 0) {
                    temp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return list;
    }

}
