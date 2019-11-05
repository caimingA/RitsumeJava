import java.awt.Color;

public class CircleFactory extends ShapeFactory {

  @Override
  public Shape create(int x, int y, Color color) {
    /* ここから // 半径が0のCircleのインスタンスを生成してそれを返すように書き換える．*/
    return  new Circle(x, y, 0, color);
    /* ここまで */
  }
}
