public class Sfera extends Solido{
    double diametro;

    public Sfera(double pesoSpecifico, double diametro){
        super(pesoSpecifico);
        this.diametro = diametro;
    }

    @Override
    public double superficie() {
        return 4*Math.PI+Math.pow(diametro/2,2);
    }

    @Override
    public double volume() {
        return (4.0/3)*Math.PI+Math.pow(diametro/2,3);
    }
}
