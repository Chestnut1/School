import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Test {
    public static void main(String[] args) {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        int giornoInizio = 0;
        int meseInizio = 0;
        int annoInizio = 0;
        int giornoFine = 0;
        int meseFine = 0;
        int annoFine = 0;
        int matricola = 0;
        float dimensione = 0;
        int annoFabbricazione = 0;
        String nomeCliente = "";
        String cf = "";

        Data inizio;
        Data fine;
        Barca motoscafo;
        Posto posto0;

        Porto genova = new Porto(5);

        boolean err = false;
        do{
            System.out.println("Giorno inizio affitto: ");
            try {
                giornoInizio = Integer.parseInt(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Giorno non valido");
            }
        }while(!err || giornoInizio<0);

        err = false;
        do{
            System.out.println("Mese inizio affitto: ");
            try {
                meseInizio = Integer.parseInt(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Mese non valido");
            }
        }while(!err || meseInizio<0);

        err = false;
        do{
            System.out.println("Anno inizio affitto: ");
            try {
                annoInizio = Integer.parseInt(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Anno non valido");
            }
        }while(!err || annoInizio<0);

        err = false;
        do{
            System.out.println("Giorno fine affitto: ");
            try {
                giornoFine = Integer.parseInt(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Giorno non valido");
            }
        }while(!err || giornoFine<0);

        err = false;
        do{
            System.out.println("Mese fine affitto: ");
            try {
                meseFine = Integer.parseInt(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Mese non valido");
            }
        }while(!err || meseFine<0);

        err = false;
        do{
            System.out.println("Anno fine affitto: ");
            try {
                annoFine = Integer.parseInt(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Anno non valido");
            }
        }while(!err || annoFine<0);

        err = false;
        do{
            System.out.println("Matricola barca: ");
            try {
                matricola = Integer.parseInt(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Matricola non valida");
            }
        }while(!err || matricola<0);

        err = false;
        do{
            System.out.println("Dimensione barca: ");
            try {
                dimensione = Float.parseFloat(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Dimensione non valida");
            }
        }while(!err || dimensione<0);

        err = false;
        do{
            System.out.println("Anno fabbracazione barca: ");
            try {
                annoFabbricazione = Integer.parseInt(tastiera.readLine());
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Anno non valido");
            }
        }while(!err || annoFabbricazione<0);

        err = false;
        do{
            System.out.println("Nome cliente: ");
            try {
                nomeCliente = tastiera.readLine();
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            }
        }while(!err);

        err = false;
        do{
            System.out.println("Codice Fiscale cliente: ");
            try {
                cf = tastiera.readLine();
                err = true;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                //e.printStackTrace();
            }
        }while(!err);

        inizio = new Data(giornoInizio,meseInizio,annoInizio);
        fine = new Data(giornoFine,meseFine,annoFine);
        motoscafo = new Barca(matricola,dimensione,annoFabbricazione);
        posto0 = new Posto(nomeCliente,cf,motoscafo,inizio,fine);

        genova.affittaPosto(0,posto0);
        System.out.println(genova.toString());

        System.out.println((genova.controlla(1) ? "affittato" : "non affittato"));
    }
}
