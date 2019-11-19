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

  public int getX1() {
    /* ここから // x1のインスタンス変数の値を返す．*/
    return this.x1;
    ///return 0;
    /* ここまで */
  }

  public int getY1() {
    /* ここから // y1のインスタンス変数の値を返す．*/
    return this.y1;
    ///return 0;
    /* ここまで */
  }

  public int getX2() {
    /* ここから // x2のインスタンス変数の値を返す．*/
    return this.x2;
    ///return 0;
    /* ここまで */
  }

  public int getY2() {
    /* ここから // y2のインスタンス変数の値を返す．*/
    return this.y2;
    ///return 0;
    /* ここまで */
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

  @Override
  public void accept(Visitor visitor) {
    /* ここから */
    visitor.visitLine(this);
    /* ここまで */
  }
}
