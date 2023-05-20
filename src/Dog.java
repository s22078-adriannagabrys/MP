public class Dog implements IDog{
    private String breed;
    private String colour;
    private String owner;

    @Override
    public void bark() {
        System.out.println("Hau!");
    }

    @Override
    public void givePaw() {
        System.out.println("Gives paw");
    }


}
