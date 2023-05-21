import java.util.ArrayList;
import java.util.List;

//overlapping
public class Room {
    private int number;
    Magazine magazine;
    private void addMagazine(int index, List<Drug> drugs){
        magazine = new Magazine(index, drugs);
    }
    private void removeMagazine(){
        magazine = null;
    }

    Lab lab;

    private void addLab(int index,List<String> labTools){
        lab = new Lab(index, labTools);
    }

    private void removeLab(){
        lab = null;
    }
    public Room(int number, int index, List<Drug> drugs){
        this.number = number;
        addMagazine(index, drugs);
    }
    public Room(List<String> labTools, int number, int index){
        this.number = number;
        addLab(index, labTools);
    }

    public Room(int number, int index, List<Drug> drugs, List<String> labTools){
        this.number = number;
        addLab(index, labTools);
        addMagazine(index, drugs);
    }
    public List getDrugs() throws Exception{
        try {
            return magazine.getDrugs();
        } catch (Exception ex){
            throw new Exception("It is not Magazine");
        }
    }
    public List getLabTools() throws Exception{
        try {
            return lab.getLabTools();
        } catch (Exception ex){
            throw new Exception("It is not Lab");
        }
    }

    public class Magazine {
        private List<Drug> drugs = new ArrayList<>();
        private int index;

        public Magazine(int index, List<Drug> drugs) {
            this.index = index;
            this.drugs = drugs;
        }


        public int getIndex() {
            return index;
        }

        public List<Drug> getDrugs() {
            return drugs;
        }


        @Override
        public String toString() {
            String info = "Magazine: " + index + "\n";

            for (Drug drug : drugs) {
                info += "   " + drug.getDrugName() + "\n";
            }

            return info;
        }
    }
    public class Lab{

        private List<String> labTools = new ArrayList();
        private int index;

        public Lab(int index,List<String> labTools) {
            this.labTools = labTools;
            this.index = index;
        }

        public List<String> getLabTools() {
            return labTools;
        }
        @Override
        public String toString() {
            String info = "Lab: " + index + "\n";

            for (String lab : labTools) {
                info += "   " + lab.toString() + "\n";
            }

            return info;
        }
    }
}