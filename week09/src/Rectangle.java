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

  public int getLeft() {
    /* ここから // leftのインスタンス変数の値を返す．*/
    return this.left;
    ///return 0;
    /* ここまで */
  }

  public int getTop() {
    /* ここから // topのインスタンス変数の値を返す．*/
    return this.top;
    ///return 0;
    /* ここまで */
  }

  public int getWidth() {
    /* ここから // widthのインスタンス変数の値を返す．*/
    return this.width;
    ///return 0;
    /* ここまで */
  }

  public int getHeight() {
    /* ここから // heightのインスタンス変数の値を返す．*/
    return this.height;
    ///return 0;
    /* ここまで */
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
    g.fillRect(left, top, width, height);
  }

  @Override
  public void resizeTo(int x, int y) {
    this.width = x - this.left;
    this.height = y - this.top;
  }

  @Override
  public void accept(Visitor visitor) {
    /* ここから */
    visitor.visitRectangle(this);
    /* ここまで */
  }
}
