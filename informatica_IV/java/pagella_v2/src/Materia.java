public class Materia {
    private String nome;
    private int nVoti;
    private final int NMAXVOTI = 10;
    private Voto[] voti;

    public Materia(String nome){
        this.nome = nome;
        nVoti = 0;
        voti = new Voto[NMAXVOTI];
    }

    public void aggiungiVoto(Voto v){
        if(nVoti<NMAXVOTI) {
            voti[nVoti] = v;
            nVoti++;
        }
    }

    public String getNome() {
        return nome;
    }

    public Voto[] getVoti() {
        return voti;
    }

    @Override
    public String toString() {
        String out = getNome() + String.format("\n\n");
        int k = 0;
        for (k=0;k<nVoti;k++){
            out = out + String.format("\t") + voti[k] + ",";
        }
        return out;

    }
}
