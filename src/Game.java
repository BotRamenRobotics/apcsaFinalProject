
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import characters.Demon;
import characters.Lucy;

/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: Raymond Galvez & Kenneth Wong 
 */

public class Game {

  private Grid splashScreen;
  private Grid splashScreen2;
  private Grid mapGrid;
  private Grid diGrid;
  private Grid currentGrid;

  private boolean checkGrid;

  private Demon demon = new Lucy();

  private int mapGridRows = 14;
  private int mapGridCols = 9;
  private int userRow;
  private int userCol;
  private int msElapsed;
  private int day; //Just here in case
  
  private String userPic = "images/zapdos.png"; 

  //private final ArrayList<Location> lucyLoc = new ArrayList<>();
  private Location lucyLoc = new Location(12, 2); 
  //private Location buttonTop = new Location(5, 0);
  //private Location buttonBot = new Location(7, 0);
  private ShapeButton buttonBot = new ShapeButton("cookie", 5);
  private ShapeButton  buttonTop = new ShapeButton("something else", 5);

  private ArrayList<Choice> choice = new ArrayList<>();
  private ArrayList<Dialogue> dialogue = new ArrayList<>();

  public Game() {
    splashScreen = new Grid(15, 30);
    splashScreen.setTitle("How I Managed to Date All 6 of the Strongest Demon Generals in the Underworld!");
    splashScreen.fullscreen();
    currentGrid = splashScreen;
    WavPlayer.play("sounds/Spongebob.wav");
    buttonBot.setPreferredSize(new Dimension(15,21));
    buttonTop.setPreferredSize(new Dimension(15,21));
    buttonTop.setLocation(101, 101);
    buttonBot.setLocation(101,301);
    //lucyLoc.add(new Location(r, c));

    userRow = mapGridRows -1 ;
    userCol = mapGridCols/2;
    msElapsed = 15;
    updateTitle();
  }
  
  public void play() {

    //Splashscreen1
    splashScreen();

    //Splashscreen2
    // splashScreen2();

    //Begin Map Screen movement
    mapGrid();


    while (!isGameOver()) {

      if(currentGrid == mapGrid){
        handleKeyPress(mapGrid);
        
        if (checkLocation()) {
          diGrid();
        }

      } else if (currentGrid == diGrid){

        handleButtonClick(diGrid);

      }




      // if (msElapsed % 300 == 0) {
      //   scrollLeft();
      //   populateRightEdge();
      // }
      updateTitle();
      msElapsed += 100;
    }
  }
  
  public void handleKeyPress(Grid grid){

    //check last key pressed
    int key = grid.checkLastKeyPressed();
    if(key != -1) System.out.println("Key pressed" + key);

    //set "w" key to move the plane up
    if(key == 87){ //UP
        //check case where out of bounds
      if (userRow == 0) {
        System.out.println("User will go too high");
      }
      else {
        //change the field for userrow

        userRow--;

        //shift the user picture up in the array
        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, userPic);
        
        Location oldLoc = new Location(userRow+1, userCol);
        grid.setImage(oldLoc, null);
      }
  }
    //if I push down arrow, then plane goes down
    else if (key == 83) { //DOWN
      if (userRow == mapGrid.getNumRows()-1) {
        System.out.println("User will be too low!");
      }
      else {
        userRow++;

        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, userPic);
        
        Location oldLoc = new Location(userRow-1, userCol);
        grid.setImage(oldLoc, null);
      }
    }
    else if (key == 65) { //LEFT
      if (userCol == 0) {
        System.out.println("User will be too left!");
      }
      else {
        userCol--;
        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, userPic);
        
        Location oldLoc = new Location(userRow, userCol+1);
        grid.setImage(oldLoc, null);
      }
    }
    else if (key == 68) { //RIGHT
      if (userCol == mapGrid.getNumCols() -1 ) {
        System.out.println("User will be too right!");
      }
      else {
        userCol++;
        Location loc = new Location(userRow, userCol);
        grid.setImage(loc, userPic);
        
        Location oldLoc = new Location(userRow, userCol-1);
        grid.setImage(oldLoc, null);
      }
    }
  }
  
  public void handleButtonClick(Grid grid) {
    
    Location loc = grid.checkLastLocationClicked();

    if(loc != null) System.out.println("Loc:" + loc);

    if(grid == diGrid){
      if (buttonTop.equals(loc)) {
        System.out.println("top");
      } else if (buttonBot.equals(loc)) {
        System.out.println("bot");
      }
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

  public boolean checkLocation() {
    if (checkGrid) {
      System.out.println(userRow == lucyLoc.getRow() && userCol == lucyLoc.getCol());
      if (userRow == lucyLoc.getRow() && userCol == lucyLoc.getCol()) {
        return true;
      }
    }
    return false;
  }
  
  public void splashScreen() {
    System.out.println("Splash screen");
    //splashScreen.fullscreen();
    splashScreen.setBackground("images/Helltaker_Cover.jpg");
    splashScreen.waitForClick();
    splashScreen.close();
  }

  public void mapGrid() {
    checkGrid = true;
    System.out.println("MapGrid initializing...");
    mapGrid = new Grid(mapGridRows, mapGridCols);
    mapGrid.setTitle("Chambers of the Glorius");
    mapGrid.fullscreen();
    mapGrid.setBackground("images/map.png");
    mapGrid.setImage(new Location(userRow, userCol), userPic);
    currentGrid = mapGrid;
  }

  public void diGrid() {
    checkGrid = false;
    mapGrid.close();
    diGrid = new Grid(20, 35);
    diGrid.add(buttonTop);
    diGrid.add(buttonBot);
    diGrid.setTitle(demon.getName() + " Room | " + getScore());
    diGrid.setBackground("images/room.jpg");
    currentGrid = diGrid;

    diGrid.setMultiCellImage("images/leviproto.png", new Location(1, 10), 15, 25);
  }

  public void populateRightEdge(){

  }
  
  public void scrollLeft(){

  }
  
  public void handleCollision(Location loc) {

  }
  
  public int getScore() {
    return 0;
    //return demon.getAffection();
  }
  
  public void updateTitle() {
    splashScreen.setTitle("How I Managed to Date All 6 of the Strongest Demon Generals in the Underworld!");
  }
  
  public boolean isGameOver() {
    return (demon.getAffection() == 100);
  }
    

}