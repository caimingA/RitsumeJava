import java.awt.Color;

public class RectangleFactory extends ShapeFactory {

  @Override
  public Shape create(int x, int y, Color color) {
    /* ここから // 大きさが0のRectangleのインスタンスを生成してそれを返すように書き換える．*/
    return new Rectangle(x, y, 0, 0, color);
    /* ここまで */
  }
}
