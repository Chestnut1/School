import java.util.Arrays;

public class Scuola {
    private String nome = "";
    private final int MAX_CLASSI = 50;
    private int nclassi = 0;

    ClasseConAlunni scuola[] = new ClasseConAlunni[MAX_CLASSI];

    public Scuola(String nome){
        this.nome = nome;
    }

    public void addClasse(ClasseConAlunni classe){
        if(isFree(nclassi)) scuola[nclassi] = new ClasseConAlunni(classe.getAnno(), classe.getSezione(), classe.getNumero_alunni());
        nclassi++;
    }

    public boolean isFree(int p){
        return scuola[p] == null;
    }

    public ClasseConAlunni[] getScuola() {
        return scuola;
    }

    public int getMAX_CLASSI() {
        return MAX_CLASSI;
    }

    public int getNclassi() {
        return nclassi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < nclassi; i++) {
            out += String.format("|%d%s| , %d\n", scuola[i].getAnno(), scuola[i].getSezione(), scuola[i].getNumero_alunni());
        }
        return out;
    }
}
