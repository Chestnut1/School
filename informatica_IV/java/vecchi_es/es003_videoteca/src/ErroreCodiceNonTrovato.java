public class ErroreCodiceNonTrovato extends RuntimeException {
    public ErroreCodiceNonTrovato(){
        super();
    }

    public ErroreCodiceNonTrovato(String msg){
        super(msg);
    }
}
