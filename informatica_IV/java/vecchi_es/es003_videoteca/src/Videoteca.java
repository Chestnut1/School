import java.util.Vector;

public class Videoteca {
    private String nome;
    private String indirizzo;
    private Vector <Cassetta> lista_di_cassette = new Vector<Cassetta>();

    public Videoteca(String nome, String indirizzo){
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public void add(Cassetta c){
        lista_di_cassette.add(c);
    }

    public String nome(){
        return nome;
    }

    public String indirizzo(){
        return indirizzo;
    }

    public void compro(int codice, int nCopie) throws ErroreCodiceNonTrovato{
        boolean found = false;
        for (int k = 0; k < lista_di_cassette.size(); k++){
            if(lista_di_cassette.elementAt(k).codice() == codice){
                found = true;
                lista_di_cassette.elementAt(k).addCopie(nCopie);
            }
        }

        if(!found) throw new ErroreCodiceNonTrovato("Immpossibile comrpare, codice prodotto non trovato.");
    }

    public void vendo(int codice, int nCopie) throws ErroreCopieInsufficienti, ErroreCodiceNonTrovato{
        boolean found = false;
        for (int k = 0; k < lista_di_cassette.size(); k++){
            if(lista_di_cassette.elementAt(k).codice() == codice){
                found = true;
                if(lista_di_cassette.elementAt(k).nCopie()<nCopie) throw new ErroreCopieInsufficienti("Impossibile vendere, numero copie insufficienti");
                lista_di_cassette.elementAt(k).addCopie(nCopie);
            }
        }

        if(!found) throw new ErroreCodiceNonTrovato("Immpossibile vendere, codice prodotto non trovato.");
    }

    public double valoreNegozio(){
        double valore = 0;
        for (int i = 0; i < lista_di_cassette.size(); i++){
            valore += lista_di_cassette.elementAt(i).valore();
        }
        return valore;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < lista_di_cassette.size(); i++){
            out += String.format("%s(%d)\t\t%d\t\t%d\n" , lista_di_cassette.elementAt(i).titolo(), lista_di_cassette.elementAt(i).durata(), lista_di_cassette.elementAt(i).codice(), lista_di_cassette.elementAt(i).nCopie());
        }
        return out;
    }
}
