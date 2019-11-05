import java.awt.Color;
import java.awt.Graphics;

public class Rectangle {
  private int left;
  private int top;
  private int width;
  private int height;
  private Color color;

  public Rectangle(int left, int top, int width, int height, Color color) {
    this.left = left;
    this.top = top;
    this.width = width;
    this.height = height;
    this.color = color;
  }

  public void draw(Graphics g) {
    /* ここから */
    g.setColor(this.color);
    g.fillRect(this.left, this.top, this.width, this.height);
    /* ここまで */
  }
}
