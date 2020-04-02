public class PozzoMarino extends Pozzo {
    private float profondita;

    public PozzoMarino(float profondita, int capacita) throws ValoreNonValido{
        super(capacita);
        if(profondita>=0){
            this.profondita = profondita;
        }else{
            throw new ValoreNonValido("Profondità deve essere positiva.");
        }
    }

    @Override
    public String toString() {
        return String.format("\nPozzo marino\n\tprofondita': %.2f\n" , profondita) + super.toString();
    }

    public float getProfondita(){
        return profondita;
    }
}
