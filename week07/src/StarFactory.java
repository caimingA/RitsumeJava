import java.awt.Color;

public class StarFactory extends ShapeFactory {
    /* ここから */
    @Override
    public Shape create(int x, int y, Color color) {
        return new Star(x, y, 0, 0, color);
    }
    /* ここまで */
}
