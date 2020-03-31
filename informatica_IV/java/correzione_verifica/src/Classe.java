import java.util.Arrays;

public class Classe {
    private int anno;
    private String sezione = "";
    private final int MIN_ANNO = 1;
    private final int MAX_ANNO = 5;

    public Classe(int anno, String sezione){
        this.anno = (anno>=MIN_ANNO && anno<=MAX_ANNO) ? anno: MIN_ANNO;
        this.sezione = sezione;
    }

    public int getAnno() {
        return anno;
    }

    public String getSezione() {
        return sezione;
    }

    public void setAnno(int anno) {
        this.anno = (anno>=MIN_ANNO && anno<=MAX_ANNO) ? anno: MIN_ANNO;
    }

    public void setSezione(String sezione) {
        this.sezione = sezione;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "anno=" + anno +
                ", sezione=" + sezione +
                ", MIN_ANNO=" + MIN_ANNO +
                ", MAX_ANNO=" + MAX_ANNO +
                '}';
    }
}
