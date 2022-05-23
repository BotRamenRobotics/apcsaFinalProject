
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
  private int timesGet;
  private int timesAvoid;
  private String userPic = "images/user.gif"; 
  private Color cyan = new Color(0, 188, 227);
  private Color red = new Color(157, 34, 53);

  private int day; //Just here in case
  private JPanel leftPanel;
  private ShapeButton leftButton;

  
  
  public Game() {

    grid = new Grid(30, 30);
    userRow = 7;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setImage(new Location(userRow, 0), userPic);
    
    for (int i = 0; i < grid.getNumCols(); i++) {
      grid.setFillColor(new Location(grid.getNumRows()-3, i), cyan);
      grid.setFillColor(new Location(grid.getNumRows()-2, i), red); 
    }
  }
  
  public void play() {

    while (!isGameOver()) {
      grid.pause(100);
      handleKeyPress();
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

  }

  public boolean checkButtonClick(int button) {
    // if () {
    //   return true;
    // }
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