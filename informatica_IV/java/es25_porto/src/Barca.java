public class Barca {
    private int matricola = 0;  //matricola della barca
    private float dimensione = 0;   //lunghezza della barca
    private int annofabbricazione = 0;

    public Barca(int matricola, float dimensione, int annofabbricazione){
        this.matricola = (matricola>0) ? matricola: 0;
        this.dimensione = (dimensione > 0) ? dimensione: 10;
        this.annofabbricazione = (annofabbricazione > 1200) ? annofabbricazione: 2000;
    }

    public Barca(){
        this.matricola = 0;
        this.dimensione = 10;
        this.annofabbricazione = 2000;
    }

    public int getMatricola() {
        return matricola;
    }

    public float getDimensione() {
        return dimensione;
    }

    public int getAnnofabbricazione() {
        return annofabbricazione;
    }

    //se ha più di 800 anni beh, è una barca d'epoca e non si mette nel porto
    public void setAnnofabbricazione(int annofabbricazione) {
        this.annofabbricazione = (annofabbricazione > 1200) ? annofabbricazione: 2000;
    }

    public void setDimensione(float dimensione) {
        this.dimensione = (dimensione > 0) ? dimensione: 10;
    }

    public void setMatricola(int matricola) {
        this.matricola = (matricola>0) ? matricola: 0;
    }

    @Override
    public String toString() {
        return "Barca{" +
                "matricola=" + matricola +
                ", dimensione=" + dimensione +
                ", annofabbricazione=" + annofabbricazione +
                '}';
    }
}
