public class CD extends Cassetta {
    private int nBrani;

    public CD(String titolo, int durata, int codice, int nCopie, double sconto, float prezzo, int nBrani){
        super(titolo, durata, codice, nCopie, sconto, prezzo);
        this.nBrani = (nBrani>0) ? nBrani: 1;
    }

    public int nBrani(){
        return nBrani;
    }

    public void nBrani(int nbrani){
        this.nBrani = (nBrani>0) ? nBrani: 1;
    }
}
