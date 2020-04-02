import java.util.Vector;

public class Carburante {
    private Vector <Float> prezzi;
    private float media;
    private float max;
    private float min;

    public Carburante(){
        prezzi = new Vector<Float>();
        this.media = 0;
        this.max = 0;
        this.min = 0;
    }

    public void add(float value){
        prezzi.add(value);
    }

    @Override
    public String toString() {
        String out = "|";
        for (float p : prezzi){
            out += String.format("%f|" , p);
        }
        return out;
    }

    public float media(){
        float m = 0;
        if(prezzi.size() == 0) throw new ErroreVettoreVuoto("Media impossibile, zero elementi.");
        for (int i = 0; i < prezzi.size(); i++){
            m += prezzi.elementAt(i);
        }
        return m/prezzi.size();
    }

    public float min(){
        float min;
        if(prezzi.size()>0){
            min = prezzi.elementAt(0);
            for (int i = 1; i < prezzi.size(); i++){
                min = (prezzi.elementAt(i)<min) ? prezzi.elementAt(i): min;
            }
            return min;
        }else{
            throw new ErroreVettoreVuoto("Primo elemento non esistente.");
        }

    }

    public float max(){
        if (prezzi.size() == 0) throw new ErroreVettoreVuoto("Impossibile calcolare max. Vettore uoto.");
        float min = prezzi.elementAt(0);
        for (int i = 1; i < prezzi.size(); i++){
            min = (prezzi.elementAt(i)>min) ? prezzi.elementAt(i): min;
        }
        return min;
    }
}
