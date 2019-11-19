import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class WriteButton extends JButton implements ActionListener {
  private Canvas canvas;
  private VisitorWriter visitor;
  private JFileChooser chooser;

  public WriteButton(String text, VisitorWriter visitor, JFileChooser chooser, Canvas canvas) {
    super(text);
    this.addActionListener(this);
    this.visitor = visitor;
    this.chooser = chooser;
    this.canvas = canvas;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    int returnVal = this.chooser.showSaveDialog(this.canvas);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      File file = this.chooser.getSelectedFile();
      try (PrintWriter writer = new PrintWriter(file)) {
        this.visitor.setWriter(writer);
        this.canvas.accept(this.visitor);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(this.canvas, e.getMessage(), "Error: " + e.getClass().getName(), JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
      }
    }
  }
}
