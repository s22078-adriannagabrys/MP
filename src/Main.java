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

        //Abstract
        System.out.println("Abstract / polimorfizm --------------");
        Drug pom = new PrescribedOnlyMedicine("Aspirin", 12345, 5, 1, 15.50, 1234, "Don't drive");
        Drug supplement = new Supplement("Apetizer", 96766, 5, 16.00, 3, "Don't drive");
        System.out.println(pom.getData());
        System.out.println(supplement.getData());

        //Wielodziedziczenie
        System.out.println("Wielodziedziczenie --------------");
        PharmacyPet pharmacyPet = new PharmacyPet(1, Arrays.asList("Alex"), "Kot", LocalDate.of(2000, 11, 16), 28.00, LocalDate.of(2000, 11, 16), "Husky", "Blue", "Adam");
        pharmacyPet.givePaw();
        pharmacyPet.setDateOfTerminationOfEmployment(LocalDate.of(2006, 11, 16));
        System.out.println(pharmacyPet.isStillWorking());

        //Dynamic
        System.out.println("Dynamic------------------");
        CommunityPharmacyEmployee employee = new CommunityPharmacyEmployee(1, Arrays.asList("Alex"), "Kot", LocalDate.of(2000, 11, 16), 28.00, LocalDate.of(2000, 11, 16));
        employee.changeClassToManager("Master", true, 15);
        try {
            System.out.println(employee.getManager().isHas5YearsOfExperience());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(employee.getPharmacists().getDiplomaIndex());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        employee.changeClassToPharmacist("Master", 10, 1234);
        try {
            System.out.println(employee.getManager().isHas5YearsOfExperience());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(employee.getPharmacists().getDiplomaIndex());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Wieloaspektowe
        System.out.println("Wieloaspektowe--------------------");
        PrescribedOnlyMedicine drug1 = new PrescribedOnlyMedicine("Aspirin", 12345, 5, 1, 15.50, 1234, "Don't drive");
        PrescribedOnlyMedicine drug2 = new PrescribedOnlyMedicine("Ibuprofen", 154365, 5, 1, 2, 1234, "Don't drive");
        PrescribedOnlyMedicine drug3 = new PrescribedOnlyMedicine("Amoxicilin", 6587, 5, 1, 3, 1234, "Don't drive");
        Supplement drug4 = new Supplement("Apetizer", 96766, 5, 16.00, 3, "Don't drive");
        Supplement drug5 = new Supplement("Marsjanki", 4575, 5, 16.00, 3, "Don't drive");

        System.out.println("licence: " + drug1.getLicenceNumber());
        try {
            System.out.println("volume: " + drug1.getSellByVolume().getVolume());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("nr of pieces: " + drug1.getSellByPiece().getNumberOfPieces());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("leaflet: " + drug4.getLeaflet());
        try {
            System.out.println("volume: " + drug4.getSellByVolume().getVolume());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("nr of pieces: " + drug4.getSellByPiece().getNumberOfPieces());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        List<Drug> drugList = new ArrayList();
        drugList.add(drug1);
        drugList.add(drug2);
        drugList.add(drug3);
        drugList.add(drug4);
        drugList.add(drug5);

        List<String> labTools = new ArrayList();
        labTools.add("Spoon");
        labTools.add("Once");
        labTools.add("Beaker");

        //Overlapping

        System.out.println("Overlapping ------------------");
        Room room1 = new Room(1, 1, drugList);
        Room room2 = new Room(labTools, 2, 2);
        Room room3 = new Room(3, 3, drugList, labTools);

        try {
            System.out.println(room1.getDrugs());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(room1.getLabTools());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(room3.getDrugs());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(room3.getLabTools());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
