import java.util.Vector;

public class Persona {
    private String cognome;
    private String nome;
    private Vector<Palazzo.Piano.Appartamento> proprieta;

    public Persona(String cognome, String nome) {
        this.cognome = cognome;
        this.nome = nome;
        proprieta = new Vector<Palazzo.Piano.Appartamento>();
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }
    public void addProprieta(Palazzo.Piano.Appartamento a){
        proprieta.add(a);
    }

    public Vector<Palazzo.Piano.Appartamento> getProprieta() {
        return proprieta;
    }

    @Override
    public String toString() {
        return  cognome + " " + nome ;
    }

}
