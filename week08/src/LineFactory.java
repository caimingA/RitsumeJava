import java.awt.Color;

public class LineFactory extends ShapeFactory {

  @Override
  public Shape create(int x, int y, Color color) {
    return new Line(x, y, x, y, color);
  }
}
