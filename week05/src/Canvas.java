import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Canvas extends JPanel {
  private List<Shape> shapes = new ArrayList<>();
  private ShapeFactory factory = new CircleFactory();
  private Color color = new Color(0, 0, 0, 64);

  public Canvas() {
    /* ここから */
    CanvasListener listener = new CanvasListener(this);
    this.addMouseListener(listener);
    this.addMouseMotionListener(listener);
    /* ここまで */
  }

  public void add(Shape shape) {
    /* ここから */
    this.shapes.add(shape);
    this.repaint();
    /* ここまで */
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Shape s : this.shapes) {
      s.draw(g);
    }
  }

  public ShapeFactory getFactory() {
    /* ここから // 発展課題では，ランダムにファクトリオブジェクトを選ぶように修正する． */
    return factory =  Math.random() < 0.3 ? new CircleFactory() : (Math.random() < 0.5 ? new LineFactory() : new RectangleFactory());
//    return this.factory;
    /* ここまで */
  }

  public Color getColor() {
    /* ここから // 発展課題では色をランダムに選ぶように修正する． */
    return color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256), 64);
//   return this.color;
    /* ここまで */
  }
}
