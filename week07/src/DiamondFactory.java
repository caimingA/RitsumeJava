import java.awt.Color;

public class DiamondFactory extends ShapeFactory {
  /* ここから */
  @Override
  public Shape create(int x, int y, Color color) {
      return new Diamond(x, y, 0, 0, color);
  }
  /* ここまで */
}
