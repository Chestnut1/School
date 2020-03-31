int pinAvanti = 3;
int pinIndietro = 4;

int fotoSX = A0;
int fotoDX = A1;

int start = 2;

bool acceso = false;

int direzione = 0;  //0 avanti, 1 indietro

void setup() {
  pinMode(pinAvanti, OUTPUT);
  pinMode(pinIndietro, OUTPUT);
  pinMode(fotoSX, INPUT);
  pinMode(fotoDX, INPUT);
  pinMode(start, INPUT);
}

void loop() {
  if(digitalRead(start) == HIGH) acceso = true;  //accendo spengo
  if(acceso){
    if(analogRead(fotoDX) <800){  //INDIETRO
      digitalWrite(pinAvanti,LOW);
      digitalWrite(pinIndietro,HIGH);
    }
    if(analogRead(fotoSX) <800){  //AVANTI
      digitalWrite(pinIndietro,LOW);
      digitalWrite(pinAvanti,HIGH);
    }
  }
  
}
