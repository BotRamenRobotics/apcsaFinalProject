
import java.awt.*;
import javax.swing.*;

/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: Raymond Galvez & Kenneth Wong 
 */

public class Game {

  private Grid mapGrid;
  private Grid diGrid;
  private int userRow;
  private int msElapsed;
  private String userPic = "images/user.gif"; 
  private Color cyan = new Color(0, 188, 227);
  private Color red = new Color(157, 34, 53);

  private int day; //Just here in case
  private JPanel leftPanel;
  private ShapeButton leftButton; 
  private Location buttonTop = new Location(5, 0);
  private Location buttonBot = new Location(7, 0);

  
  
  public Game() {

    diGrid = new Grid(10, 10);
    userRow = 0;
    msElapsed = 15;
    updateTitle();
    diGrid.setImage(new Location(userRow, 0), userPic);
    
    for (int i = 0; i < diGrid.getNumCols(); i++) {
      diGrid.setFillColor(new Location(diGrid.getNumRows()-5, i), cyan);
      diGrid.setFillColor(new Location(diGrid.getNumRows()-3, i), red); 
    }
  }
  
  public void play() {

    while (!isGameOver()) {
      diGrid.pause(100);
      //handleKeyPress();
      handleButtonClick();
      if (msElapsed % 300 == 0) {
        scrollLeft();
        populateRightEdge();
      }
      updateTitle();
      msElapsed += 100;
    }
  }
  
  public void handleKeyPress(){

    //check last key pressed
    int key = mapGrid.checkLastKeyPressed();
    System.out.println(key);

    //set "w" key to move the plane up
    if(key == 87){
        //check case where out of bounds

        //change the field for userrow

        userRow--;

        //shift the user picture up in the array
        Location loc = new Location(userRow, 0);
        mapGrid.setImage(loc, userPic);
        
        Location oldLoc = new Location(userRow+1, 0);
        mapGrid.setImage(oldLoc, null);

  }
    //if I push down arrow, then plane goes down


  }
  
  public void handleButtonClick() {

    Location loc = diGrid.checkLastLocationClicked();
    if(loc != null) System.out.println("Loc:" + loc);

    if (buttonTop.equals(loc)) {
      System.out.println("top");
    } else if (buttonBot.equals(loc)) {
      System.out.println("bot");
    }


      // grid.waitForClick();
      // if(checkButtonClick() == true) {
      //   System.out.println("hi!");
      // }
  }

  // public boolean checkButtonClick() {
  //     if (grid.checkLastLocationClicked() != null && 
  //        (grid.checkLastLocationClicked().equals(buttonBot) || 
  //         grid.checkLastLocationClicked().equals(buttonTop))) {
  //       return true;
  //     }
  //   return false;
  // }

  public void populateRightEdge(){

  }
  
  public void scrollLeft(){

  }
  
  public void handleCollision(Location loc) {

  }
  
  public int getScore() {
    return 0;
  }
  
  public void updateTitle() {
    diGrid.setTitle("Game:  " + getScore());
  }
  
  public boolean isGameOver() {
    return false;
  }
    

}