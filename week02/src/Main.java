import java.awt.Color;
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
    frame.setSize(600,400);
    // Canvasのインスタンスを作成する．
    Canvas canvas = new Canvas();
    /* ここから */
    Circle c1 = new Circle((int)(Math.random() * 500 - 100) + 100, (int)(Math.random() * 300 - 100) + 100, (int)(Math.random() * 100), new Color(255, 0, 0, 100));
    canvas.add(c1);
    Circle c2 = new Circle((int)(Math.random() * 500 - 100) + 100, (int)(Math.random() * 300 - 100) + 100, (int)(Math.random() * 100), new Color(0, 255, 0, 100));
    canvas.add(c2);
    Circle c3 = new Circle((int)(Math.random() * 500 - 100) + 100, (int)(Math.random() * 300 - 100) + 100, (int)(Math.random() * 100), new Color(0, 0, 255, 100));
    canvas.add(c3);

    /* ここまで */
    /* ここから // 発展課題 */
    Rectangle r1 = new Rectangle((int)(Math.random() * 500), (int)(Math.random() * 300), (int)(Math.random() * 100), (int)(Math.random() * 100), new Color(255, 0, 0, 100));
    canvas.addRect(r1);
    Rectangle r2 = new Rectangle((int)(Math.random() * 500), (int)(Math.random() * 300), (int)(Math.random() * 100), (int)(Math.random() * 100), new Color(0, 255, 0, 100));
    canvas.addRect(r2);
    Rectangle r3 = new Rectangle((int)(Math.random() * 500), (int)(Math.random() * 300), (int)(Math.random() * 100), (int)(Math.random() * 100), new Color(0, 0, 255, 100));
    canvas.addRect(r3);

    /* ここまで */
    frame.add(canvas);
    frame.setVisible(true);
  }
}
