import java.util.ArrayList;

import characters.Demon;
import characters.Lucy;

public class Dialogue {
    
    private String line;
    private Demon demon;
    private Choice choice; 
    private String image;

    //private final String[] demons = {"Asmo", "Belle", "Levi", "Lucy", "Mammon", "Satan"};
    
    public Dialogue(String image, Choice choice, String line) {
        this.image = image; 
        this.choice = choice;
        this.line = line; 
        demon = new Lucy();
    }

    public Dialogue displayDialogue() {
        return null; //
    }
}
