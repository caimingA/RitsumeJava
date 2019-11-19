import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements VisitorAcceptor {
  private Color color;

  public Shape(Color color) {
    this.color = color;
  }

  public void draw(Graphics g) {
    g.setColor(this.color);
    this.drawShape(g);
  }

  public abstract void drawShape(Graphics g);

  public abstract void resizeTo(int x, int y);

  public Color getColor() {
    /* ここから // colorのインスタンス変数の値を返す．*/
    return this.color;
    ///return null;
    /* ここまで */
  }
}
