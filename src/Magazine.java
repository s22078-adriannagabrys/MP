import java.util.ArrayList;
import java.util.List;

public class Magazine {
    private List<Drug> drugs = new ArrayList<>();
    private int index;

    public Magazine(int index) {
        this.index = index;
    }


    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        var info = "Magazine: " + index + "\n";

        for(Drug drug : drugs) {
            info += "   " +  drug.getDrugName() + "\n";
        }

        return info;
    }
}
