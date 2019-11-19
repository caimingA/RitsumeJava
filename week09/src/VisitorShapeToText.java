import java.awt.Color;

public class VisitorShapeToText extends VisitorWriter {

  @Override
  public void visitCanvas(Canvas canvas) {
    // まず背景の色を書き出す
    this.writer.printf("Background %d%n", canvas.getBackground().getRGB());
    for (Shape shape : canvas.getShapes()) {
      shape.accept(this);
      this.writer.println();
    }
    this.writer.flush();
  }

  private void writeColor(Shape shape) {
    Color color = shape.getColor();
    this.writer.printf(" %d", color.getRGB());
  }

  @Override
  public void visitCircle(Circle circle) {
    /* ここから */
    this.writer.printf("Circle %d %d %d"
            , circle.getX()
            , circle.getY()
            , circle.getR()
    );
    this.writeColor(circle);
    /* ここまで */
  }

  @Override
  public void visitRectangle(Rectangle rectangle) {
    /* ここから */
    this.writer.printf("Rectangle %d %d %d %d"
            , rectangle.getLeft()
            , rectangle.getTop()
            , rectangle.getWidth()
            , rectangle.getHeight()
    );
    this.writeColor(rectangle);
    /* ここまで */
  }

  @Override
  public void visitLine(Line line) {
    /* ここから */
    this.writer.printf("Line %d %d %d %d"
            , line.getX1()
            , line.getY1()
            , line.getX2()
            , line.getY2());
    this.writeColor(line);
    /* ここまで */
  }
}
