package scenarios;

import characters.*;

public class Scenario {

    private String setting; //Name of the place this scenario takes place
    private static final Demon[] girl = {new Asmo(), new Belle(), new Levi(), new Lucy(), new Mammon(), new Satan()};
    private String dialogue;
    // boolean / separate object for options+
    
    public Scenario(String setting, String dialogue) {
        this.setting = setting;
        this.dialogue = dialogue;
    }

    
}