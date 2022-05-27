
import java.awt.*;
import javax.swing.*;

import characters.Demon;

/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: Raymond Galvez & Kenneth Wong 
 */

public class Game {

  private Grid mapGrid;
  private Grid diGrid;
  private Grid splashScreen;
  private Grid splashScreen2;

  private Demon demon;

  private int userRow;
  private int msElapsed;
  private int day; //Just here in case
  
  private String userPic = "images/user.gif"; 

  private Location buttonTop = new Location(5, 0);
  private Location buttonBot = new Location(7, 0);

  public Game() {

    splashScreen = new Grid(10, 20);
    splashScreen.setTitle("How I Managed to Date All 6 of the Strongest Demon Generals in the Underworld!");
    userRow = 0;
    msElapsed = 15;
    updateTitle();
  }
  
  public void play() {

    while (!isGameOver()) {
      splashScreen();
      // splashScreen2();
      mapGrid();
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
    Location loc = splashScreen.checkLastLocationClicked();
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
  
  public void splashScreen() {
    splashScreen.fullscreen();
    splashScreen.setBackground("images/Helltaker_Cover.jpg");
    splashScreen.waitForClick();
  }

  public void mapGrid() {
    mapGrid = new Grid(9, 14);
    mapGrid.setTitle("Chambers of the Glorius");
    mapGrid.fullscreen();
    mapGrid.setBackground("images/map.png");
    handleKeyPress();
  }

  public void diGrid() {
    diGrid = new Grid(20, 35);
    diGrid.setTitle(demon.getName() + "'s Room | " + getScore());
  }

  public void populateRightEdge(){

  }
  
  public void scrollLeft(){

  }
  
  public void handleCollision(Location loc) {

  }
  
  public int getScore() {
    return demon.getAffection();
  }
  
  public void updateTitle() {
    splashScreen.setTitle("How I Managed to Date All 6 of the Strongest Demon Generals in the Underworld!");
  }
  
  public boolean isGameOver() {
    return false;
  }
    

}