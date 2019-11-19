import java.io.PrintWriter;

public abstract class VisitorWriter implements Visitor {
  protected PrintWriter writer;

  public void setWriter(PrintWriter writer) {
    this.writer = writer;
  }
}
