import java.util.ArrayList;
import java.util.List;

public class Magazine {
    private List<Drug> drugs = new ArrayList<>();
    private int index;

    public Magazine(int index) {
        this.index = index;
    }

    //asocjacja zwykła
    public void addDrug(Drug newDrug) {
        if(!drugs.contains(newDrug)) {
            drugs.add(newDrug);
            newDrug.addMagazine(this);
        }
    }

    public void removeDrug(Drug toRemove) {
        if(drugs.contains(toRemove)) {
            drugs.remove(toRemove);
            toRemove.removeMagazine(this);
        }
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
