public interface Visitor {
  void visitCanvas(Canvas canvas);

  void visitCircle(Circle circle);

  void visitRectangle(Rectangle rectangle);

  void visitLine(Line line);
  // 図形の種類を増やす時にはそれぞれのクラスに対応したメソッドの宣言を追加する．
}
