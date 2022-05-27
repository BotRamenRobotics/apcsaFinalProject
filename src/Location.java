public class Location {

  private int row;
  private int col;
  
  public Location(int r, int c) {
    row = r;
    col = c;
  }
  
  public int getRow() {
    return row;
  }
  
  public int getCol() {
    return col;
  }
  
  public boolean equals(Location otherLoc) {
    if(otherLoc == null){
      //System.out.println("Invalid otherLoc in equals() method");
      return false;
    }
    return row == otherLoc.getRow() && col == otherLoc.getCol();
  }
  
  public String toString() {
    return "(" + row + ", " + col + ")";
  }
} 