import java.util.Vector;

public class Compagnia {
    private String nome;
    private Vector <Sito> siti = new Vector<Sito>();

    public Compagnia(String nome){
        this.nome = nome;
    }

    public void addSito(Sito sito){
        siti.add(sito);
    }

    @Override
    public String toString() {
        String out = "|" + nome + "|\n";
        for (int i=0; i<siti.size();i++){
            out+=siti.elementAt(i).toString();
        }
        return out;
    }
}
