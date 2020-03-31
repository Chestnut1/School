public class Snowflake {

  private PVector pos, speed;
  private float r;
  
  public Snowflake(float x, float y, float sx, float sy, float r) {
    this.pos = new PVector(x, y);
    this.speed = new PVector(sx, sy);
    this.r = r;
  }
  
  public void show() {
    noStroke();
    fill(255, 100);
    ellipse(pos.x, pos.y, this.r, this.r);
    stroke(0);
  }
  
  public void fall() {
    this.pos.add(this.speed); 
  }
  
  public void teleport(float x, float y) {
    this.pos = new PVector(x, y); 
  }
  
  public PVector pos() {
    return this.pos;
  }
  
  public Boolean interseption(Border b) {
  
    double ap = Math.sqrt(Math.pow(this.pos.x - b.a.x, 2) + Math.pow((this.pos.y - b.a.y), 2));
    double bp = Math.sqrt(Math.pow(this.pos.x - b.b.x, 2) + Math.pow((this.pos.y - b.b.y), 2));
    double ab = Math.sqrt(Math.pow(b.a.x - b.b.x, 2) + Math.pow((b.a.y - b.b.y), 2));
    
    double epsilon = 1;
    
    return Math.abs(ap + bp - ab) < epsilon;
    
  }
  
}
