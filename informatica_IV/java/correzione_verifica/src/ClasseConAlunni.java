public class ClasseConAlunni extends Classe {
    private int numero_alunni;
    private int MAX_ALUNNI = 30;
    private int MIN_ALUNNI = 5;

    public ClasseConAlunni(int anno, String sezione, int numero_alunni){
        super(anno, sezione);
        this.numero_alunni = (numero_alunni>=MIN_ALUNNI && numero_alunni<=MAX_ALUNNI) ? numero_alunni: MIN_ALUNNI;
    }

    public void setNumero_alunni(int numero_alunni) {
        this.numero_alunni = (numero_alunni>=MIN_ALUNNI && numero_alunni<=MAX_ALUNNI) ? numero_alunni: MIN_ALUNNI;
    }

    public int getNumero_alunni() {
        return numero_alunni;
    }

    @Override
    public String toString() {
        return "ClasseConAlunni{" +
                "numero_alunni=" + numero_alunni +
                ", MAX_ALUNNI=" + MAX_ALUNNI +
                ", MIN_ALUNNI=" + MIN_ALUNNI +
                '}';
    }
}
