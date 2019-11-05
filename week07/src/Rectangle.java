import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
  protected int left;
  protected int top;
  protected int width;
  protected int height;

  public Rectangle(int left, int top, int width, int height, Color color) {
    super(color);
    this.left = left;
    this.top = top;
    this.width = width;
    this.height = height;
  }

  @Override
  public void drawShape(Graphics g) {
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
    // OvalのdrawShapeと異なる部分を切り出す．
    this.fillShape(g, left, top, width, height);
  }

  protected void fillShape(Graphics g, int left, int top, int width, int height) {
    g.fillRect(left, top, width, height);
  }

  @Override
  public void resizeTo(int x, int y) {
    this.width = x - this.left;
    this.height = y - this.top;
  }
}
