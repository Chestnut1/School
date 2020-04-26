public class Memoria {
    private int gb;
    private String marca;

    public Memoria(int gb, String marca) throws ValoreNonValido {
        this.marca = marca;
        if(gb > 0) this.gb = gb;
        else throw new ValoreNonValido("I GB del banco di ram non possono essere negativi.");
    }

    public int getGB() {
        return gb;
    }

    public String getMarca() {
        return marca;
    }
}
