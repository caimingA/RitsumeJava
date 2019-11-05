import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Rectangle {
  /* ここから */
  public Oval(int left, int top, int width, int height, Color color) {
      super(left, top, width, height, color);
  }

  @Override
  protected void fillShape(Graphics g, int left, int top, int width, int height) {
      g.fillOval(left, top, width, height);
  }
  /* ここまで */
}
