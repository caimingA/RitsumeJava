import java.awt.Color;

public class TriangleFactory extends ShapeFactory {
    /* ここから */
    @Override
    public Shape create(int x, int y, Color color) {
        return new Triangle(x, y, 0, 0, color);
    }
    /* ここまで */
}
