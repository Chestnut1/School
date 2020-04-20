public class Test {
    public static void main(String[] args) {
        try {
            Palazzo mio = new Palazzo("Meraviglioso",
                    "Via Roma 1", "Cuneo", 2);
            Palazzo.Piano p1 = mio.new Piano(1);
            Palazzo.Piano p2 = mio.new Piano(2);

            Persona io= new Persona("Molinari", "Roberta");
            Persona mario = new Persona("Rossi","Mario");
            //Non è possibile creare un appartamento che non appartenga a nessuno
            Palazzo.Piano.Appartamento a1= p1.new Appartamento(1,io);
            //poi lo devo aggiungere alle mie proprietà
            io.addProprieta(a1);
            mario.addProprieta(a1); //se appartiene anche a mario
            a1.addProprietario(mario);
            Palazzo.Piano.Appartamento a2= p1.new Appartamento(2, mario);
            mario.addProprieta(a2);
            Palazzo.Piano.Appartamento a3= p2.new Appartamento(3,io);
            io.addProprieta(a3);
            Palazzo.Piano.Appartamento.Stanza camera =
                    a1.new Stanza(3,3);
            Palazzo.Piano.Appartamento.Stanza cucina =
                    a1.new Stanza(3,4);
            a2.addStanza(3,3);
            a2.addStanza(3,4);
            a3.new Stanza(6,10);

            System.out.println(io.toString() +io.getProprieta());
            System.out.println(mario.toString() +mario.getProprieta());
        } catch (ValoreNonValido valoreNonValido) {
            System.out.println(valoreNonValido.getMessage());
        }

    }
}
