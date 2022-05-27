package characters;

public class Demon {

    private String name;
    private int affection;
    // private Dialogue dialogue;

    public Demon(String name) {
        this.name = name;
        affection = 0;
    }

    public String getName() {
        return name;
    }

    public int getAffection() {
        return affection;
    }

    public void changeAffection(int a) { //Base mutator
        affection += a;
    }
}