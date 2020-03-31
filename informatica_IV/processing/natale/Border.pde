public class Border {
  //ends of the line
  public PVector a, b;
  
  public Border(PVector a, PVector b) {
    this.a = a;
    this.b = b;
  }
  
  //show the line
  public void show() {
    if (a != null && b != null) line(a.x, a.y, b.x, b.y);
  }
  
}
