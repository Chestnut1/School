public class Fiore{
  //variabili
  private int i = 0;  //variabile per i contatori
  private final int NUM_PETALI = 8;
  
  //creo le componenti del fiore
  private Cerchio pistillo;
  private Rettangolo gambo;
  private Cerchio[] petali = new Cerchio[NUM_PETALI]; 
  
  //definisco i colori del fiore
  private color colorePistillo = color(235, 207, 52);
  private color coloreGambo = color(29, 145, 33);
  private color colorePetali = color(204, 203, 198);
  
  //definisco le grandezze del fiore
  private float dimPetali = 150;
  private float dimPistillo = 120;
  private float lunghezzaGambo = 1000;
  private float larghezzaGambo = 20;
  
  public Fiore(){
    //istanzio il gambo, i petal ed il pistillo
    pistillo = new Cerchio(dimPistillo,colorePistillo);
    
    gambo = new Rettangolo(pistillo.getX()-larghezzaGambo/2, pistillo.getY()+pistillo.getDim()/4, larghezzaGambo, lunghezzaGambo, coloreGambo, color(0,0,0));
    
    for(i = 0; i<NUM_PETALI; i++){
      petali[i] = new Cerchio(dimPetali, colorePetali);
    }
    petali[0].setY(pistillo.getY()-pistillo.getDim()/2);
    petali[1].setX(pistillo.getX()+pistillo.getDim()/4);
    petali[1].setY(pistillo.getY()-pistillo.getDim()/4);
    petali[2].setX(pistillo.getX()+pistillo.getDim()/2);
    petali[3].setX(pistillo.getX()+pistillo.getDim()/4);
    petali[3].setY(pistillo.getY()+pistillo.getDim()/4);
    petali[4].setY(pistillo.getY()+pistillo.getDim()/2);
    petali[5].setX(pistillo.getX()-pistillo.getDim()/4);
    petali[5].setY(pistillo.getY()+pistillo.getDim()/4);
    petali[6].setX(pistillo.getX()-pistillo.getDim()/2);
    petali[7].setX(pistillo.getX()-pistillo.getDim()/4);
    petali[7].setY(pistillo.getY()-pistillo.getDim()/4);
  }
  
  public color getColorePistillo(){
    return pistillo.getColore();
  }
  
  public color getColorePetali(){
    return petali[0].getColore();
  }
  
  public color getColoreGambo(){
    return gambo.getColore();
  }
  
  public float getLunghezzaGambo(){
    return gambo.getH();
  }
  
  public float getLarghezzaGambo(){
    return gambo.getL();
  }
  
  public float getXGambo(){
    return gambo.getX();
  }
  
  public float getYGambo(){
    return gambo.getY();
  }
  
  public float getXPistillo(){
    return pistillo.getX();
  }
  
  public float getYPistillo(){
    return pistillo.getY();
  }
  
  public float getDimPistillo(){
    return pistillo.getDim();
  }
  
  public float getDimPetali(){
    return petali[0].getDim();
  }
  
  public void setColorePistillo(color colore){
    pistillo.setColore(colore);
  }
  
  public void setColorePetali(color colore){
    for(i=0;i<NUM_PETALI;i++){
      petali[i].setColore(colore);
    }
  }
  
  public void setColoreGambo(color colore){
    gambo.setColore(colore);
  }
  
  public void setLunghezzaGambo(float h){
    gambo.setH(h);
  }
  
  public void setLarghezzaGambo(float l){
    gambo.setL(l);
  }
  
  public void setXGambo(float x){
    gambo.setX(x);
  }
  
  public void setYGambo(float y){
    gambo.setY(y);
  }
  
  public void setXPistillo(float x){
    pistillo.setX(x);
  }
  
  public void setYPistillo(float y){
    pistillo.setY(y);
  }
  
  public void setDimPistillo(float dim){
    pistillo.setDim(dim);
  }
  
  public void setDimPetali(float dim){
    for(i=0;i<NUM_PETALI;i++){
      petali[i].setDim(dim);
    }
  }
  
  public void show(){
    gambo.show();
    for(i = 0; i<NUM_PETALI; i++){
      if(i%2==0) petali[i].show();
    }
    for(i=0;i<NUM_PETALI;i++){
      if(i%2!=0) petali[i].show();
    }
    pistillo.show();
  }
}
