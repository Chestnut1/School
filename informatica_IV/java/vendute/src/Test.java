import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Test {
    public static void main(String[] args) {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        String modello = "";
        int cilindrata = 0;
        float prezzo = 0;
        boolean err = true;

        System.out.println("Inserisci il modello: ");
        try {   //l'unica istrzione che potebbe generarmi l'eccezione
            modello = tastiera.readLine();
        } catch (IOException e) {   //se si genera l'eccezione specificata allora visualizza la traccia di tutte le chiamate andate male
            System.out.println("errore di IO");
            //e.printStackTrace();  succede raramente
        }


        do{
            System.out.println("Inserisci la cilindrata: ");
            try {
                cilindrata = Integer.parseInt(tastiera.readLine());
                err = false;
            } catch (IOException e) {
                System.out.println("errore di IO");
                //e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Non hai inserito un numero corretto");
            }
        }while(err || cilindrata<0);

        err = true;
        do{
            System.out.println("Inserisci il prezzo ");
            try {
                prezzo = Float.parseFloat(tastiera.readLine());
                err = false;
            } catch (IOException e) {
                System.out.println("Errore di IO");
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Non hai inserito un numero corretto");
            }
        }while(err || prezzo<=0);

        AutomobileVenduta a1;
        AutomobileVenduta a2;

        Vendute a3;
        Vendute a4;

        // test prima classe

        a2 = new AutomobileVenduta(modello,prezzo,cilindrata);
        a1 = new AutomobileVenduta("fIaT",0,100);

        System.out.println(a1);
        System.out.println(a2);

        if(a1.isPiuCara(a2)==true){
            System.out.println("a1 e' piu' costosa di a2");
        }else {
            System.out.println("a2 e' piu' costoda di a1");
        }

        // test seconda classe

        a3 = new Vendute("pIppo","BaUDo",100);
        a4 = new Vendute("RoBeRTa","mOlInAri",10);

        a3.add(a1);
        a3.add(a2);
        System.out.println(a3);
    }
}
