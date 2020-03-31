public class AutomobileVenduta {
    private String modello;
    private double prezzo;
    private int cilindrata;
    private final int CIL_BASE = 500;
    private final int PRE_BASE = 10000;


    public AutomobileVenduta(String m,double p,int c) {

        if (c < 500 || c > 5000) {
            cilindrata = CIL_BASE;
        }else{
            cilindrata = c;
        }

        modello = m.substring(0,1).toUpperCase() + m.substring(1).toLowerCase();

        if(p<=0){
            prezzo = PRE_BASE;
        }else {
            prezzo = p;
        }
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public String getModello() {
        return modello;
    }

    public void setCilindrata(int c) {
        if (c < 500 && c > 5000) {
            cilindrata = CIL_BASE;
        }else{
            cilindrata = c;
        }
    }

    public void setModello(String m) {

        modello = m.substring(0,1).toUpperCase() + m.substring(1).toLowerCase();
        this.modello = m;
    }

    public void setPrezzo(double p) {
        if(p<=0){
            prezzo = PRE_BASE;
        }else {
            prezzo = p;
        }
    }

    public boolean isPiuCara(AutomobileVenduta a){
        boolean vero = false;
        if(a.getPrezzo()> prezzo ){
            vero = false;
        }else {
            vero = true;
        }
        return vero;
    }

    @Override
    public String toString() {
        return "\n Modello : " + modello + "\n Prezzo : " + prezzo + "\n Cilindrata : " + cilindrata;
    }
}
