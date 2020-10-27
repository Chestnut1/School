public class Impiegato {

    private String nome;
    private String cognome;
    private String citta;

    public Impiegato(String nome, String cognome, String citta){
        this.nome = nome;
        this.cognome = cognome;
        this.citta = citta;
    }

    public Impiegato(){
        this.nome = "Default";
        this.cognome = "Default";
        this.citta = "Default";
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return  "Nome:\t\t" + this.nome + "\n" +
                "Cognome:\t\t" + this.cognome + "\n" +
                "Citta:\t\t" + this.citta + "\n";
    }
}
