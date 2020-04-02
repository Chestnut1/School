public class VagoneMerci extends Vagone {
    private int volumeCarico;
    private int pesoMax;
    private int pesoEffettivo;

    public VagoneMerci(String codice, String aziendaCostruttrice, int pesoVuoto, int annoCostruzione, int volumeCarico, int pesoMax, int pesoEffettivo) throws ErroreValoreNonValido {
        super(codice, aziendaCostruttrice, pesoVuoto, annoCostruzione);

        if(pesoMax>0)this.pesoMax = pesoMax;
        else throw new ErroreValoreNonValido("Peso massimo non valido");

        if(pesoEffettivo>0)this.pesoEffettivo = pesoEffettivo;
        else throw new ErroreValoreNonValido("Peso effettivo non valido");
    }

    private void carica(int peso) throws ErroreValoreNonValido {
        if (peso + pesoEffettivo <= pesoMax) pesoEffettivo += peso;
        else throw new ErroreValoreNonValido("Peso massimo superato.");
    }

    public void scarica(int peso) throws ErroreValoreNonValido {
        if (pesoEffettivo - peso >= 0) pesoEffettivo -= peso;
        else throw new ErroreValoreNonValido("Peso da scaricare insufficente");
    }

    //GET
    public int getPesoEffettivo() {
        return pesoEffettivo;
    }
}
