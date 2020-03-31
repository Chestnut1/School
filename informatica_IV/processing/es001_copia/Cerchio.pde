public class Cerchio{
  private float dim;  //diametro del cerchio
  private final static int DIM_DEF = 100;  //dimesione di default del cerchio
  private int x;  //coordinate x e y del centro del cerchio
  private int y;
  private color colore;  //colore di riempimento e del bordo
  private color bordo;
  
  public Cerchio(){
    x = width / 2;
    y = height / 2;
    colore = color(255,255,255);
    bordo = color(0,0,0);
    dim = DIM_DEF;
  }
  
  public void show(){
    stroke(bordo);      //colore bordo
    fill(colore);       //riempimento
    circle(x,y,dim);    //cerchio centrato in x,y
  }
  
  public void setX(int x){
    this.x = x;
  }
  
  public void setY(int y){
    this.y = y;
  }
  
  public void setDim(int dim){
    this.dim = dim;
  }
  
  public void setColor(color colore){
    this.colore = colore;
  }
  
  public color getColor(){
    return colore;
  }
  
  public color getStroke(){
    return bordo;
  }
  
  public int getX(){
    return x;
  }
  
  public int getY(){
    return y;
  }
  
  
  
}
