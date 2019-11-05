import java.awt.Color;

public class RectangleFactory extends ShapeFactory {

  @Override
  public Shape create(int x, int y, Color color) {
    /* ここから // Rectangleのインスタンスを生成してそれを返すように書き換える．*/
    return new Rectangle(x, y, x + (int)(Math.random() * 100), y + (int)(Math.random() * 100), color);
    /* ここまで */
  }
}
