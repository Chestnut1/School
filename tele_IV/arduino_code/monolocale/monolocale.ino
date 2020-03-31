int bathroomButton = 3;
int roomButton = 2;
int bathroomRele = 5;
int roomRele = 4;

int preBathroom = 0;  //becomes 1 when the previous state of the rele is HIGH
int preRoom = 0;

int k = 0;

//declaration of funtions
void bathroom(){
  if(preBathroom==0){
    digitalWrite(bathroomRele,HIGH);
    preBathroom++;
  }else{
    digitalWrite(bathroomRele,LOW);
    preBathroom--;
  }
  
  //return when stop pressing the button
  while(digitalRead(bathroomButton) == HIGH){
  }
}

void room(){
  if(preRoom==0){
    digitalWrite(roomRele,HIGH);
    preRoom++;
  }else{
    digitalWrite(roomRele,LOW);
    preRoom--;
  }

  //if pressed for 3 seconds turn all off
  for(k = 0; k < 3000 && digitalRead(roomButton)==HIGH; k++){
    delay(1);
  }
  if(k==3000){
    digitalWrite(roomRele,LOW);
    digitalWrite(bathroomRele,LOW);
  }

  //return when stop pressing the button
  while(digitalRead(roomButton) == HIGH){
  }
}

void setup(){
  pinMode(bathroomButton,INPUT);
  pinMode(roomButton,INPUT);
  pinMode(bathroomRele,OUTPUT);
  pinMode(roomRele,OUTPUT);
}

void loop(){
  if(digitalRead(bathroomButton) == HIGH){
    bathroom();
  }
  if(digitalRead(roomButton) == HIGH){
    room();
  }
}
