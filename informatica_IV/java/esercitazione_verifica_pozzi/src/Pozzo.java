public abstract class Pozzo {
    private static int codice = 0;
    private int myCodice;
    private boolean attivo;
    private int capacita;

    public Pozzo(int capacita) throws ValoreNonValido{
        if(capacita>=0){
            this.capacita = capacita;
        }else{
            throw new ValoreNonValido("Capacità deve essere positiva.");
        }
        this.attivo = true;
        myCodice = codice;
        codice++;
    }

    public void attiva(){
        this.attivo = true;
    }

    public void spegni(){
        this.attivo = false;
    }

    public boolean isAttivo() {
        return attivo;
    }

    public int getCapacita(){return capacita;}

    public int getCodice() {
        return myCodice;
    }

    @Override
    public String toString() {
        return  "Codice=" + myCodice +
                ", attivo=" + attivo +
                ", capacita=" + capacita;
    }
}
