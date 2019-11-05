import java.awt.Color;

public class CircleFactory extends ShapeFactory {

  @Override
  public Shape create(int x, int y, Color color) {
    /* ここから // Circleのインスタンスを生成してそれを返すように書き換える．*/
    return new Circle(x, y , (int)(Math.random() * 100), color);
    /* ここまで */
  }
}
