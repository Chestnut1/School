import java.sql.SQLOutput;

public class ErroreVettoreVuoto extends RuntimeException{
    public ErroreVettoreVuoto() {
        super("Errore vettore vuoto");
    }

    public ErroreVettoreVuoto(String s){
        super(s);
    }
}
