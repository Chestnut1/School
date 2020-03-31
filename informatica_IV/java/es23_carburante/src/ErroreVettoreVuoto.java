public class ErroreVettoreVuoto extends RuntimeException {
    public ErroreVettoreVuoto(){
        super("Errore vuoto");
    }

    public ErroreVettoreVuoto(String s){
        super(s);
    }
}
