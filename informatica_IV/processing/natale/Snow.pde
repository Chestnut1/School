public class Snow{
  private int snowflakes;  //numero di fiocchi di neve
  private final int MAX_SNOW = 1000;
  private final int MIN_SNOW = 150;
  Snowflake[] snowFall;
  
  
  //funzione che disegna fiocchi di neve sullo schermo
  public Snow(int snowflakes){
    this.snowflakes = (snowflakes >= MIN_SNOW && snowflakes <= MAX_SNOW) ? snowflakes: MIN_SNOW;
    
    //creo il vettore di fiocchi e li istanzio
    snowFall = new Snowflake[this.snowflakes];
    for(int i = 0; i < this.snowflakes; i++){
      snowFall[i] = new Snowflake(random(0, width), random(-height, 0), random(-3, 3), random(1, 10), random(0, 10));
    }
  }
  
  //funzione che fa cadere i fiocchi
  public void letItSnow(Vector<Border> b) {
    for(int i = 0; i < snowflakes; i++){
      
      Boolean intercept = false;
      Iterator it = b.iterator();
      while(it.hasNext() && !intercept) {
        Border bb = (Border) it.next(); 
        intercept = snowFall[i].interseption(bb);
      }
      
      //decremneto x e y
      snowFall[i].show();
      
      if (!intercept) snowFall[i].fall();
      
      //se sono fuori dallo schermo i fiocchi ricompaiono in alto 
      if(snowFall[i].pos().y > height){
        snowFall[i].teleport(snowFall[i].pos().x, random(-height, 0));
      }
      if(snowFall[i].pos().x > width || snowFall[i].pos().x < 0){
        snowFall[i].teleport(random(0, width), snowFall[i].pos().y);
      }
    }
  }
  
}
