public class Vocabolario extends Libro{
    private int numDefinizioni;

    public Vocabolario(int numPagine, int numDefinizioni){
        super(numPagine);
        this.numDefinizioni = (numDefinizioni>0) ? numDefinizioni : 100;
    }

    public void setNumDefinizioni(int numDefinizioni){
        this.numDefinizioni = (numDefinizioni>0) ? numDefinizioni : 100;
    }

    public String definitionMessage(){
        return String.format("numero di pagine\t->\t%d\nnumero di definizioni\t->\t%d\ndefinizioni medie\t->\t%d\n");
    }
}
