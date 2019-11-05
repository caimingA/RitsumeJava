import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Sample02 {
  public static void main(String... args) {
    JFrame frame = new JFrame();

    // ウィンドウのクローズボタンをクリックした時にアプリケーションを終了する．
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    // ウィンドウのタイトルの設定
    frame.setTitle("Sample02");
    // ウィンドウの位置の設定
    frame.setLocation(10, 10);
    // ウィンドウの大きさの設定
    frame.setSize(400, 300);
    // 画面上に表示させる．
    frame.setVisible(true);
  }
}
