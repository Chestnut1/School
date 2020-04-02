public class Cubo extends Solido{
    double lato;

    public Cubo(double pesoSpecifico, double lato) {
        super(pesoSpecifico);
        this.lato = lato;
    }

    public double getLato() {
        return lato;
    }

    @Override
    public double superficie() {
        return lato*lato*6;
    }

    @Override
    public double volume() {
        return Math.pow(lato,3);
    }
}
