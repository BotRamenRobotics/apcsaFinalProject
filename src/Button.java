import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import characters.Demon;

public class Button {
    
    private ShapeButton buttonTop;
    private ShapeButton buttonBot;
    private int topAff;
    private int botAff;
    private String pressed = "";

    private Demon demon;



//public Button(String tt, int ti, int td, String bt, int bi, int bd, Demon girl)
    public Button(String tt, int td, String bt, int bd, Demon demon) {
        buttonTop = new ShapeButton(tt, 5);
        buttonBot = new ShapeButton(bt, 5);

        topAff = td;
        botAff = bd;

        this.demon = demon;

        buttonBot.setPreferredSize(new Dimension(15,21));
    buttonTop.setPreferredSize(new Dimension(15,21));
    buttonTop.setLocation(101, 101);
    buttonBot.setLocation(101, 301);

    buttonTop.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            recordButtonPush("TOP");
        }
    });

    buttonBot.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            recordButtonPush("BOT");
        }
    });

    


    }

    public ShapeButton getTop() {
        return buttonTop;
    }

    public ShapeButton getBot() {
        return buttonBot;
    }

    private void recordButtonPush(String buttonInitial){
		pressed = buttonInitial;
    }

    public int getTopAffection() {
        return topAff;
    }

    public int getBotAffection() {
        return botAff;
    }

    public void resetButtons() {
       pressed = "";
    }

    public String getPress() {
        return pressed;
    }

}
