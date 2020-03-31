private Cerchio c;
private int nCerchi;  //NON INSERIRE NUMERI PRIMI, SE NO APPAIONO MADONNE
private int nColonne = 0;
private int nRighe = 0;
int k = 0;

public void settings(){
  size(640,480);
}

public void setup(){
  c = new Cerchio();
  nCerchi = 150;
  nRighe = 0;
  nColonne = 0;
  background(143, 44, 123);
  
  //scompongo in fattori il numero di cerchi per ottenre numero di righe e colonne
  while(nCerchi>1){
     if(nCerchi % 7 == 0){
       if(k==0){
         nColonne += 7;
         k++;
       }else{
         nRighe += 7;
         k--;
       }
       nCerchi = nCerchi / 7;
     }
     if(nCerchi % 5 == 0){
       if(k==0){
         nColonne += 5;
         k++;
       }else{
         nRighe += 5;
         k--;
       }
       nCerchi = nCerchi / 5;
     }
     if(nCerchi % 3 == 0){
       if(k==0){
         nColonne += 3;
         k++;
       }else{
         nRighe += 3;
         k--;
       }
       nCerchi = nCerchi / 3;
     }
     if(nCerchi % 2 == 0){
       if(k==0){
         nColonne += 2;
         k++;
       }else{
         nRighe += 2;
         k--;
       }
       nCerchi = nCerchi / 2;
     }
  }
  
}

public void draw(){
  int riga;  //variabili per 
  int colonna;
  int spaziaturaX = 0;  //spazio tra una pallina e l'altra
  int spaziaturaY = 0;
  int xCentro = width / 2;  //coordinate del centro
  int yCentro = height / 2;
  
  spaziaturaX = width / (nColonne +1);
  spaziaturaY = height / (nRighe +1);
  println(spaziaturaX, spaziaturaY);
  println(nColonne, nRighe);
  
  
  c.setY(yCentro - (nRighe / 2)*spaziaturaY);
  c.setX(xCentro - (nColonne / 2)*spaziaturaX);
  
  
  for(riga = 0; riga < nRighe ; riga++){
    c.setX(xCentro - (nColonne / 2)*spaziaturaX);
    c.setY(yCentro - (nRighe / 2)*spaziaturaY + spaziaturaY*riga );
    for(colonna = 0; colonna < nColonne ; colonna++){
      c.show();
      c.setX(c.getX() + spaziaturaX);
      
    }
  }
  
}
