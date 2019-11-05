import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main {
  public static void main(String... args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    /* ここから // ウィンドウのタイトルを各自の学生証番号と名前にすること */
    frame.setTitle("2600170522-8 CAI Ming ");
    /* ここまで */
    frame.setLocation(10, 10);
    frame.setSize(600, 400);
    // Canvasのインスタンスを作成する．
    Canvas canvas = new Canvas();
    /* ここから // canvasに図形を追加する． */
    int numCircle = (int) (Math.random() * 3) + 1;
    int numRectangle = (int) (Math.random() * 3) + 1;
    int numLine = (int) (Math.random() * 3) + 1;
    System.out.println(numCircle);
    System.out.println(numRectangle);
    System.out.println(numLine);
    for(int i = 0; i < numCircle; i++){
      canvas.add(new Circle((int)(Math.random() * 500 - 100) + 100
                          , (int)(Math.random() * 300 - 100) + 100
                          , (int)(Math.random() * 100)
                          , new Color((int) (Math.random() * 256)
                                    , (int) (Math.random() * 256)
                                    , (int) (Math.random() * 256)
                                    , (int) (Math.random() * 100) + 156
                                    )
                          )
                );
    }
    for(int i = 0; i < numRectangle; i++){
      canvas.add(new Rectangle((int)(Math.random() * 500)
                            , (int)(Math.random() * 300)
                            , (int)(Math.random() * 100)
                            , (int)(Math.random() * 100)
                            , new Color((int) (Math.random() * 256)
                                      , (int) (Math.random() * 256)
                                      , (int) (Math.random() * 256)
                                      , (int) (Math.random() * 100) + 156
                                      )
                            )
      );
    }
    for(int i = 0; i < numLine; i++){
      canvas.add(new Line((int) (Math.random() * 100)
                        , (int) (Math.random() * 400)
                        , (int) (Math.random() * 100) + 500
                        , (int) (Math.random() * 400)
                        , new Color((int) (Math.random() * 256)
                                  , (int) (Math.random() * 256)
                                  , (int) (Math.random() * 256)
                                  , (int) (Math.random() * 100) + 156
              )
              )
      );
    }
    /* ここまで */
    frame.add(canvas);
    frame.setVisible(true);
  }
}
