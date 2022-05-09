package characters;

public class User {
    
    private String name;
    private int money;


    public User(String name) {

        this.name = name;
        money = 0;
    }

    public int getMoney() {
        return money;
    }

    public void changeMoney(int m) { //basic mutator
        money += m;
    }

}
