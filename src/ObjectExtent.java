import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ObjectExtent implements Serializable {
    public ObjectExtent() {
        addEmployee(this);
    }

    //ekstensja
    private static List<ObjectExtent> extent = new ArrayList<>();

    //metoda klasowa
    //Ekstensja
    public static void addEmployee(ObjectExtent communityPharmacyEmployee) {
        extent.add(communityPharmacyEmployee);
    }

    private static void removePharmacist(ObjectExtent communityPharmacyEmployee) {
        extent.remove(communityPharmacyEmployee);
    }

    public static void showExtent() {

        System.out.println("Extent of the class: " + ObjectExtent.class.getName());

        for (ObjectExtent communityPharmacyEmployee : extent) {
            System.out.println(communityPharmacyEmployee);
        }
    }

    //trwałość ekstensji

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
        stream.flush();
        stream.close();
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (List<ObjectExtent>) stream.readObject();
    }
}
