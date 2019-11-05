import java.awt.Color;

public class RectangleFactory extends ShapeFactory {

  @Override
  public Shape create(int x, int y, Color color) {
    return new Rectangle(x, y, 0, 0, color);
  }
}
