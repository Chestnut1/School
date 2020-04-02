public class ValoreNonValido extends Exception {
    public ValoreNonValido(){
        super("valore non valido.");
    }

    public ValoreNonValido(String msg){
        super(msg);
    }
}
