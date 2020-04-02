public class PozzoTerrestre extends Pozzo {
    private TipoTerreno terreno;

    public PozzoTerrestre(int capacita, TipoTerreno terreno) throws ValoreNonValido{
        super(capacita);
        this.terreno = terreno;
    }

    public TipoTerreno getTerreno() {
        return terreno;
    }

    @Override
    public String toString() {
        return String.format("\nPozzo Terrestre\n\tterreno: ") + terreno + super.toString();
    }
}
