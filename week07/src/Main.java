import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Main {
  public static void main(String... args) {
    SwingUtilities.invokeLater(Main::createAndShowGUI);
  }

  public static void createAndShowGUI() {
    try {
      UIManager.setLookAndFeel(
          UIManager.getCrossPlatformLookAndFeelClassName());
    } catch (Exception e) {
      e.printStackTrace();
    }

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    /* ここから // ウィンドウのタイトルを各自の学生証番号と名前にすること */
    frame.setTitle("2600170522-8 CAI Ming");
    /* ここまで */
    frame.setLocation(10, 10);
    // Canvasのインスタンスを作成し，frameに追加する．
    Canvas canvas = new Canvas();
    canvas.setPreferredSize(new Dimension(600, 400));
    frame.add(canvas, BorderLayout.CENTER);
    // toolBarの定義
    JToolBar toolBar = new JToolBar("Tool");
    /* ここから */
    toolBar.add(new ToolButton("Circle", new CircleFactory(), canvas));
    toolBar.add(new ToolButton("Rectangle", new RectangleFactory(), canvas));
    toolBar.add(new ToolButton("Line", new LineFactory(), canvas));
    toolBar.add(new ToolButton("Diamond", new DiamondFactory(), canvas));
    toolBar.add(new ToolButton("Oval", new OvalFactory(), canvas));
    toolBar.add(new ToolButton("Triangle", new TriangleFactory(), canvas));
    toolBar.add(new ToolButton("Star", new StarFactory(), canvas));
    toolBar.add(new ToolButton("Scribble", new ScribbleFactory(), canvas));

    toolBar.addSeparator();

    JButton colorButton = new JButton("Color");
    colorButton.addActionListener((ae) -> {
      Color color = JColorChooser.showDialog(canvas, "Choose Color", canvas.getColor());
      if (color != null) {
        // キャンバスに色を設定する．
        canvas.setColor(color);
      }
    });
    toolBar.add(colorButton);

    toolBar.addSeparator();

    JButton quitButton = new JButton("Quit");
    quitButton.addActionListener((ae) -> {
      System.exit(0);
    });
    toolBar.add(quitButton);

    /* ここまで */
    // toolBarをframeの上部に追加する．
    frame.add(toolBar, BorderLayout.NORTH);
    frame.pack();
    frame.setVisible(true);
  }
}
