import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.swing.JPanel;

public class Canvas extends JPanel implements VisitorAcceptor {
  private List<Shape> shapes = new ArrayList<>();
  private ShapeFactory factory = new CircleFactory();
  private Color color = new Color(0, 0, 0, 64);
  // undo用にコマンドの履歴を保持する．
  private Deque<Command> commandHistory = new ArrayDeque<>();
  // redo用にundoの履歴を保持する．
  private Deque<Command> undoHistory = new ArrayDeque<>();

  public Canvas() {
    CanvasListener listener = new CanvasListener(this);
    this.addMouseListener(listener);
    this.addMouseMotionListener(listener);
  }

  public void add(Shape shape) {
    this.shapes.add(shape);
    this.repaint();
  }

  public void remove(Shape shape) {
    this.shapes.remove(shape);
    this.repaint();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Shape s : this.shapes) {
      s.draw(g);
    }
  }

  public ShapeFactory getFactory() {
    return this.factory;
  }

  public void setFactory(ShapeFactory factory) {
    this.factory = factory;
  }

  public Color getColor() {
    return this.color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public void execute(Command command) {
    // コマンドを実行する．
    command.execute();
    // コマンド履歴に追加する．
    this.commandHistory.push(command);
    // 一度コマンドを実行したら，redoは無効になる．(undoの履歴をクリアする)
    this.undoHistory.clear();
  }

  public void undo() {
    // コマンド履歴が空かチェックする．
    if (!this.commandHistory.isEmpty()) {
      Command command = this.commandHistory.pop();
      // undoする．
      command.undo();
      // undoの履歴に追加する．
      this.undoHistory.push(command);
    }
  }

  public void redo() {
    if (!this.undoHistory.isEmpty()) {
      Command command = this.undoHistory.pop();
      // redoする．
      command.execute();
      // undoできるように，コマンド履歴に追加する．
      this.commandHistory.push(command);
    }
  }

  public List<Shape> getShapes() {
    /* ここから // shapesのインスタンス変数の値を返す．*/
    return this.shapes;
    ///return null;
    /* ここまで */
  }

  @Override
  public void accept(Visitor visitor) {
    /* ここから */
    visitor.visitCanvas(this);
    /* ここまで */
  }
}
