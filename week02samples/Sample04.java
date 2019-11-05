import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Sample04 {
  public static void main(String... args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setTitle("Sample04");
    frame.setLocation(10, 10);
    frame.setSize(400, 300);
    // JPanelを継承したクラス(MyPanel)のインスタンスを作成し，frameに追加する．
    frame.add(new MyPanel());
    // 表示する．
    frame.setVisible(true);
  }
}
