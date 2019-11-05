import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(new Color(255, 0, 0, 64));
    g.fillRect(10, 10, 100, 50);
    g.setColor(new Color(0, 255, 0, 64));
    g.fillOval(200, 10, 100, 50);
    g.setColor(new Color(0, 0, 255, 64));
    g.drawLine(10, 10, 300, 60);
  }
}
