public class Processore {
    private String modello;
    private String marca;
    private float velocita;

    public Processore(String marca, String modello, float velocita) throws ValoreNonValido {
        this.marca = marca;
        this.modello = modello;
        if(velocita > 0) this.velocita = velocita;
        else throw new ValoreNonValido("La velocita' non puo' essere nulla o negativa");
    }

    public String getMarca() {
        return marca;
    }

    public String getModello() {
        return modello;
    }

    public float getVelocita() {
        return velocita;
    }
}
