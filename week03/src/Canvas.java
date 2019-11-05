import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Canvas extends JPanel {
  private List<Shape> shapes = new ArrayList<>();

  public void add(Shape shape) {
    /* ここから // ヒント：第２週のCanvasクラスの定義を参考にする． */
    this.shapes.add(shape);
    /* ここまで */
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Shape s : this.shapes) {
      /* ここから // ヒント：第２週のCanvasクラスの定義を参考にする． */
      s.draw(g);
      /* ここまで */
    }
  }
}
