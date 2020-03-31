public class Temperatura {
    public float celsius;   //celsius degrees
    public float fahrenheit;    //fahrenheit degrees

    public Temperatura(float celsius){
        this.celsius = celsius;
    }

    public float getCelsius() {
        return celsius;
    }

    public void setCelsius(float celsius) {
        this.celsius = celsius;
    }

    public float getFahrenheit() {
        return fahrenheit = (celsius * (9/5)) + 32;
    }

    public String toString() {
        return String.format("%f ° C, %f ° F" , this.celsius, this.fahrenheit);
    }
}
