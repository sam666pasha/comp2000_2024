import java.awt.Graphics;
import java.awt.Point;
import java.util.List;

public class Grid {
  // fields
  Cell[][] cells = new Cell[20][20];
  
  // constructors
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j] = new Cell(10 + Cell.size * i, 10 + Cell.size * j);
      
      }
    }
  }
  // methods
  public void paint(Graphics g, Point mousePos , List<Point> mouseTrails) {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        cells[i][j].paint(g, mousePos); 
      }
    }
  for (int i = 1; i < mouseTrails.size();i++){
    
    Point trail = mouseTrails.get(i); 
    
    int alpha = (int) ( 255 * ( i ) / (float) mouseTrails.size()); 
    
for(int j = 0 ; j < cells.length ; j++){ 
  for(int k = 0 ; k < cells[j].length ; k++){ 
  cells[j][k].drawMouseTrail(g , trail , alpha); 
}
}
System.out.println(trail);
  }
  
  }
}
