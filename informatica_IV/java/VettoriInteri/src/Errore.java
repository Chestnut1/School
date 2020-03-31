public class Errore extends Exception {
    public Errore() {
        super("Messaggio che voglio");
    }

    public Errore(String message) {
        super(message);
    }
}
