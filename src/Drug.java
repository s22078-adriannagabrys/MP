import java.util.*;

//Overlapping
enum DrugType {
    DRUG("Drug"), OTC("OTC"), SUPPLEMENT("Supplement"), POM("Prescribed only medicine"), ANTIPSYCHOTIC("Antipsychotic"), MEDICALDEVICE("Medical device");
    public String label;
    private DrugType(String label){
        this.label = label;
    }
    public String getLabel(){
        return label;
    }
}

public abstract class Drug {
    private String drugName;
    private int indexNumber;
    private double weight;
    private double price;

    private EnumSet<DrugType> drug =  EnumSet.of(DrugType.DRUG);

    public Drug(String drugName, int indexNumber, double weight, double price) {
        this.drugName = drugName;
        this.indexNumber = indexNumber;
        this.weight = weight;
        this.price = price;
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

        return info;
    }

    //wieloaspektowość

    public class WayOfSelling{

    }

    public class SellByPiece extends WayOfSelling {
    }

    public class SellInBlister extends WayOfSelling {
    }

    public class SellInPackage extends WayOfSelling {
    }


}
