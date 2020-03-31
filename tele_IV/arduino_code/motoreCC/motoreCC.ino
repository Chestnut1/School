const int motore = 5, releA = 6, releB = 7;
int sr = LOW, on = HIGH;

void setup() {
  pinMode(motore, OUTPUT);
  pinMode(releA, OUTPUT);
  pinMode(releB, OUTPUT);
}

void loop() {
  digitalWrite(motore, on);
  digitalWrite(releA, sr);
  digitalWrite(releB, sr);
  
  delay(3000);
  if (sr == HIGH) sr = LOW;
  else sr = HIGH;
}
