import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ToolButton extends JButton implements ActionListener {
  private Canvas canvas;
  private ShapeFactory factory;

  public ToolButton(String text, ShapeFactory factory, Canvas canvas) {
    super(text);
    this.addActionListener(this);
    this.canvas = canvas;
    this.factory = factory;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    this.canvas.setFactory(this.factory);
  }
}
