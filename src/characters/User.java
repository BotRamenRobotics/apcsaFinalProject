package characters;

public class User {
    
    private String name;
    private int money;
    private static int energy;


    public User(String name) {

        this.name = name;
        money = 0;
        energy = 3;
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
    // get enrgy do that later maybe please 
}
