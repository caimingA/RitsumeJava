import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    /* ここから 自分の学生証番号と名前を出力する． */
    System.out.println("2600170522-8 CAI Ming");
    /* ここまで */
	
    /* ここから // 発展課題 */
	List<String> texts = new ArrayList<>();
	texts.add("大吉");
	texts.add("吉");
	texts.add("中吉");
	texts.add("小吉");

	int index = (int)(Math.random() * texts.size());
	
	System.out.println("おみくじの結果：" + texts.get(index));
	//System.out.println(texts.get(index));

    /* ここまで */
  }
}
