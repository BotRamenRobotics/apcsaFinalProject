
import java.awt.*;
import javax.swing.*;

/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: Raymond Galvez & Kenneth Wong 
 */

public class Game {

  private Grid grid;
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

    grid = new Grid(10, 10);
    userRow = 0;
    msElapsed = 15;
    updateTitle();
    grid.setImage(new Location(userRow, 0), userPic);
    
    for (int i = 0; i < grid.getNumCols(); i++) {
      grid.setFillColor(new Location(grid.getNumRows()-5, i), cyan);
      grid.setFillColor(new Location(grid.getNumRows()-3, i), red); 
    }
  }
  
  public void play() {

    while (!isGameOver()) {
      grid.pause(100);
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
    int key = grid.checkLastKeyPressed();
    System.out.println(key);

    //set "w" key to move the plane up
    if(key == 87){
        //check case where out of bounds

        //change the field for userrow

        userRow--;

        //shift the user picture up in the array
        Location loc = new Location(userRow, 0);
        grid.setImage(loc, "user.gif");
        
        Location oldLoc = new Location(userRow+1, 0);
        grid.setImage(oldLoc, null);

  }
    //if I push down arrow, then plane goes down


  }
  
  public void handleButtonClick() {
      grid.waitForClick();
      if(checkButtonClick() == true) {
        System.out.println("hi!");
      }
  }

  public boolean checkButtonClick() {
      if (grid.checkLastLocationClicked() != null && 
         (grid.checkLastLocationClicked().equals(buttonBot) || 
          grid.checkLastLocationClicked().equals(buttonTop))) {
        return true;
      }
    return false;
  }

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
    grid.setTitle("Game:  " + getScore());
  }
  
  public boolean isGameOver() {
    return false;
  }
    

}