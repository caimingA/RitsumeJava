import java.awt.Color;

public class VisitorShapeToSVG extends VisitorWriter {

  @Override
  public void visitCanvas(Canvas canvas) {
    // SVG の書き出しの準備
    this.writer.println("<?xml version=\"1.0\"?>");
    this.writer.println("<svg xmlns=\"http://www.w3.org/2000/svg\">");
    // backgroundを設定する．
    this.writer.printf("<rect width=\"100%%\" height=\"100%%\" fill=\"%s\"",
        this.colorToRGBA(canvas.getBackground()));
    this.writer.println("/>");
    // キャンバスから図形の一覧を取得し，順番にビジターを適用する．
    for (Shape shape : canvas.getShapes()) {
      shape.accept(this);
    }
    // SVGの閉じタグを出力する．
    this.writer.println("</svg>");
    this.writer.flush();
  }

  // Colorをrgba(...)の文字列に変換する．
  private String colorToRGBA(Color color) {
    return String.format("rgba(%d,%d,%d,%f)",
        color.getRed(), color.getGreen(), color.getBlue(),
        color.getAlpha() / 255.0);
  }

  // fillの色を指定する．strokeは無しにする．
  private void writeFillColor(Shape shape) {
    this.writer.printf(" stroke=\"none\" fill=\"%s\"",
        this.colorToRGBA(shape.getColor()));
  }

  // strokeの色を指定する．fillは無しにする．
  private void writeStrokeColor(Shape shape) {
    this.writer.printf(" fill=\"none\" stroke=\"%s\"",
        this.colorToRGBA(shape.getColor()));
  }

  @Override
  public void visitCircle(Circle circle) {
    // 例 <circle cx="10" cy="20" r="30"/>
    /* ここから */
    this.writer.printf("<circle cx=\"%d\" cy=\"%d\" r=\"%d\""
            , circle.getX()
            , circle.getY()
            , circle.getR());
    this.writeFillColor(circle);
    this.writer.println("/>");
    /* ここまで */
  }

  @Override
  public void visitRectangle(Rectangle rectangle) {
    // 例 <rect x="10" y="20" width="400" height="300"/>
    /* ここから */
    this.writer.printf("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\""
            , rectangle.getLeft()
            , rectangle.getTop()
            , rectangle.getWidth()
            , rectangle.getHeight());
    this.writeFillColor(rectangle);
    this.writer.println("/>");
    /* ここまで */
  }

  @Override
  public void visitLine(Line line) {
    // 例 <line x1="10" y1="20" x2="30" y2="40"/>
    /* ここから */
    this.writer.printf("<line x1=\"%d\" y1=\"%d\" x2=\"%d\" y2=\"%d\""
            , line.getX1()
            , line.getY1()
            , line.getX2()
            , line.getY2());
    this.writeStrokeColor(line);
    this.writer.println("/>");
    /* ここまで */
  }
}
