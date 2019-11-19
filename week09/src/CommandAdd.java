public class CommandAdd extends Command {
  private Canvas canvas;
  private Shape shape;

  public CommandAdd(Canvas canvas, Shape shape) {
    this.canvas = canvas;
    this.shape = shape;
  }

  @Override
  public void execute() {
    this.canvas.add(this.shape);
  }

  @Override
  public void undo() {
    this.canvas.remove(this.shape);
  }
}
