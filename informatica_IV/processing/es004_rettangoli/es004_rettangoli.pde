public float xSky;                  //colore cielo  -> (41, 45, 128) 41 fino a 112
public float ySky;
public Rettangolo sky;
public Fiore margherita;
public color skyColor = color(41, 45, 128);

public void settings(){
  size(1000,800);
}

public void setup(){
  background(29, 145, 33);
  xSky = 0;
  ySky = 0;
  sky = new Rettangolo(xSky,ySky,width,height - (height * 0.30),color(41, 45, 128),color(41, 45, 128));
  sky.show();
  margherita = new Fiore();
}

public void draw(){
  margherita.show();
  //margherita.setColorePetali(color(255,0,0));
}
