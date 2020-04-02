public class ErroreElementoEsistente extends Exception {
    public ErroreElementoEsistente() {
        super("Impossibile trovare l'elemento");
    }

    public ErroreElementoEsistente(String message) {
        super(message);
    }
}
