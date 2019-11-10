public class CommandAdd extends Command {
  /* ここから */
  private Canvas canvas;
  private Shape shape;
  /* ここまで */

  public CommandAdd(Canvas canvas, Shape shape) {
    /* ここから */
    this.canvas = canvas;
    this.shape = shape;
    /* ここまで */
  }

  @Override
  public void execute() {
    /* ここから */
    this.canvas.add(this.shape);
    /* ここまで */
  }

  @Override
  public void undo() {
    /* ここから */
    this.canvas.remove(this.shape);
    /* ここまで */
  }
}
