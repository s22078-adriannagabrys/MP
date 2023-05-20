public class Supplement extends Drug{
    String leaflet;

    public Supplement(String drugName, int indexNumber, double weight, double priceBy1ml, double volume,
                      String leaflet) {
        super(drugName, indexNumber, weight, priceBy1ml, volume);
        this.leaflet = leaflet;
    }

    public Supplement(String drugName, int indexNumber, double weight, double priceByPiece, int numberOfPieces,
                      String leaflet) {
        super(drugName, indexNumber, weight, priceByPiece, numberOfPieces);
        this.leaflet = leaflet;
    }

    public String getLeaflet() {
        return leaflet;
    }

    @Override
    public String getData() {
        return drugName + indexNumber + weight + leaflet;
    }
}
