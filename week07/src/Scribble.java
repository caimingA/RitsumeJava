import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class Scribble extends Shape {
    private int x;
    private int y;
    private List<Integer> xList = new ArrayList<>();
    private List<Integer> yList = new ArrayList<>();

    public Scribble(int x, int y, Color color) {
        super(color);
        xList.clear();
        yList.clear();
        this.xList.add(x);
        this.yList.add(y);
    }

    @Override
    public void drawShape(Graphics g) {
        int length = this.xList.size();
        int[] xListNew = new int[length];
        int[] yListNew = new int[length];
        System.out.println(xList);
        for(int i = 0; i < length; ++i){
            xListNew[i] = xList.get(i);
            yListNew[i] = yList.get(i);
        }
        g.drawPolyline(xListNew, yListNew, length);
    }

    @Override
    public void resizeTo(int x, int y) {
        this.xList.add(x);
        this.yList.add(y);
    }
}