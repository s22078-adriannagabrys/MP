public class Cat extends Animal{
    private String whiskers;
    private String claw;

    public Cat(int index, String name, double weight) {
        super(index, name, weight);
        this.whiskers = "whiskers";
        this.claw = "claw";
    }

    @Override
    public void giveVoice() {
        System.out.println("Miauuuu!!");
    }
}
