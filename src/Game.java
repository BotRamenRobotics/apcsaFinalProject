
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

  private Demon currentDemon = new Lucy();

  private int mapGridRows = 14;
  private int mapGridCols = 9;
  private int userRow;
  private int userCol;
  private int msElapsed;
  public static int day = 0; //Just here in case
  private String title;
  private boolean lost = false;
  private ArrayList<Choice> choices;

  private String userPic = "images/zapdos.png"; 

  //private final ArrayList<Location> lucyLoc = new ArrayList<>();
  private Location lucyLoc = new Location(12, 2); 
  //private Location buttonTop = new Location(5, 0);
  //private Location buttonBot = new Location(7, 0);
  // private ShapeButton buttonBot = new ShapeButton("cookie", 5);
  // private ShapeButton  buttonTop = new ShapeButton("something else", 5);

  //Button constructor - top Text,, Top Affection, Bot Text, Bot affection, demon, char img, grid
  private Choice continue1 = new Choice("Continue", 0, "Continue", 0, currentDemon, "images/lucy.png", currentGrid);
  private Choice continue2 = new Choice("Continue", 0, "Continue", 0, currentDemon, "images/lucyanger.png", currentGrid);
  private Choice continue3 = new Choice("Continue", 0, "Continue", 0, currentDemon, "images/lucy.png", currentGrid);
  private Choice continue4 = new Choice("Continue", 0, "Continue", 0, currentDemon, "images/lucy.png", currentGrid);
  private Choice continue5 = new Choice("Continue", 0, "Continue", 0, currentDemon, "images/lucy.png", currentGrid);
  private Choice continue6 = new Choice("Continue", 0, "Continue", 0, currentDemon, "images/lucy.png", currentGrid);
  private Choice continue7 = new Choice("Continue", 0, "Continue", 0, currentDemon, "images/lucy.png", currentGrid);
  private Choice continue8 = new Choice("Continue", 0, "Continue", 0, currentDemon, "images/lucy.png", currentGrid);
  private Choice continue9 = new Choice("Continue", 0, "Continue", 0, currentDemon, "images/lucy.png", currentGrid);

  private Choice choice1 = new Choice("Well, this pig is here to serve you your medicine…", 20, "The real pig here’s the helpless one coughing in her bed.", -100, currentDemon, "images/lucy.png", currentGrid);
  private Choice choice2 = new Choice("“So how are you feeling?”", 20, "Watch her eat in silence.", 12, currentDemon, "images/lucy.png", currentGrid);
  private Choice choice3 = new Choice("“You can boss me around anytime.”", 100, "“Yep, I’m stupid! That’s me.”", 10, currentDemon, "images/lucy.png", currentGrid);
  private Choice end = new Choice("end", 0, "end", 0, currentDemon, "images/lucy.png", currentGrid);
  //private ArrayList<Choice> choice = new ArrayList<>();
  private ArrayList<Dialogue> dialogue = new ArrayList<>();

  public Game() {

    choices = new ArrayList<Choice>();
    choices.add(continue1);
    choices.add(continue2);
    choices.add(continue3);
    choices.add(continue4);
    choices.add(continue5);
    choices.add(choice1);

    choices.add(continue6);
    choices.add(continue7);
    choices.add(choice2);

    choices.add(continue8);
    choices.add(continue9);
    choices.add(choice3);

    choices.add(end);

    splashScreen = new Grid(15, 30);
    splashScreen.setTitle("How I Managed to Date All 6 of the Strongest Demon Generals in the Underworld!");
    splashScreen.fullscreen();
    currentGrid = splashScreen;
    WavPlayer.play("sounds/menumusic.wav");

    userRow = mapGridRows -1 ;
    userCol = mapGridCols/2;
    msElapsed = 15;
    updateTitle();
  }
  
  public void play() {

    //Splashscreen1
    splashScreen();

    //Begin Map Screen movement
    mapGrid();


    while (!isGameOver()) {    
      if (day == (choices.size() - 1)) {
        lost = true;
      }
      if(checkGrid){
        handleKeyPress(mapGrid);
        if (checkLocation()) {
          diGrid(currentDemon);
        }
      } 
      else if (!checkGrid) {
        System.out.println(currentDemon.getAffection());
          Choice currentChoice = choices.get(day);
          title = currentDemon.getName() + "\'s Room | " + currentDemon.getAffection();
          diGrid.setTitle(title);
          System.out.println("Day: " + day);
          currentChoice = choices.get(day);
          showChoice(currentChoice);
          checkButtonPress(currentGrid, currentChoice);
      }
      updateTitle();
      msElapsed += 100;
    }
    System.out.println("Game is over");

    if (!lost) {
      System.out.println("You won!");
      diGrid.setBackground("images/win.png");
    }
    else if (lost) {
      System.out.println("You lost!");
    }
    else {
      System.out.println("You broke the game");
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
  
  public void handleButtonClick(Grid grid, Choice ch) {
    
    Location loc = grid.checkLastLocationClicked();
    if(loc != null) System.out.println("Loc:" + loc);
  }

  public boolean checkLocation() {
    if (checkGrid) {
      //System.out.println(userRow == lucyLoc.getRow() && userCol == lucyLoc.getCol());
      if (userRow == lucyLoc.getRow() && userCol == lucyLoc.getCol()) {
        return true;
      }
    }
    return false;
  }
  
  public void splashScreen() {
    System.out.println("Splash screen");
    //splashScreen.fullscreen();
    splashScreen.setBackground("images/gamig.png");
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

  public void diGrid(Demon d) {
    currentGrid = diGrid;
    checkGrid = false;
    mapGrid.close();
    diGrid = new Grid(20,35, true);
    diGrid.setBackground(d.getRoomImage());
    diGrid.setMultiCellImage("images/lucy.png", new Location(1, 10), 15, 25);
    diGrid.setTitle(title);  
    
    diGrid.setDialogueText("Your hands tremble slightly as you open the door, a tray full of food in hand. \n“Miss Lucifer?”");
    showChoice(choices.get(day));
    
    diGrid.setDialogueText("An annoyed yet hoarse voice can be heard in response. \n“Get my name out of your filthy mouth, sla-”");
    showChoice(choices.get(day));
  }

  
  public int getScore() {
    return 0;
    //return demon.getAffection();
  }
  
  public void updateTitle() {
    splashScreen.setTitle("How I Managed to Date All 6 of the Strongest Demon Generals in the Underworld!");
  }

  public void checkButtonPress(Grid grid, Choice ch) {
      if (ch.getPress().equals("TOP")) {
        currentDemon.changeAffection(ch.getTopAffection());
        ch.resetButtons();
       // hideButton(grid, ch);
       ch.getTop().setVisible(false);
       ch.getBot().setVisible(false);
        day++;
      }
      else if (ch.getPress().equals("BOT")) {
        currentDemon.changeAffection(ch.getBotAffection());
        ch.resetButtons();
       // hideButton(grid, ch);
       ch.getTop().setVisible(false);
       ch.getBot().setVisible(false);
        day++;
      }
  }



  public void hideButton(Grid grid, Choice b) {

    grid.remove(b.getTop());
    grid.remove(b.getBot());
    b.getTop().setVisible(false);
    b.getBot().setVisible(false);
  }
  
  public boolean isGameOver() {
    if ((currentDemon.getAffection() >= 100) || lost) {
    return true; }
    else {
    return false; }
  }

  public void showChoice(Choice c) {
   diGrid.add(c.getTop());
    diGrid.add(c.getBot());
    diGrid.setMultiCellImage(c.getImg(), new Location(1, 10), 15, 25);
  }
    
  // public void dialogRunner() {
  //   //looping through arraylist of dialogue objects with logic, if this option that option 
  //   int i = 0;
  //   while(true){

  //     showButton(diGrid, op1);
  //     diGrid.setTitle(currentDemon.getName() + " Room | " + getScore());  
  //     diGrid.setMultiCellImage("images/leviproto.png", new Location(1, 10), 15, 25);
  
  //   }

  // }
}