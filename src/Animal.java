public abstract class Animal {
    private int index;
    private String name;
    private double weight;

    public Animal(int index, String name, double weight) {
        this.index = index;
        this.name = name;
        this.weight = weight;
    }

    public abstract void giveVoice();
}
