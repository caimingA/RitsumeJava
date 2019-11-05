import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Canvas extends JPanel {
  private List<Shape> shapes = new ArrayList<>();
  private ShapeFactory factory = new CircleFactory(); // デフォルトのファクトリ
  private Color color = new Color(0, 0, 0, 64); // デフォルトカラー

  public Canvas() {
    CanvasListener listener = new CanvasListener(this);
    this.addMouseListener(listener);
    this.addMouseMotionListener(listener);
  }

  public void add(Shape shape) {
    this.shapes.add(shape);
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Shape s : this.shapes) {
      s.draw(g);
    }
  }

  public ShapeFactory getFactory() {
    return this.factory;
  }

  public void setFactory(ShapeFactory factory) {
    /* ここから */
    this.factory = factory;
    /* ここまで */
  }

  public Color getColor() {
    return this.color;
  }

  public void setColor(Color color) {
    /* ここから */
    this.color = color;
    /* ここまで */
  }
}
