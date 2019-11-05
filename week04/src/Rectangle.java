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
    g.fillRect(this.left, this.top, this.width, this.height);
  }
}
