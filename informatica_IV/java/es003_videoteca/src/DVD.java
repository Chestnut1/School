public class DVD extends Cassetta{
    private int nLingue;

    public DVD(String titolo, int durata, int codice, int nCopie, double sconto, float prezzo, int nLingue){
        super(titolo, durata, codice, nCopie, sconto, prezzo);
        this.nLingue = (nLingue>0 && nLingue<6) ? nLingue: 1;
    }

    public int nLinuge(){
        return nLingue;
    }



}
