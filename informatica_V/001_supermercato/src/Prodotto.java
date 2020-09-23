import java.util.GregorianCalendar;

public class Prodotto {
    private String produttore="";
    private Enum reparto;
    private Enum categoria;
    private String scaffale= "";
    private String nomeProdotto;
    private double quantita;
    private long codiceProdotto;
    private Enum unitaMisura;
    private float prezzo;
    private String taglia="";
    private float sconto=0;
    private String responsabile;
    private String telefono;
    private GregorianCalendar scadenza=null;

    public Prodotto(String produttore, Enum reparto, Enum categoria, String scaffale, String nomeProdotto, double quantita, long codiceProdotto, Enum unitaMisura, float prezzo, String taglia, float sconto, String responsabile, String telefono, GregorianCalendar scadenza) {
        this.produttore = produttore;
        this.reparto = reparto;
        this.categoria = categoria;
        this.scaffale = scaffale;
        this.nomeProdotto = nomeProdotto;
        this.quantita = quantita;
        this.codiceProdotto = codiceProdotto;
        this.unitaMisura = unitaMisura;
        this.prezzo = prezzo;
        this.taglia = taglia;
        this.sconto = sconto;
        this.responsabile = responsabile;
        this.telefono = telefono;
        this.scadenza = scadenza;
    }

    public String getProduttore() {
        return produttore;
    }

    public Enum getReparto() {
        return reparto;
    }

    public Enum getCategoria() {
        return categoria;
    }

    public String getScaffale() {
        return scaffale;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public double getQuantita() {
        return quantita;
    }

    public long getCodiceProdotto() {
        return codiceProdotto;
    }

    public Enum getUnitaMisura() {
        return unitaMisura;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public String getTaglia() {
        return taglia;
    }

    public float getSconto() {
        return sconto;
    }

    public String getResponsabile() {
        return responsabile;
    }

    public String getTelefono() {
        return telefono;
    }

    public GregorianCalendar getScadenza() {
        return scadenza;
    }

    public String toStringSave() {
        char carattere = ',';
        return  produttore + carattere +
                reparto + carattere +
                categoria + carattere +
                scaffale + carattere +
                nomeProdotto + carattere +
                quantita + carattere +
                codiceProdotto + carattere +
                unitaMisura + carattere +
                prezzo + carattere +
                taglia + carattere +
                sconto + carattere +
                responsabile + carattere +
                telefono + carattere +
                scadenza + carattere;
    }
}