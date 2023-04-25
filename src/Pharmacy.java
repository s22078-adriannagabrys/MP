import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Pharmacy {
    private int id;
    private String name;
    private Map<Integer, CommunityPharmacyEmployee> employeesQualif = new TreeMap<>();

    public Pharmacy(int id, String name) {
        this.id = id;
        this.name = name;
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

    //asocjacja kwalifikowana
    //dodanie pracownika do asocjacji
    public void addEmployeeQualif(CommunityPharmacyEmployee newEmployee) {
        // Check if we already have the info
        if(!employeesQualif.containsKey(newEmployee.getId())) {
            employeesQualif.put(newEmployee.getId(), newEmployee);

            // Add the reverse connection
            newEmployee.addPharmacy(this);
        }
    }
    //wypisanie połączeń
    public CommunityPharmacyEmployee findEmployeeQualif(int employeeId){
        try{
            if(!employeesQualif.containsKey(employeeId)) {
                throw new Exception("Unable to find a employee: " + employeeId);
            }

            return employeesQualif.get(employeeId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //usunięcie pracownika z asocjacji
    public void removeEmployee(CommunityPharmacyEmployee toRemove) {
        if(employeesQualif.containsKey(toRemove.getId())) {
            employeesQualif.remove(toRemove.getId());
            toRemove.removePharmacy(this);
        }
    }

    @Override
    public String toString() {
        return "Pharmacy: " + name + "\n" + "Employees: " + "\n" + employeesQualif + "\n";
    }
}
