import java.lang.Math;
public class Cerchio {
    private float raggio;

    public Cerchio(){
        this.raggio = 0;
    }

    public Cerchio(float raggio){
        this.raggio = (raggio>=0) ? raggio: 0;
    }

    public float getRaggio() {
        return raggio;
    }

    public float getArea(){
        return (raggio*raggio)*Float.parseFloat("" + Math.PI);
    }

    public float getCirconferenza(){
        return 2*raggio*Float.parseFloat(""+Math.PI);
    }

    public void setRaggio(float raggio){
        this.raggio = (raggio>=0) ? raggio: 0;
    }

    @Override
    public String toString() {
        return "Cerchio{" +
                "raggio=" + raggio + "|area=" + this.getArea() + "|circonferenza=" + this.getCirconferenza() +
                '}';
    }
}
