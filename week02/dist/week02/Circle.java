import java.awt.Color;
import java.awt.Graphics;

public class Circle {
  private int x;
  private int y;
  private int r;
  private Color color;

  public Circle(int x, int y, int r, Color color) {
    this.x = x;
    this.y = y;
    this.r = r;
    this.color = color;
  }

  public void draw(Graphics g) {
    g.setColor(this.color);
    /* ここから */
    g.fillOval(this.x, this.y, this.r, this.r);
    /* ここまで */
  }
}
