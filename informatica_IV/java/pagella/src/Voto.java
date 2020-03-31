public class Voto {

    private Data giorno;    //giorno in cui si è preso il voto
    private float voto;     //voto effettiv0, da 0 e 10
    private float peso;     //peso del vot
    private char tipo;      //o per orale s per scritto

    public Voto(Data giorno, float voto, float peso, char tipo){
        this.giorno =  giorno;
        this.voto = (voto>0 && voto<10) ? voto : 1f;
        this.peso = (peso>0 && peso<1) ? peso : 1f;
        this.tipo = (tipo== 's' || tipo == 'S' || tipo == 'o' || tipo == 'O') ? tipo : 'o';
    }

    public String toString(){
        //String.format mi fa una stringa come in c
        return this.giorno.toString() + String.format(": %.2f (%.2f) %c" , this.voto, this.peso, this.tipo);
    }

    public Data getGiorno() {
        return giorno;
    }

    public float getVoto(){
        return voto;
    }

    public float getPeso(){
        return peso;
    }

    public char getTipo(){
        return tipo;
    }

    public void setGiorno(Data giorno) {
        this.giorno = giorno;
    }

    public void setPeso(float peso) {
        this.peso = (peso>0 && peso<1) ? peso : 1f;
    }

    public void setTipo(char tipo) {
        this.tipo = (tipo== 's' || tipo == 'S' || tipo == 'o' || tipo == 'O') ? tipo : 'o';
    }

    public void setVoto(float voto) {
        this.voto = (voto>0 && voto<10) ? voto : 1f;
    }

}
