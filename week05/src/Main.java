import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
  public static void main(String... args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    /* ここから // ウィンドウのタイトルを各自の学生証番号と名前にすること */
    frame.setTitle("2600170522-8 CAI Ming");
    /* ここまで */
    frame.setLocation(10, 10);
    frame.setSize(600, 400);
    // Canvasのインスタンスを作成し，frameに追加する．
    Canvas canvas = new Canvas();
    frame.add(canvas);
    frame.setVisible(true);
  }
}
