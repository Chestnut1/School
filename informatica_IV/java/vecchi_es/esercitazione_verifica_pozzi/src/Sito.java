import java.awt.image.AbstractMultiResolutionImage;
import java.util.Vector;

public class Sito {
    private String nome;
    private String nazione;
    private Vector <Pozzo> pozzi;

    public Sito(String nome, String nazione){
        pozzi = new Vector<Pozzo>();
        this.nome = nome;
        this.nazione = nazione;
    }

    public void addPozzo(Pozzo pozzo){
        pozzi.add(pozzo);
    }

    public int greggioAnnuo(){
        int tot = 0;
        for(int i=0; i<pozzi.size();i++){
            tot += (pozzi.elementAt(i).isAttivo()) ? pozzi.elementAt(i).getCapacita(): 0;
        }
        return tot;
    }

    public float profMedia() throws ValoreNonValido{
        float media = 0.0f;
        int k = 0;
        for (int i=0; i<pozzi.size(); i++){
            if(pozzi.elementAt(i) instanceof PozzoMarino){
                media += ((PozzoMarino) pozzi.elementAt(i)).getProfondita();
                k++;
            }
        }
        if (k == 0) throw new ValoreNonValido("Nessun pozzo marino presente.");
        return media/k;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < pozzi.size(); i++){
            out += pozzi.elementAt(i).toString();
        }
        return out;
    }

    public void attiva(int codice){
        int i = -1;
        boolean trovato = false;
        while (++i < pozzi.size() && !(trovato=(pozzi.elementAt(i).getCodice() != codice)));
        if(trovato) pozzi.elementAt(i).attiva();
    }

    public void spegni(int codice){
        boolean trovato = false;
        int i =0;   
        for(i=0; i<pozzi.size() && !trovato;i++){
            trovato = (pozzi.elementAt(i).getCodice() == codice);
        }
        if(trovato) pozzi.elementAt(i).spegni();
    }
}
