int pinAvanti = 3;
int pinIndietro = 4;
int pinSu = 6;
int pinGiu = 5;

int fotoSX = A0;
int fotoDX = A1;
int corsaBasso = A2;
int corsaAlto = A3;

int start = 2;
int reset = 7;

bool acceso = false;
bool giu = false;
bool su = false;
bool indietro = false;

void setup() {
  pinMode(pinAvanti, OUTPUT);
  pinMode(pinIndietro, OUTPUT);
  pinMode(pinSu, OUTPUT);
  pinMode(pinGiu, OUTPUT);
  pinMode(fotoSX, INPUT);
  pinMode(fotoDX, INPUT);
  pinMode(corsaBasso, INPUT);
  pinMode(corsaAlto, INPUT);
  pinMode(start, INPUT);
  Serial.begin(9600);
}

void loop() {
  if(digitalRead(start) == HIGH){
    Serial.print("partito");
    acceso = true;  //accendo
  }
  
  if(acceso){
    if(analogRead(fotoSX) <500){  //AVANTI
      digitalWrite(pinIndietro,LOW);
      digitalWrite(pinAvanti,HIGH);
    }
    
    if(analogRead(fotoDX) <500 && !giu){  //GIU'
      giu = true;
      digitalWrite(pinAvanti,LOW);
      digitalWrite(pinSu, LOW);
      digitalWrite(pinGiu,HIGH);
    }

    if(analogRead(corsaBasso<500) && giu){  //A FINE CORSA VA SU
      giu = false;
      digitalWrite(pinGiu, LOW);
      digitalWrite(pinSu,HIGH);
      su = true;
    }

    if(analogRead(corsaAlto<500) && su){  //A FINE CORSE TORNA INDIETRO
      su = false;
      digitalWrite(pinGiu, LOW);
      digitalWrite(pinSu,LOW);
      indietro = true;
    }

    if(analogRead(fotoDX<500) && indietro){
      digitalWrite(pinAvanti,LOW);
      digitalWrite(pinIndietro,HIGH);
      indietro = false;
    }
    if(digitalRead(reset) == HIGH){
      if(pinSu == HIGH) pinSu = LOW;
      if(pinGiu == HIGH) pinGiu = LOW;
      bool s = false;
      while(analogRead(fotoSX) > 800 && !s){
        if(analogRead(fotoSX)<500){
          pinAvanti = LOW;
          pinIndietro = HIGH;
          s = true;
        }
      }
    }
  }
  
}
