import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Canvas extends JPanel {
  private List<Circle> circles = new ArrayList<>();
  /* ここから // 発展課題 */
  private List<Rectangle> rectangles = new ArrayList<>();
  /* ここまで */

  public void add(Circle c) {
    /* ここから */
    this.circles.add(c);
    /* ここまで */
  }

  /* ここから // 発展課題 */
  public void addRect(Rectangle r){
    this.rectangles.add(r);
  }
  /* ここまで */

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for(Circle c : this.circles){
      /* ここから */
      c.draw(g);
      /* ここまで */
    }
    /* ここから // 発展課題 */
  for(Rectangle r : this.rectangles){
    r.draw(g);
  }


    /* ここまで */
  }
}
