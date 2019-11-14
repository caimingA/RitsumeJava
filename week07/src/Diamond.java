import java.awt.Color;
import java.awt.Graphics;

public class Diamond extends Rectangle {
  /* ここから */
  public Diamond(int left, int top, int width, int height, Color color) {
      super(left, top, width, height, color);
  }
  @Override
  public void drawShape(Graphics g) {
      int[] xpoints = new int[4];
      int[] ypoints = new int[4];
      xpoints[0] = this.left + this.width / 2;
      xpoints[1] = this.left + this.width;
      xpoints[2] = xpoints[0];
      xpoints[3] = this.left;
      ypoints[0] = this.top;
      ypoints[1] = this.top + this.height / 2;
      ypoints[2] = this.top + this.height;
      ypoints[3] = ypoints[1];
      g.fillPolygon(xpoints, ypoints, 4);
  }
  /* ここまで */
}

