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
    JToolBar toolBar = new JToolBar("Menu");
    toolBar.add(new ToolButton("Circle", new CircleFactory(), canvas));
    toolBar.add(new ToolButton("Rectangle", new RectangleFactory(), canvas));
    toolBar.add(new ToolButton("Line", new LineFactory(), canvas));
    // セパレータを入れる．
    toolBar.addSeparator();
    // 色の選択
    JButton colorButton = new JButton("Color");
    colorButton.addActionListener((ae) -> {
      Color color = JColorChooser.showDialog(frame, "Choose Color", canvas.getColor());
      if (color != null) {
        // 生成する図形の色をキャンバスに登録する．
        canvas.setColor(color);
      }
    });
    toolBar.add(colorButton);
    // セパレータを入れる．
    toolBar.addSeparator();
    // 発展課題用：canvasの背景の色を変える．
    JButton bgColorButton = new JButton("Bg Color");
    bgColorButton.addActionListener((ae) -> {
      // 現在の背景色を取得する．
      Color prevColor = canvas.getBackground();
      // ColorChooserを使って色を選択させる．
      Color color = JColorChooser.showDialog(frame, "Choose Background Color", prevColor);
      if (color != null) {
        // 背景の下は透けて見えない様にするため，色の透明度は0（アルファ値は255）にする．
        Color nextColor = new Color(color.getRed(), color.getGreen(), color.getBlue());
        // 背景の色を設定する．
        /* ここから // 発展課題ではCommandパターンを使ってUndo/Redoができるようにする． */
        canvas.setBackground(nextColor);
        /* ここまで */
      }
    });
    toolBar.add(bgColorButton);
    toolBar.addSeparator();
    /* ここから // Undo/Redoボタン  */
    JButton undoButton = new JButton("Undo");
    undoButton.addActionListener((ae) -> canvas.undo());
    toolBar.add(undoButton);
    JButton redoButton = new JButton("Redo");
    redoButton.addActionListener((ae) -> canvas.redo());
    toolBar.add(redoButton);
    /* ここまで */
    JButton quitButton = new JButton("Quit");
    quitButton.addActionListener((ae) -> System.exit(0));
    toolBar.add(quitButton);
    frame.add(toolBar, BorderLayout.NORTH);
    frame.pack();
    frame.setVisible(true);
  }
}
