import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Test {
    public static void main(String[] args) {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        float width = 0;
        float height = 0;
        Rettangolo r1;

        boolean err = false;
        do{
            System.out.println("Inserisci la base del rettangolo: ");
            try {
                width = Float.parseFloat(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Base non valida");
            }
        }while(!err || width<0);

        err = false;
        do{
            System.out.println("Inserisci l'altezza del rettangolo: ");
            try {
                height = Float.parseFloat(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Altezza non valida");
            }
        }while(!err || height<0);

        r1 = new Rettangolo(width,height);

        System.out.println(r1.toString());
    }
}