import java.util.Vector;

public class Palazzo {
    private String nome;
    private String indirizzo;
    private String citta;
    private final int MAX_PIANO;
    private Vector<Piano> piani;

    public Palazzo(String nome, String indirizzo, String citta, int MAX_PIANO) throws ValoreNonValido {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        piani = new Vector<Piano>();
        if (MAX_PIANO>=1){
            this.MAX_PIANO = MAX_PIANO;
        }else throw new ValoreNonValido("Il piano deve essere >= 1");
    }

    public String getNome() {
        return nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void addPiano(Piano p){
        piani.add(p);
    }

    public class Piano{
        private int numPiano;
        private Vector<Appartamento> appartamenti;

        public Piano(int numPiano) throws ValoreNonValido {
            appartamenti = new Vector<Appartamento>();
            if (numPiano>= 1 && numPiano<=MAX_PIANO)
                this.numPiano = numPiano;
            else throw new ValoreNonValido("Numero di piano non corretto per il palazzo");
            Palazzo.this.addPiano(this);
        }

        public int getNumPiano() {
            return numPiano;
        }

        public void addAppartamento(Appartamento a){
            appartamenti.add(a);
        }

        public class Appartamento{
            private int interno;
            private Vector<Stanza> stanze;
            private Vector<Persona> proprietari;

            public Appartamento(int interno, Persona p) {
                stanze = new Vector<Stanza>();
                this.interno = interno;
                Piano.this.addAppartamento(this);
                proprietari = new Vector<Persona>();
                proprietari.add(p);
            }
            /*
             public Appartamento(int interno) {
                 stanze = new Vector<Stanza>();
                 this.interno = interno;
                 Piano.this.addAppartamento(this);
              }
 */
            public void addProprietario(Persona p){
                proprietari.add(p);

            }

            private void addStanza(Stanza s){
                stanze.add(s);
            }

            public void addStanza(float lunghezza, float larghezza) throws ValoreNonValido {
                new Stanza(lunghezza, larghezza);
            }

            public class Stanza{
                private float lunghezza;
                private float larghezza;

                public Stanza(float lunghezza, float larghezza) throws ValoreNonValido {
                    if (lunghezza>0 && larghezza>0) {
                        this.lunghezza = lunghezza;
                        this.larghezza = larghezza;
                    }else throw new ValoreNonValido("Le dimensioni non possono essere <=0");
                    Appartamento.this.addStanza(this);
                }

                @Override
                public String toString() {
                    return "("+ lunghezza +  ", " + larghezza + ")";
                }
            }

            @Override
            public String toString() {
                return "Appartamento{" +
                        "interno=" + interno +
                        " stanze=" + stanze +
                        "}\n";
            }
        }

        @Override
        public String toString() {
            return "Piano{" +
                    "numPiano=" + numPiano +
                    ", appartamenti=\n" + appartamenti +
                    "}\n";
        }
    }

    @Override
    public String toString() {
        return "Palazzo{" +
                "nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", citta='" + citta + '\'' +
                ", piani=\n" + piani +
                '}';
    }
}
