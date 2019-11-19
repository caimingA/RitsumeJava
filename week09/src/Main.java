import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    JToolBar toolBar = new JToolBar("Tool");
    toolBar.add(new ToolButton("Circle", new CircleFactory(), canvas));
    toolBar.add(new ToolButton("Rectangle", new RectangleFactory(), canvas));
    toolBar.add(new ToolButton("Line", new LineFactory(), canvas));
    // セパレータを入れる．
    toolBar.addSeparator();
    // ColorChooser
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
        Command command = new CommandChangeBgColor(canvas, nextColor, prevColor);
        canvas.execute(command);
      }
    });
    toolBar.add(bgColorButton);
    // セパレータを入れる．
    toolBar.addSeparator();
    // undo/redo
    JButton undoButton = new JButton("Undo");
    undoButton.addActionListener((ae) -> canvas.undo());
    toolBar.add(undoButton);
    JButton redoButton = new JButton("Redo");
    redoButton.addActionListener((ae) -> canvas.redo());
    toolBar.add(redoButton);
    // セパレータを入れる．
    toolBar.addSeparator();
    /* ここから // ファイルへの書き出し用のボタンを追加する． */
    JFileChooser chooser = new JFileChooser();
    toolBar.add(new WriteButton("Write", new VisitorShapeToText(), chooser, canvas));
    toolBar.add(new WriteButton("SVG", new VisitorShapeToSVG(), chooser, canvas));
    /* ここまで */
    /* ここから // ファイルから読み込み用のボタンを追加する． */
    JButton readButton = new JButton("Read");
    readButton.addActionListener((ae) -> {
      int returnVal = chooser.showOpenDialog(canvas);
      if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = chooser.getSelectedFile();
        try (Scanner scanner = new Scanner(file)) {
          ShapeReader reader = new ShapeReader(scanner);
          Color bgColor = reader.parseBackground();
          List<Shape> shapes = reader.parseShapes();
          Command command = new CommandChangeBgColor(canvas, bgColor, canvas.getBackground());
          canvas.execute(command);
          for (Shape shape: shapes) {
            Command cd = new CommandAdd(canvas, shape);
            canvas.execute(cd);
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
    /* ここまで */
    JButton quitButton = new JButton("Quit");
    quitButton.addActionListener((ae) -> System.exit(0));
    toolBar.add(quitButton);
    frame.add(toolBar, BorderLayout.NORTH);
    frame.pack();
    frame.setVisible(true);
  }
}
