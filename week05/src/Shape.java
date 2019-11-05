import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
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
}
