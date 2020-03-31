void setup() {
  // put your setup code here, to run once:
  pinMode(13,OUTPUT);
  pinMode(24,INPUT);
  Serial.begin(9600);
}

void loop() {
  // put your main code here, to run repeatedly:
  bool statoPulsante = !digitalRead(14);
  digitalWrite(13,statoPulsante);
  Serial.println(statoPuslsante);
}
