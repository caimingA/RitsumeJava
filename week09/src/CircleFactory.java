import java.awt.Color;

public class CircleFactory extends ShapeFactory {

  @Override
  public Shape create(int x, int y, Color color) {
    return new Circle(x, y, 0, color);
  }
}
