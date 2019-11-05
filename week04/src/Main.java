import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
  public static void main(String... args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    /* ここから // ウィンドウのタイトルを各自の学生証番号と名前にすること */
    frame.setTitle("2600170522-0 CAI Ming");
    /* ここまで */
    frame.setLocation(10, 10);
    frame.setSize(600, 400);
    // Canvasのインスタンスを作成する．
    Canvas canvas = new Canvas();
    /* ここから // ファクトリと色をcanvasから取り出して図形を生成してcanvasに追加する． */
    for(int i = 0; i < 10; i++){
      ShapeFactory factory = canvas.getFactory();
      Color color = canvas.getColor();
      Shape shape = factory.create((int)(Math.random() * 500), (int)(Math.random() * 300), color);
      canvas.add(shape);
    }
    /* ここまで */
    frame.add(canvas);
    frame.setVisible(true);
  }
}
