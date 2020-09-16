import java.util.Vector;

public class Supermercato {
    private Vector<Prodotto> prodotti;
    private String nome;
    private String nomeArchivio;

    public Supermercato(String nome, String nomeArchivio){
        this.nome = nome;
        this.nomeArchivio = nomeArchivio;
        prodotti = new Vector<Prodotto>();
    }

    public void addProdotto(Prodotto p){
        //controllo prodotto gia' esistente
        prodotti.add(p);
    }

    public Prodotto ricercaProdotto(long codice){
        return null;    //se non esiste
    }

    public Prodotto ricercaProdotto(String nome){
        return null;    //se non esiste
    }

    public void eliminaProdotto(Prodotto p){

    }

    public void update(Prodotto p){

    }

    public float ricercaValoreReparto(){
        return 0;
    }

    private String telefonoResponsabile(String prodotto){
        return "";
    }

    public String getNome() {
        return nome;
    }
}
