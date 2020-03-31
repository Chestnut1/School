import java.util.Vector;
import java.lang.*;

public class MalattiaInfettiva {
    private Vector <Focolaio> casi;
    private String nome;
    private float tempo_raddoppio;

    public MalattiaInfettiva(String nome){
        this.nome = nome;
        casi = new Vector<Focolaio>();
        tempo_raddoppio = 0;
    }

    public MalattiaInfettiva(String nome, float tempo_raddoppio) throws ValoreNonValido{
        this.nome = nome;
        if(tempo_raddoppio <=0 ) throw new ValoreNonValido("Il tempo di raddoppio deve essere positivo");
        else  this.tempo_raddoppio = tempo_raddoppio;
        casi = new Vector<Focolaio>();
    }

    public void addFocolaio(Focolaio f){
        casi.addElement(f);
    }

    public void addFocolaio(String nome, int infetti) throws ValoreNonValido {
        Focolaio f = new Focolaio(nome,infetti);
        casi.addElement(f);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTempo_raddoppio(int tempo_raddoppio) throws ValoreNonValido{
        if(tempo_raddoppio <=0 ) throw new ValoreNonValido("Il tempo di raddoppio deve essere positivo");
        else  this.tempo_raddoppio = tempo_raddoppio;
    }

    public float getTempo_raddoppio() {
        return tempo_raddoppio;
    }

    public Focolaio getFocolaio(String nome){
        Focolaio ret = null;
        for(Focolaio f : casi){
            if(f.getNome().equals(nome)){
                ret = f;
                break;
            }
        }
        return ret;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        String out = this.nome + String.format("\n");
        for(int i = 0; i < casi.size(); i++){
            out += String.format("%s\n" , casi.elementAt(i).toString());
        }
        return out;
    }

    public class Focolaio {
        private String nome;
        private int numero_infetti;
        private double tempo;

        public Focolaio(String nome){
            this.nome = nome;
            numero_infetti = 0;
            MalattiaInfettiva.this.addFocolaio(this);
        }

        public Focolaio(String nome, int numero_infetti) throws ValoreNonValido{
            this.nome = nome;
            if(numero_infetti>=0) this.numero_infetti = numero_infetti;
            else throw new ValoreNonValido("Gli infetti non possono essere negativi");
        }

        public String getNome() {
            return nome;
        }

        public int getNumero_infetti() {
            return numero_infetti;
        }

        public double getTempo() {
            calcolaTempoInizio();
            return tempo;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setNumero_infetti(int numero_infetti) throws ValoreNonValido{
            if(numero_infetti>=0) this.numero_infetti = numero_infetti;
            else throw new ValoreNonValido("Gli infetti non possono essere negativi");
        }

        public void setTempo(int tempo) throws ValoreNonValido{
            if(tempo_raddoppio>0) this.tempo = tempo;
            else throw new ValoreNonValido("Il tempo di raddoppio non puo' essere negativo o nullo.");
        }

        private void calcolaTempoInizio(){
            this.tempo = (Math.log10((double)numero_infetti)/Math.log10((double)2))*3;
        }

        @Override
        public String toString() {
            return this.nome + ", numero infetti: " + this.numero_infetti + ", tempo trascorso dal primo contagio: " + this.tempo;
        }
    }
}
