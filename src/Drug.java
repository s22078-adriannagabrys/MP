//wieloaspektowe/ polimorfizm

public abstract class Drug {
    protected String drugName;
    protected int indexNumber;
    protected double weight;

    private Drug(String drugName, int indexNumber, double weight) {
        this.drugName = drugName;
        this.indexNumber = indexNumber;
        this.weight = weight;
    }
    SellByVolume sellByVolume;
    SellByPiece sellByPiece;
    public Drug(String drugName, int indexNumber, double weight, double priceBy1ml, double volume){
        this(drugName, indexNumber, weight);
        sellByVolume = new SellByVolume(priceBy1ml,volume);
    }

    public Drug(String drugName, int indexNumber, double weight, double priceByPiece, int numberOfPieces){
        this(drugName, indexNumber, weight);
        sellByPiece = new SellByPiece(priceByPiece, numberOfPieces);
    }
    public String getDrugName() {
        return drugName;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public abstract String getData();

    @Override
    public String toString() {
        String info = "Drug: " + drugName + "\n";

        return info;
    }

    public SellByVolume getSellByVolume() throws Exception{
        if(sellByVolume != null){
            return sellByVolume;
        } else throw new Exception("Is not sell by volume");
    }

    public SellByPiece getSellByPiece() throws Exception{
        if(sellByPiece != null){
            return sellByPiece;
        } else throw new Exception("Is not sell by piece");
    }

    //wieloaspektowość

    public class SellByVolume{
        double priceBy1ml;
        double volume;

        public SellByVolume(double priceBy1ml, double volume) {
            this.priceBy1ml = priceBy1ml;
            this.volume = volume;
        }

        public double getVolume() {
            return volume;
        }
    }

    public class SellByPiece{
        double priceByPiece;
        int numberOfPieces;

        public SellByPiece(double priceByPiece, int amountLeft) {
            this.priceByPiece = priceByPiece;
            this.numberOfPieces = amountLeft;
        }

        public int getNumberOfPieces() {
            return numberOfPieces;
        }
    }



}
