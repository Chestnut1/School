import java.util.GregorianCalendar;

public class Prodotto {
    private Reparto reparto;
    private Categoria categoria;
    private Scaffale scaffale;
    private String prodotto;
    private String produttore;
    private long codice;
    private int quantita;
    private Unitamisura unitamisura;
    private float prezzo;
    private Taglia taglia;
    private int sconto;
    private String responsabile;
    private int numero_responsabile;
    private GregorianCalendar scadenza;

    public Prodotto(Reparto reparto, Categoria categoria, Scaffale scaffale, String prodotto, String produttore,long codice, int quantita, Unitamisura unitamisura, float prezzo, Taglia taglia, int sconto, String responsabile, int numero_responsabile, GregorianCalendar scadenza){
        this.reparto = reparto;
        this.categoria = categoria;
        this.scaffale = scaffale;
        this.prodotto = prodotto;
        this.produttore = produttore;
        this.codice = codice;
        this.quantita = (quantita > 0) ? quantita: 1;
        this.unitamisura = unitamisura;
        this.prezzo = (prezzo > 0) ? prezzo: 5;
        this.taglia = taglia;
        this.sconto = (sconto >= 0 && sconto <= 100) ? sconto: 0;
        this.responsabile = responsabile;
        this.numero_responsabile = numero_responsabile;
        this.scadenza = scadenza;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public GregorianCalendar getScadenza() {
        return scadenza;
    }

    public int getNumero_responsabile() {
        return numero_responsabile;
    }

    public int getQuantita() {
        return quantita;
    }

    public int getSconto() {
        return sconto;
    }

    public long getCodice() {
        return codice;
    }

    public Reparto getReparto() {
        return reparto;
    }

    public Scaffale getScaffale() {
        return scaffale;
    }

    public String getProdotto() {
        return prodotto;
    }

    public String getProduttore() {
        return produttore;
    }

    public String getResponsabile() {
        return responsabile;
    }

    public Taglia getTaglia() {
        return taglia;
    }

    public Unitamisura getUnitamisura() {
        return unitamisura;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setCodice(long codice) {
        this.codice = codice;
    }

    public void setNumero_responsabile(int numero_responsabile) {
        this.numero_responsabile = numero_responsabile;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = (prezzo > 0) ? prezzo: 5;
    }

    public void setProdotto(String prodotto) {
        this.prodotto = prodotto;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public void setQuantita(int quantita) {
        this.quantita = (quantita > 0) ? quantita: 1;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
    }

    public void setScadenza(GregorianCalendar scadenza) {
        this.scadenza = scadenza;
    }

    public void setScaffale(Scaffale scaffale) {
        this.scaffale = scaffale;
    }

    public void setSconto(int sconto) {
        this.sconto = (sconto >= 0 && sconto <= 100) ? sconto : 0;
    }

    public void setTaglia(Taglia taglia) {
        this.taglia = taglia;
    }

    public void setUnitamisura(Unitamisura unitamisura) {
        this.unitamisura = unitamisura;
    }

    @Override
    public String toString() {
        return "\n\nProdotto\t" +
                "reparto=\t" + reparto +
                "categoria=\t" + categoria +
                "scaffale=\t" + scaffale +
                "prodotto=\t'" + prodotto + '\'' +
                "produttore=\t'" + produttore + '\'' +
                "codice=\t" + codice +
                "quantita=\t" + quantita +
                "unitamisura=\t" + unitamisura +
                "prezzo=\t" + prezzo +
                "taglia=\t" + taglia +
                "sconto=\t" + sconto +
                "responsabile=\t'" + responsabile + '\'' +
                "numero_responsabile=\t" + numero_responsabile +
                "scadenza=\t" + scadenza;
    }
}
