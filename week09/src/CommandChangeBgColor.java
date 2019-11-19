import java.awt.*;

public class CommandChangeBgColor extends Command {
  private Canvas canvas;
  private Color nextColor;
  private Color prevColor;

  public CommandChangeBgColor(Canvas canvas, Color nextColor, Color prevColor) {
    this.canvas = canvas;
    this.nextColor = nextColor;
    this.prevColor = prevColor;
  }

  @Override
  public void execute() {
    this.canvas.setBackground(this.nextColor);
  }

  @Override
  public void undo() {
    this.canvas.setBackground(this.prevColor);
  }
}
