import java.awt.Color;

public class LineFactory extends ShapeFactory {

  @Override
  public Shape create(int x, int y, Color color) {
    /* ここから // Lineのインスタンスを生成してそれを返すように書き換える．*/
    return new Line(x, y, x + (int)(Math.random() * 120), y + (int)(Math.random() * 100), color);
    /* ここまで */
  }
}
