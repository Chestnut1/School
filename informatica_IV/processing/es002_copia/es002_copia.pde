private Cerchio c;

public void settings(){
  size(1920,1080);
}

public void setup(){
  c = new Cerchio();
  background(143, 44, 123);
}

public void draw(){
  //randomizzo il colore 0..255, le coordinate 0..width+1 e 0..height+1 e la dimesione del cerchio 2..100
  c.setColor(color(random(256),random(256),random(256)));
  c.setX(random(width+1));
  c.setY(random(height+1));
  c.setDim(random(1000));
  c.show();
  
  delay(200);
}
