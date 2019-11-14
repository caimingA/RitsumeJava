import java.awt.Color;
import java.awt.Graphics;

public class Star extends Rectangle {
    /* ここから */
    public Star(int left, int top, int width, int height, Color color) {
        super(left, top, width, height, color);
    }
    @Override
    public void drawShape(Graphics g) {
        int[] xpoints = new int[6];
        int[] ypoints = new int[6];

        //1(left + width/2, top), 4(left, top + heigth / 3), 3(left + width, top + heigth / 3), 2(left + wdith / 4, top + heigth), 5(left + 3*width/4, top + heigth)

        xpoints[0] = this.left + this.width / 2;
        xpoints[3] = this.left;
        xpoints[2] = this.left + this.width;
        xpoints[1] = this.left + this.width / 4;
        xpoints[4] = this.left + this.width * 3 / 4;
        xpoints[5] = this.left + this.width / 2;

        ypoints[0] = this.top;
        ypoints[3] = this.top + this.height * 2 / 5;
        ypoints[2] = this.top + this.height * 2 / 5;
        ypoints[1] = this.top + this.height;
        ypoints[4] = this.top + this.height;
        ypoints[5] = this.top;

        g.drawPolygon(xpoints, ypoints, 6);
    }
    /* ここまで */
}