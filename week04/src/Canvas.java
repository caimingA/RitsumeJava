import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Canvas extends JPanel {
  private List<Shape> shapes = new ArrayList<>();
  /* ここから // 発展課題では，Circle, Rectangle, Lineからランダムに選択する．*/

  //random is happended in the function 'getFactory()'
  //member 'factory' is initialized to be circleFactory
  private ShapeFactory factory =  new CircleFactory();
  /* ここまで */
  private Color color = new Color(0, 0, 0, 64);

  public void add(Shape shape) {
    this.shapes.add(shape);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Shape s : this.shapes) {
      s.draw(g);
    }
  }

  public ShapeFactory getFactory() {
    /* ここから // factoryのインスタンス変数の値を返すように書き換える．*/
    return factory =  Math.random() < 0.3 ? new CircleFactory() : (Math.random() < 0.5 ? new LineFactory() : new RectangleFactory());
    /* ここまで */
  }

  public Color getColor() {
    /* ここから // colorのインスタンス変数の値を返すように書き換える．*/
    return color = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256), 64);
    /* ここまで */
  }
}
