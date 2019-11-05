import java.awt.Color;

public class LineFactory extends ShapeFactory {

  @Override
  public Shape create(int x, int y, Color color) {
    /* ここから // 長さが0のLineのインスタンスを生成してそれを返すように書き換える．*/
    return new Line(x, y, x, y, color);
    /* ここまで */
  }
}
