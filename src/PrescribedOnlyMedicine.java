public class PrescribedOnlyMedicine extends Drug{
    int licenceNumber;
    String theSummaryOfTheMedicinalProduct;

    public PrescribedOnlyMedicine(String drugName, int indexNumber, double weight, double priceBy1ml, double volume,
                                  int licenceNumber, String theSummaryOfTheMedicinalProduct) {
        super(drugName, indexNumber, weight, priceBy1ml, volume);
        this.licenceNumber = licenceNumber;
        this.theSummaryOfTheMedicinalProduct = theSummaryOfTheMedicinalProduct;
    }

    public PrescribedOnlyMedicine(String drugName, int indexNumber, double weight, double priceByPiece,
                                  int numberOfPieces,
                                  int licenceNumber, String theSummaryOfTheMedicinalProduct) {
        super(drugName, indexNumber, weight, priceByPiece, numberOfPieces);
        this.licenceNumber = licenceNumber;
        this.theSummaryOfTheMedicinalProduct = theSummaryOfTheMedicinalProduct;
    }

    public int getLicenceNumber() {
        return licenceNumber;
    }

    @Override
    public String getData() {
        return drugName + indexNumber + weight + licenceNumber + theSummaryOfTheMedicinalProduct;
    }
}
