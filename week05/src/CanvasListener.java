import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CanvasListener extends MouseAdapter {
  private Canvas canvas;
  private Shape shape;

  public CanvasListener(Canvas canvas) {
    /* ここから */
    this.canvas = canvas;
    /* ここまで */
  }

  @Override
  // マウスボタンが押された時に図形を作成する．
  public void mousePressed(MouseEvent me) {
    /* ここから */
    ShapeFactory factory = this.canvas.getFactory();
    int x = me.getX();
    int y = me.getY();
    Color color = this.canvas.getColor();
    this.shape = factory.create(x, y, color);
    this.canvas.add(shape);
    /* ここまで */
  }

  @Override
  // マウスのドラッグに応じて大きさを変える．
  public void mouseDragged(MouseEvent me) {
    /* ここから */
    int x = me.getX();
    int y = me.getY();
    this.shape.resizeTo(x, y);
    this.canvas.repaint();
    /* ここまで */
  }

  @Override
  // 図形の大きさが確定される．
  // 直前のmouseDraggedのイベントからマウスの位置が変わらないので特にするべきことはない．
  public void mouseReleased(MouseEvent me) {
  }
}
