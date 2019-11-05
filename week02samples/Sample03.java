import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Sample03 {
  public static void main(String... args) {
    // JFrameのインスタンスを作成する．
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setTitle("Sample03");
    frame.setLocation(10, 10);
    frame.setSize(400, 300);
    // JPanelのインスタンスを作成し，frameに追加する．
    JPanel panel = new JPanel();
    frame.add(panel);
    // 表示する．
    frame.setVisible(true);
  }
}
