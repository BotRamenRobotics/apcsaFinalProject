import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

import characters.Demon;

public class Choice {
    
    private ShapeButton buttonTop;
    private ShapeButton buttonBot;
    private int topAff;
    private int botAff;
    private String pressed = "";
    private String currentPic = "";

    private Demon demon;
    private Grid g;


//public Button(String tt, int ti, int td, String bt, int bi, int bd, Demon girl)
    public Choice(String tt, int ta, String bt, int ba, Demon demon, String cPic, Grid g) {
        this.g = g;
        buttonTop = new ShapeButton(tt, 5);
        buttonBot = new ShapeButton(bt, 5);

        topAff = ta;
        botAff = ba;

        this.demon = demon;
        this.currentPic = cPic;
        buttonBot.setPreferredSize(new Dimension(15,21));
        buttonTop.setPreferredSize(new Dimension(15,21));
        buttonTop.setLocation(101, 101);
        buttonBot.setLocation(101, 301);

        //showChoice();

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

      //primary output from Choice class
  public void showChoice() {
    addButton(getTop());
    addButton(getBot());
    setImage();
  }

    public void setImage(){
        g.setMultiCellImage(currentPic, new Location(1, 10), 15, 25);
    }

    public void addButton(ShapeButton sb){
        g.add(sb);
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
