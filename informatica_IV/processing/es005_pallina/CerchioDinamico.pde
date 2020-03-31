public class CerchioDinamico extends Cerchio{
  private float speedX;
  private float speedY;
  
  public CerchioDinamico(){
    super();  //super invoca il costruttore della classe soprastante
    speedX = 5;
    speedY = 0;
  }
  
  public void move(){
    setX(getX()+speedX);
    setY(getY()+speedY);
  }
}
