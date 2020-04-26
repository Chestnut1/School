public class Libro {
    private String titolo;
    private Autore autore;
    private int numeroPagine;
    private static double costoPagina = 0.05;
    private static final double COSTO_FISSO = 5.5;

    public Libro(String titolo, Autore autore, int numeroPagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.numeroPagine = numeroPagine;
    }

    public static void setCostoPagina(double costo) {
        costoPagina = costo;
    }

    public static double getCostoPagina() {
        return costoPagina;
    }

    public static double getCostoFisso() {
        return COSTO_FISSO;
    }

    public String getTitolo() {
        return titolo;
    }

     public Autore getAutore() {
        return autore;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public double getPrezzo() {
        return COSTO_FISSO + numeroPagine * costoPagina;
    }


    @Override
    public String toString() {
        return "'" + titolo + "' di " + autore +
                ", numeroPagine=" + numeroPagine +
                ", prezzo=" + getPrezzo() + "\n";
    }
}