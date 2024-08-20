import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;


public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      Grid grid = new Grid(); 
      List<Point> mouseTrails = new ArrayList<>(); 
      static final int MAX_TRAILS = 100;

      public Canvas() {
       setPreferredSize(new Dimension(720, 720));
      }

      @Override 
      public void paint(Graphics g) { 
        Point mousePos = getMousePosition(); 
        if(mousePos != null){  

          if(mouseTrails.size() >= MAX_TRAILS){ 
            mouseTrails.remove(0); 
          }
          mouseTrails.add(mousePos); 
        }
        grid.paint(g , mousePos , mouseTrails); 
      }
    }
    private Main() {
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      this.setContentPane(canvas);
      this.pack();
      this.setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();
      }
    }
}
