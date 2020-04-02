import java.util.Vector;

public class Palazzo {
    private Vector <Piano> piani;

    public Palazzo(){
        piani = new Vector<Piano>();
    }

    public void addPiano(Piano b){
        piani.add(b);
    }

    public class Piano {
        private Vector<Appartamento> appartamenti;

        public Piano(){
            appartamenti = new Vector<Appartamento>();
        }

        public void addAppartamento(Appartamento b){
            appartamenti.add(b);
        }

        public class Appartamento {
            private Vector<Stanza> stanze;

            public Appartamento() {
                stanze= new Vector<Stanza>();
            }

            public void addStanza(Stanza b){
                stanze.add(b);
            }

            public class Stanza {
                private float lunghezza;
                private float larghezza;

                public Stanza(float lunghezza, float larghezza) {
                    this.lunghezza = lunghezza;
                    this.larghezza = larghezza;
                }

                public void setLarghezza(float larghezza) {
                    this.larghezza = larghezza;
                }

                public void setLunghezza(float lunghezza) {
                    this.lunghezza = lunghezza;
                }

                public float getLarghezza() {
                    return larghezza;
                }

                public float getLunghezza() {
                    return lunghezza;
                }

                @Override
                public String toString() {
                    return "Stanza{" +
                            "lunghezza=" + lunghezza +
                            ", larghezza=" + larghezza +
                            '}';
                }
            }
        }
    }
}