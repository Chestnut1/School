public class Vendute {
    private String nome;
    private String cognome;
    private AutomobileVenduta[] vendite;
    private final int MAX_VEN = 1000;
    private int v;
    private int k = 0;
    private double mediaPrezzo;

    public Vendute(String n, String c,int v){

        if(v > 1000){
            vendite = new AutomobileVenduta[MAX_VEN];
        } else {
            this.v = v;
            vendite = new AutomobileVenduta[v];
        }

        cognome = c.substring(0,1).toUpperCase() + c.substring(1).toLowerCase();
        nome = c.substring(0,1).toUpperCase() + c.substring(1).toLowerCase();

    }

    public AutomobileVenduta[] getVendite() {
        return vendite;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public void add(AutomobileVenduta a){
        vendite[k] = a;
        k++;
    }

    public double getMediaPrezzo() {

        mediaPrezzo=0;
        for(int k=0;k<v;k++){
            mediaPrezzo= mediaPrezzo + vendite[k].getPrezzo();
        }
        mediaPrezzo = mediaPrezzo/k;

        return mediaPrezzo;
    }

    @Override
    public String toString() {

        String c = "";
        for(int k=0;k<v;k++){
            c = c + vendite[k].toString();
        }

        return "\n Il venditore : " + nome + cognome + "\n ha venduto queste auto : " + c;
    }
}


