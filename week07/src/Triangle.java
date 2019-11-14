import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Rectangle {
    /* ここから */
    public Triangle(int left, int top, int width, int height, Color color) {
        super(left, top, width, height, color);
    }
    @Override
    public void drawShape(Graphics g) {
        int[] xpoints = new int[3];
        int[] ypoints = new int[3];

        //(left + width/2, top), (left, top + heigth), (left + width, top + heigth)

        xpoints[0] = this.left + this.width / 2;
        xpoints[1] = this.left;
        xpoints[2] = this.left + this.width;

        ypoints[0] = this.top;
        ypoints[1] = this.top + this.height;
        ypoints[2] = this.top + this.height;

        g.fillPolygon(xpoints, ypoints, 3);
    }
    /* ここまで */
}