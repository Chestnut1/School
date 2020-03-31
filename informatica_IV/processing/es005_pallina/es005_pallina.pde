private CerchioDinamico pallina = new CerchioDinamico();


public void settings(){
  size(2000,1600);
}

public void setup(){
  background(0,0,0);
}

public void draw(){
  background(255,255,255);
  pallina.show();
  pallina.move();
  if(pallina.getX()>width+pallina.getDim()) pallina.setX(0-pallina.getDim());
  println(pallina.getX() + " " + pallina.getY());
  
}
