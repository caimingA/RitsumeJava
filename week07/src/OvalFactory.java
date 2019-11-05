import java.awt.Color;

public class OvalFactory extends ShapeFactory {
  /* ここから */
  @Override
  public Shape create(int x, int y, Color color) {
      return new Oval(x, y, 0, 0, color);
  }
  /* ここまで */
}
