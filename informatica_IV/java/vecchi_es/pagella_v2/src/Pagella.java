public class Pagella {
    private final int NMAXMATERIE=15;
    private int periodo;
    private int materieTot;
    private Materia[] materie;

    public Pagella(int periodo){
        this.periodo=periodo;
        materieTot =0;
        materie= new Materia[NMAXMATERIE];
    }

    public String toString(){
        int k;
        String out = "" + String.format("PERIODO |%d|\n" , periodo);
        for (k=0; k<materieTot;k++){
            out = out + String.format("\t") + materie[k].toString() + String.format("\n----------------------------------\n");
        }
        return out;
    }

    public void aggiungiMateria(Materia materia){
        if(materieTot <NMAXMATERIE){
            materie[materieTot]=materia;
            materieTot++;
        }
    }

    public void aggiungiVotoMateria(String materia,Voto v){
        int i;
        boolean tro = false;
        for(i=0; i< materieTot && !tro; i++) {
            if (materia.equals(materie[i].getNome())) {
                materie[i].aggiungiVoto(v);
                tro = true;
            }
        }
        if(!tro) System.out.println("materia non trovata");
    }

    public int getPeriodo() {
        return periodo;
    }

    public int getNMaterie() {
        return materieTot;
    }
}
