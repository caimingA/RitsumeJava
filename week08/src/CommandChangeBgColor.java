import java.awt.Color;

// 発展課題用：背景の色を変えるコマンド
public class CommandChangeBgColor extends Command {
  /* ここから */
  private Canvas canvas;
  private Color prevColor;
  private Color nextColor;
  /* ここまで */

  public CommandChangeBgColor(Canvas canvas, Color nextColor, Color prevColor) {
    /* ここから */
    this.canvas = canvas;
    this.prevColor = prevColor;
    this.nextColor = nextColor;
    /* ここまで */
  }

  @Override
  public void execute() {
    /* ここから */
    this.canvas.setColor(this.nextColor);
    /* ここまで */
  }

  @Override
  public void undo() {
    /* ここから */
    this.canvas.setColor(this.prevColor);
    /* ここまで */
  }
}
