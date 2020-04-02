public abstract class Vagone {
    private String codice;
    private String aziendaCostruttrice;
    private int pesoVuoto;
    private int annoCostruzione;

    public Vagone(String codice, String aziendaCostruttrice, int pesoVuoto, int annoCostruzione) throws ErroreValoreNonValido{
        this.codice = codice;
        this.aziendaCostruttrice = aziendaCostruttrice;

        if(pesoVuoto>0)this.pesoVuoto = pesoVuoto;
        else throw new ErroreValoreNonValido("Peso a vuoto non valido");

        if(annoCostruzione>=1800) this.annoCostruzione = annoCostruzione;
        else throw new ErroreValoreNonValido("Data non valida");
    }

    //GET
    public int getAnnoCostruzione() {
        return annoCostruzione;
    }

    public int getPesoVuoto() {
        return pesoVuoto;
    }

    public String getAziendaCostruttrice() {
        return aziendaCostruttrice;
    }

    public String getCodice() {
        return codice;
    }

    //SET

    public void setAnnoCostruzione(int annoCostruzione) throws ErroreValoreNonValido {
        if(annoCostruzione>=1800) this.annoCostruzione = annoCostruzione;
        else throw new ErroreValoreNonValido("Data non valida");
    }

    public void setAziendaCostruttrice(String aziendaCostruttrice) {
        this.aziendaCostruttrice = aziendaCostruttrice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setPesoVuoto(int pesoVuoto) throws ErroreValoreNonValido{
        if(pesoVuoto>0)this.pesoVuoto = pesoVuoto;
        else throw new ErroreValoreNonValido("Peso a vuoto non valido");
    }
}
