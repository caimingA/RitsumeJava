import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ToolButton extends JButton implements ActionListener {
  private Canvas canvas;
  private ShapeFactory factory;

  public ToolButton(String text, ShapeFactory factory, Canvas canvas) {
    /* ここから */
    super(text);
    this.addActionListener(this);
    this.canvas = canvas;
    this.factory = factory;
    /* ここまで */
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    /* ここから */
    this.canvas.setFactory(this.factory);
    /* ここまで */
  }
}
