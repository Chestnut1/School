public abstract class Solido implements FiguraSolida, CorpoSolido{
    private double pesoSpecifico;

    Solido(double pesoSpecifico){
        this.pesoSpecifico = pesoSpecifico;
    }

    public double getPesoSpecifico(){
        return pesoSpecifico;
    }

    public double peso(){
        return pesoSpecifico * volume();
    }
}
