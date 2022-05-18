package characters;

public class User {
    
    private String name;
    private int money;
    private static int energy;
    private String[] inven;
    private int space;


    public User(String name) {

        this.name = name;
        money = 0;
        energy = 6;
        inven = new String[6];
        space = 6; 

    }

    public int getMoney() {
        return money;
    }

    public void changeMoney(int m) { //basic mutator
        money += m;
    }

    public static void action() {
        energy--;
        
    }
    // getenrgy do that later maybe please 
    public static int getEnergy() {
        return energy;
    }
    public int getInventorySpace() {
        return space;
    }
    public String searchItem(String item) {

        boolean found = false;

        for (int i = 0; i < inven.length; i++) {
            if (inven[i].equals(item)) {
                found = true;
                break;
            }
        }
        if (found) 
        return "You have this item";
        else
        return "You dont have this item";
    }
    public boolean gift(String item) {

        boolean found = false;

        for (int i = 0; i < inven.length; i++) {
            if (inven[i].equals(item)) {
                found = true;
                inven[i] = null;
                break;
            }
        }
        return found;
    }
    
}
