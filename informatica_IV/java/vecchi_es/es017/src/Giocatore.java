public class Giocatore {

    //limiti per età e punteggio
    private final int ANNI_MAX = 25;
    private final int ANNI_MIN = 15;
    private final int PUNTEGGIO_MAX = 10;
    private final int PUNTEGGIO_MIN = 0;

    //caratteristiche del giocatore
    private String nome;
    private int punteggio;
    private int eta;

    public Giocatore(String nome, int eta){
        this.nome=nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

        this.eta = (eta>ANNI_MIN && eta<ANNI_MAX) ? eta : 15;

        punteggio = 5;
    }

    public Giocatore(String nome, int eta,int punteggio){
        this.nome=nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();

        this.eta = (eta>ANNI_MIN && eta<ANNI_MAX) ? eta : 15;

        this.punteggio = (punteggio>PUNTEGGIO_MIN && punteggio<PUNTEGGIO_MAX) ? punteggio : 5;
    }

    public int getEta() {
        return eta;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public String getNome() {
        return nome;
    }

    public void setEta(int eta) {
        this.eta = (eta>ANNI_MIN && eta<ANNI_MAX) ? eta : 15;
    }

    public void setNome(String nome) {
        this.nome=nome.substring(0, 1).toUpperCase() + nome.substring(1).toLowerCase();
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = (punteggio>PUNTEGGIO_MIN && punteggio<PUNTEGGIO_MAX) ? punteggio : 5;
    }

    @Override
    public String toString() {
        String out = String.format("|%s|\neta':\t\t\t%d\npunteggio:\t\t\t%d\n-----------------------------------------------\n", nome , eta , punteggio);
        return out;
    }
}