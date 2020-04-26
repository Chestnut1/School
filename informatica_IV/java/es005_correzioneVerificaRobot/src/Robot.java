import java.util.Vector;

public class Robot {
    private String nome;
    private float costoSec;
    private Processore cpu;
    private Vector<Memoria> ram;
    private static final int MAX_SLOT = 4;

    public Robot(String nome, float costoSec, Processore cpu, Memoria banco) throws ValoreNonValido {
        this.nome = nome;
        if(costoSec >= 0) this.costoSec = costoSec;
        else throw new ValoreNonValido("Costo al secondo deve essere positivo o nullo.");
        ram.add(banco);
    }

    public String getNome() {
        return nome;
    }

    public float getCostoSec() {
        return costoSec;
    }

    public Processore getCpu() {
        return cpu;
    }

    public Vector<Memoria> getRam() {
        return ram;
    }

    public void setCostoSec(float costoSec) throws ValoreNonValido {
        if(costoSec >= 0) this.costoSec = costoSec;
        else throw new ValoreNonValido("Costo al secondo deve essere positivo o nullo.");
    }

    public void addMemoriaram(Memoria banco){
        if(ram.size() < 4) ram.add(banco);
    }

    public void eliminaMemoriaRam(Memoria banco){
        for(int i = 0; i < ram.size(); i++){
            if(ram.elementAt(i).equals(banco.getMarca()) && ram.elementAt(i).getGB() == banco.getGB()){
                ram.remove(i);
            }
        }
    }

    public class Lavorazione {
        private String nome;
        private int secondi;
        private Robot robotUsato;

        public Lavorazione(String nome, int secondi, Robot robotUsato) throws ValoreNonValido {
            this.nome = nome;
            if(secondi>0) this.secondi = secondi;
            else throw new ValoreNonValido("La lavorazione non pu' essere negativa.");
        }

        public String getNome() {
            return nome;
        }

        public int getSecondi() {
            return secondi;
        }

        public Robot getRobotUsato() {
            return robotUsato;
        }

        public float getCosto(){
            return costoSec * secondi;
        }
    }
}
