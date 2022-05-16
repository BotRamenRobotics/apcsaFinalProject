package characters;

public class User {
    
    private String name;
    private int money;
    private static int energy;


    public User(String name) {

        this.name = name;
        money = 0;
        energy = 6;
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
    
}
