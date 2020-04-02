import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Test {
    public static void main(String[] args) {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        float raggio = 0;
        float width = 0;
        float heigth = 0;
        Rettangolo r1;
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

        err = false;
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
                heigth = Float.parseFloat(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Altezza non valida");
            }
        }while(!err || heigth<0);

        r1 = new Rettangolo(width,heigth);

        System.out.println((c1.getArea() == r1.getArea()) ? "Stessa area" : "Area diversa" );
    }
}