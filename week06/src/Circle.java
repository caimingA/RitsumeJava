import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
  private int x;
  private int y;
  private int r;

  public Circle(int x, int y, int r, Color color) {
    super(color);
    this.x = x;
    this.y = y;
    this.r = r;
  }

  @Override
  public void drawShape(Graphics g) {
    g.fillOval(this.x - this.r, this.y - this.r, this.r * 2, this.r * 2);
  }

  @Override
  public void resizeTo(int x, int y) {
    int dx = x - this.x;
    int dy = y - this.y;
    this.r = (int) (Math.sqrt(dx * dx + dy * dy));
  }
}
