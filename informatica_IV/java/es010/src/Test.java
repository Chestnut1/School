import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Test {
    public static void main(String[] args) {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        float raggio = 0;
        Cerchio c1;

        boolean err = false;
        do{
            System.out.println("Inserisci il raggio del cerchio: ");
            try {
                raggio = Float.parseFloat(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Raggio non valido");
            }
        }while(!err || raggio<0);

        c1 = new Cerchio(raggio);

        System.out.println(c1.toString());
    }
}
