package characters;

public class Demon {

    private String name;
    private int affection;
    private String roomImage;
    // private Dialogue dialogue;

    public Demon(String name, String roomImage) {
        this.name = name;
        this.roomImage = roomImage;
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

    public String getRoomImage(){
        return roomImage;
    }
}