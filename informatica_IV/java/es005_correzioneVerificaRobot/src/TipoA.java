public class TipoA extends Robot{
    private int spessore;
    private int precisione;

    public TipoA(String nome, float costoSec, Processore cpu, Memoria banco, int spessore, int precisione) throws ValoreNonValido {
        super(nome, costoSec, cpu, banco);

        if(spessore > 0) this.spessore = spessore;
        else throw new ValoreNonValido("Lo spessore deve essere positivo.");

        if(precisione > 0) this.precisione = precisione;
        else throw new ValoreNonValido("La precisione deve essere positiva.");
    }

    public int getSpessore() {
        return spessore;
    }

    public int getPrecisione() {
        return precisione;
    }

    public void setSpessore(int spessore) throws ValoreNonValido {
        if(spessore > 0) this.spessore = spessore;
        else throw new ValoreNonValido("Lo spessore deve essere positivo.");
    }

    public void setPrecisione(int precisione) throws ValoreNonValido {
        if(precisione > 0) this.precisione = precisione;
        else throw new ValoreNonValido("La precisione deve essere positiva.");
    }
}
