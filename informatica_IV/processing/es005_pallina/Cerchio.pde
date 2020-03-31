public class Cerchio{
  private static final int DIM_DEF = 30;  //dimesione di default
  private float dim;  //diametro delcerchio
  private float x;  //coordiante x e y
  private float y;
  private color colore;  //colore rimepimento e del bordo
  private color bordo;
  
  public Cerchio(){
    dim = DIM_DEF;
    //imposto di default il colore bianco ed il bordo nero
    colore = color(255,255,255);
    bordo = color(0,0,0);
    x = width / 2;
    y = height / 2;
  }
  
  public Cerchio(float dim, color fill){
    this.dim = dim;
    colore = fill;
    bordo = color(0,0,0);
    x = width / 2;
    y = height / 2;
  }
  
  public void setX(float x){
    this.x = x;
  }
  
  public void setY(float y){
    this.y = y;
  }
  
  public void setColore(color colore){
    this.colore = colore;
  }
  
  public void SetStroke(color bordo){
    this.bordo = bordo;
  }
  
  public void setDim(float dim){
    this.dim = dim;
  }
  
  public float getX(){
    return x;
  }
  
  public float getY(){
    return y;
  }
  
  public color getColore(){
    return colore;
  }
  
  public color getStroke(){
    return bordo;
  }
  
  public float getDim(){
    return dim;
  }
  
  public void show(){
    fill(colore);
    stroke(bordo);
    circle(x,y,dim);
  }
}
