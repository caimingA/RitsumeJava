import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JButton;

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

    /* ここから */
    canvas.add(new ToolButton("Circle", new CircleFactory(), canvas));
    canvas.add(new ToolButton("Rectangle", new RectangleFactory(), canvas));
    canvas.add(new ToolButton("Line", new LineFactory(), canvas));
    /* ここまで */

    /* ここから // 色を設定するボタンを定義する． */
    JButton colorButton = new JButton("Color");
    colorButton.addActionListener((ae) -> {
      Color color = JColorChooser.showDialog(canvas, "Choose Color", canvas.getColor());
      if (color != null) {
        // キャンバスに色を設定する．
        canvas.setColor(color);
      }
    });
    canvas.add(colorButton);
    frame.add(canvas);
    /* ここまで */

    JButton quitButton = new JButton("Quit");
    quitButton.addActionListener((ae) -> {
      System.exit(0);
    });
    canvas.add(quitButton);

    frame.add(canvas);
    frame.setVisible(true);
  }
}
