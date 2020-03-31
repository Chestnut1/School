import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        Keyboard input = new Keyboard();
        boolean again = true;

        double diametro;
        double lato;
        double pesoSpecifico;

        char answer;

        Vector <Solido> vettore_figure = new Vector<Solido>();

        while(again){
            answer = input.readChar("Voui aggiungere una sfera o un cubo?(s/c)");
            if (answer == 's' || answer == 'S'){
                diametro = input.readDouble("Inserisic il diametro della sfera: ");
                pesoSpecifico = input.readDouble("Inserisci il peso specifico: ");
                vettore_figure.add(new Sfera(pesoSpecifico, diametro));
            }else if(answer == 'c' || answer == 'C'){
                lato = input.readDouble("Inserisic il lato del cubo: ");
                pesoSpecifico = input.readDouble("Inserisci il peso specifico: ");
                vettore_figure.add(new Cubo(pesoSpecifico, lato));
            }else{
                System.out.println("Carattere sbagliato...");
            }

            again = (input.readChar("Ancora? (s/n)") == 'n') ? false: true;
        }

    }
}
