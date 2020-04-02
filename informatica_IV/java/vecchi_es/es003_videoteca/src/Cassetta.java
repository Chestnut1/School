public class Cassetta {
    private float prezzo;
    private int codice;
    private int durata;
    private int nCopie;
    private String titolo;
    private double sconto;

    public Cassetta(){

    }

    public Cassetta(String titolo, int durata, int codice, int nCopie, double sconto, float prezzo){
        this.titolo = titolo;
        this.prezzo = (prezzo >0) ? prezzo: 2.5f;
        this.durata = (durata>0) ? durata: 60000;
        this.codice = codice;
        this.nCopie = (nCopie>0) ? nCopie: 1;
        this.sconto = (sconto>= 0 && sconto<=100) ? sconto: 0;
    }

    public int codice(){
        return codice;
    }

    public double valore(){
        return (this.prezzo-(this.sconto*100)/this.prezzo)*this.nCopie;
    }

    public int nCopie(){
        return nCopie;
    }

    public double sconto(){
        return sconto;
    }

    public void sconto(double sconto){
        this.sconto = (sconto>= 0 && sconto<=100) ? sconto: 0;
    }

    public String titolo(){
        return this.titolo;
    }

    public int durata(){
        return this.durata;
    }

    public void addCopie(int nCopie){
        this.nCopie += nCopie;
    }

    public void subCopie(int nCopie){
        this.nCopie -= nCopie;
    }
}
