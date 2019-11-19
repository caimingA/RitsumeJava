import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeReader {
  private Scanner scanner;

  public ShapeReader(Scanner scanner) {
    this.scanner = scanner;
  }

  public Color parseBackground() {
    String token = this.scanner.next();
    if ("Background".equals(token)) {
      return this.parseColor();
    } else {
      throw new ShapeReaderException("Background expected: " + token);
    }
  }

  public List<Shape> parseShapes() {
    List<Shape> shapes = new ArrayList<>();
    while (this.scanner.hasNext()) {
      shapes.add(parseShape());
    }
    return shapes;
  }

  private Shape parseShape() {
    String token = this.scanner.next();
    if ("Circle".equals(token)) {
      return this.parseCircle();
    } else if ("Rectangle".equals(token)) {
      return this.parseRectangle();
    } else if ("Line".equals(token)) {
      return this.parseLine();
    } else {
      throw new ShapeReaderException("Unrecognized command: " + token);
    }
  }

  private Circle parseCircle() {
    int x = this.parseInt();
    int y = this.parseInt();
    int r = this.parseInt();
    Color color = this.parseColor();
    return new Circle(x, y, r, color);
  }

  private Rectangle parseRectangle() {
    /* ここから // Rectangleを返す．*/
    int left = this.parseInt();
    int top = this.parseInt();
    int width = this.parseInt();
    int height = this.parseInt();
    Color color = this.parseColor();
    return new Rectangle(left, top, width, height, color);
    /* null を置き換えること */
    /* ここまで */
  }

  private Line parseLine() {
    /* ここから // Lineを返す． */
    int x1 = this.parseInt();
    int y1 = this.parseInt();
    int x2 = this.parseInt();
    int y2 = this.parseInt();
    Color color = this.parseColor();
    return new Line(x1, y1, x2, y2, color);
    /* null を置き換えること */
    /* ここまで */
  }

  private int parseInt() {
    return this.scanner.nextInt();
  }

  private Color parseColor() {
    int color = this.parseInt();
    return new Color(color, true);
  }
}
