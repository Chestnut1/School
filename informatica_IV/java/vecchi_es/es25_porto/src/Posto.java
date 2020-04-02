public class Posto {
    private String codiceFiscale = "";
    private String nomeCliente = "";
    private Data dataInizio = new Data();
    private Data dataFine = new Data();
    private Barca barca= new Barca();
    private final float EUROMETRO = 5;    //euro al metro
    boolean affittato = false;

    public Posto(String nomeCliente, String codiceFiscale, Barca barca, Data dataInizio, Data dataFine){
        this.nomeCliente = nomeCliente;
        this.codiceFiscale = codiceFiscale;
        this.barca = barca;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        affittato = true;
    }

    public Posto(){
        this.nomeCliente = "";
        this.codiceFiscale = "";
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setDataInizio(Data dataInizio) {
        this.dataInizio = dataInizio;
    }

    public void setDataFine(Data dataFine) {
        this.dataFine = dataFine;
    }

    public void setBarca(Barca barca) {
        this.barca = barca;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public Barca getBarca() {
        return barca;
    }

    public Data getDataInizio() {
        return dataInizio;
    }

    public Data getDataFine() {
        return dataFine;
    }

    public boolean isAffittato() {
        return affittato;
    }

    public float getAffitto(){
        int giorniTot = 0;
        giorniTot = (dataFine.getA()-dataInizio.getA())*365;
        giorniTot = giorniTot + (dataFine.getM()-dataInizio.getM())*30;
        giorniTot = giorniTot + (dataFine.getG() - dataInizio.getG());
        return giorniTot * EUROMETRO * barca.getDimensione();
    }

    @Override
    public String toString() {
        return String.format("nome cliente: %s\ncodice fiscale: %s\ndata inizio: %d/%d/%d\ndata fine: %d/%d/%d\nbarca: [%d|%f|%d]\nprezzo: %f\n" , this.nomeCliente, this.codiceFiscale, this.dataInizio.getG(), this.dataInizio.getM(), this.dataInizio.getA(), this.dataFine.getG(), this.dataFine.getM(), this.dataFine.getA(), this.barca.getMatricola(), this.barca.getDimensione(), this.barca.getAnnofabbricazione(), this.getAffitto());
    }
}
