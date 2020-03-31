import java.util.Arrays;

public class Porto {
    private final int MAX_POSTI = 100;
    private Posto[] porto = new Posto[MAX_POSTI];
    private float euroAlMetro = 0;
    private int occupati = 0;   //contatore per i posti occupati

    public Porto(float euroAlMetro){
        this.euroAlMetro = (euroAlMetro>0) ? euroAlMetro: 0;
        for(int k = 0; k<MAX_POSTI; k++){
            porto[k] = new Posto();
        }
    }

    public String nomeAffittuario(int k){
        return porto[k].getNomeCliente();
    }

    public float getPrezzo(int k){
        return porto[k].getAffitto();
    }

    public boolean controlla(int k){
        return porto[k].isAffittato();
    }

    public void affittaPosto(int k, Posto p){
        porto[k] = p;
        occupati++;
    }

    @Override
    public String toString() {
        String ret = "";
        for(int i = 0; i<occupati; i++){
            ret = ret + "Posto " + i + String.format("\n") + porto[i].toString() + String.format("\n");
        }
        return ret;
    }
}
