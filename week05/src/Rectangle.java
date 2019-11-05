import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
  private int left;
  private int top;
  private int width;
  private int height;

  public Rectangle(int left, int top, int width, int height, Color color) {
    super(color);
    this.left = left;
    this.top = top;
    this.width = width;
    this.height = height;
  }

  @Override
  public void drawShape(Graphics g) {
    /* ここから */
    int left = this.left;
    int top = this.top;
    int width = this.width;
    int height = this.height;
    if (width < 0) {
      left = left + width;
      width = -width;
    }
    if (height < 0) {
      top = top + height;
      height = -height;
    }
    g.fillRect(left, top, width, height);
    /* ここまで */
  }

  @Override
  public void resizeTo(int x, int y) {
    /* ここから */
    this.width = x - this.left;
    this.height = y - this.top;
    /* ここまで */
  }
}
