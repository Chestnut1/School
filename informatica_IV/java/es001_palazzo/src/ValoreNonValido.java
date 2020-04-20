public class ValoreNonValido extends Exception {
    public ValoreNonValido() {
        super("Valore non valido");
    }

    public ValoreNonValido(String message) {
        super(message);
    }
}
