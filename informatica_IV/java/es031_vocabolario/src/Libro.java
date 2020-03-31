public class Libro {
    private int numPagine;  //numero di pagine del libro

    public Libro(int numPagine){
        this.numPagine = (numPagine > 0) ? numPagine : 100;
    }

    public void setPagine(int numPagine){
        this.numPagine = (numPagine > 0) ? numPagine : 100;
    }

    public String pageMessage(){
        return "numero di pagine = " + numPagine;
    }
}
