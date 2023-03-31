import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Drug {
    private String drugName;
    private int indexNumber;
    private double weight;
    private double price;

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
        return "{ " + "drugName='" + drugName + '\'' +
                ", indexNumber=" + indexNumber +
                ", weight=" + weight +
                ", price=" + price + " }";
    }
}
