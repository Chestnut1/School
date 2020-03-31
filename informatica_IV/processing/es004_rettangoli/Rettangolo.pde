public class Rettangolo{
  private float x;
  private float y;
  private color fill;
  private color stroke;
  private float l;
  private float h;
  
  public Rettangolo(){
    fill = color(255,255,255);
    stroke = color(0,0,0);
    x = width / 2;
    y = width / 2;
    l = width / 4;
    h = height / 4;
  }
  
  public Rettangolo(float x, float y, float l, float h, color fill, color stroke){
    this.x = x;
    this.y = y;
    this.l = l;
    this.h = h;
    this.fill = fill;
    this.stroke = stroke;
  }
  
  public void setX(float x){
    this.x = x;
  }
  
  public void setY(float y){
    this.y = y;
  }
  
  public void setL(float l){
    this.l = l;
  }
  
  public void setH(float h){
    this.h = h;
  }
  
  public void setColore(color fill){
    this.fill = fill;
  }
  
  public void setStroke(color stroke){
    this.stroke = stroke;
  }
  
  public float getX(){
    return x;
  }
  
  public float getY(){
    return y;
  }
  
  public float getL(){
    return l;
  }
  
  public float getH(){
    return h;
  }
  
  public color getColore(){
    return fill;
  }
  
  public void show(){
    fill(fill);
    stroke(stroke);
    rect(x,y,l,h);
  }
}
