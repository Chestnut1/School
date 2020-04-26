public class TipoC extends Robot{
    private TipoMateriale materiale;

    public TipoC(String nome, float costoSec, Processore cpu, Memoria banco, TipoMateriale materiale) throws ValoreNonValido {
        super(nome, costoSec, cpu, banco);
        this.materiale = materiale;
    }

    public TipoMateriale getMateriale() {
        return materiale;
    }

    public void setMateriale(TipoMateriale materiale) {
        this.materiale = materiale;
    }
}
