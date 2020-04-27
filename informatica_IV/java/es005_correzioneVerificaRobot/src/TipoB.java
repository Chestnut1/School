public class TipoB extends Robot{
    private int numPuntiSec;

    public TipoB(String nome, float costoSec, Processore cpu, Memoria banco, int numPuntiSec) throws ValoreNonValido {
        super(nome, costoSec, cpu, banco);
        if(numPuntiSec > 0) this.numPuntiSec = numPuntiSec;
        else throw new ValoreNonValido("Il numero di punto al secondo non puo' essere negativo");
    }

    public int getNumPuntiSec() {
        return numPuntiSec;
    }

    public void setNumPuntiSec(int numPuntiSec) throws ValoreNonValido {
        if(numPuntiSec > 0) this.numPuntiSec = numPuntiSec;
        else throw new ValoreNonValido("Il numero di punto al secondo non puo' essere negativo");
    }
}
