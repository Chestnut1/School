private Cerchio c;

//imposto la grandezza della finestra
public void settings(){
   size(640,360); 
}

//imposto lo sfondo e istanzio il cerchio
public void setup(){
  background(11, 17, 51);
  c = new Cerchio();  
}

//loop
public void draw(){
  //creo un colore a caso 0..255
  c.setColor(color(random(256),random(256),random(256)));
  c.show();
  delay(500);
  
  //printo nella console il colore
  println("RGB: " ,red(c.getColor())
                  ,green(c.getColor())
                  ,blue(c.getColor())
                
  );
}
