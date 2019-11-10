import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public Line(int x1, int y1, int x2, int y2, Color color) {
    super(color);
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  @Override
  public void drawShape(Graphics g) {
    g.drawLine(this.x1, this.y1, this.x2, this.y2);
  }

  @Override
  public void resizeTo(int x, int y) {
    this.x2 = x;
    this.y2 = y;
  }
}
