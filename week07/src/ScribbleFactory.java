import java.awt.Color;

public class ScribbleFactory extends ShapeFactory {

    @Override
    public Shape create(int x, int y, Color color) {
//        return new Line(x, y, x, y, color);
        return new Scribble(x, y, color);
    }
}