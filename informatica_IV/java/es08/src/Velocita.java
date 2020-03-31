public class Velocita {
    private float velKmh;  //velocità

    public Velocita(){
        this.velKmh = 0;
    }

    public float getVelMs() {
        return velKmh/3.6f;
    }

    public float getVelKmh() {
        return velKmh;
    }

    public void setVelKmh(float vel) {
        this.velKmh = (vel>0) ? vel: 0;
    }

    public void setVelMs(float vel) {
        this.velKmh = (vel>0) ? vel*3.6f: 0;
    }

    public String toString(){
        return String.format("Km/h: %.2f | m/s: %.2f" , velKmh, (velKmh/3.6));
    }
}
