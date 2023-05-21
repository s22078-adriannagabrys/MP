public class Elephant extends Animal{
    private String trunk;
    boolean isRideable;

    public Elephant(int index, String name, double weight, boolean isRideable) {
        super(index, name, weight);
        this.trunk = "trunk";
        this.isRideable = isRideable;
    }

    @Override
    public void giveVoice() {
        System.out.print("Tuuuuuuuu!!!!");
    }
}
