import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import javax.swing.JPanel;

public class Canvas extends JPanel {
  private List<Shape> shapes = new ArrayList<>();
  private ShapeFactory factory = new CircleFactory();
  private Color color = new Color(0, 0, 0, 64);
  /* ここから */
//  private List<Shape> shapes = new ArrayList<>();
  private Deque<Command> commandHistory = new ArrayDeque<>();
  private Deque<Command> undoHistory = new ArrayDeque<>();
  /* ここまで */

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
    /* ここから */
    this.shapes.remove(shape);
    this.repaint();
    /* ここまで */
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
    /* ここから */
    command.execute();
    this.commandHistory.push(command);
    /* ここまで */
  }

  public void undo() {
    /* ここから */
    if (!this.commandHistory.isEmpty()) {
      Command command = this.commandHistory.pop();
      command.undo();
    }
    /* ここまで */
  }

  public void redo() {
    /* ここから */
    if (!this.undoHistory.isEmpty()) {
      Command command = this.undoHistory.pop();
      command.execute();
      this.commandHistory.push(command);
    }
    /* ここまで */
  }
}
