import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;

public class Menu {
    public int inputNumero(int min, int max){   //estremi inclusi
        String s="";
        int num=-1;
        boolean ok=true;
        while(ok){
            try{
                InputStreamReader input = new InputStreamReader(System.in);
                BufferedReader tastiera = new BufferedReader(input);
                s = tastiera.readLine();
                num= Integer.parseInt(s);
                ok=false;
            }catch(Exception e){
                System.out.println("errore nell'inserimento da tastiera");
                ok=true;
            }
        }
        if(!(num<=max&&num>=min)){
            num= max;
        }
        return num;
    }

    public String inputString(){
        String s="";
        boolean ok=true;
        while(ok){
            try{
                InputStreamReader input = new InputStreamReader(System.in);
                BufferedReader tastiera = new BufferedReader(input);
                s = tastiera.readLine();
                ok=false;
            }catch(Exception e){
                System.out.println("errore nell'inserimento da tastiera");
                ok=true;
            }
        }
        return s;
    }

    public void menu(Supermercato s){
        boolean ricarica=true;
        while(ricarica) {
            menuGrafico();
            int n=inputNumero(0,8);
            ricarica = false;
            switch (n){
                case 0:
                    ricarica=false;
                    break;
                case 1:
                    s.addProdotto();    //manca funzione per aggiungere
                    break;
                case 2:
                    String nome= inputString();
                    s.ricercaProdotto(nome);
                    break;
                case 3:
                    int code= inputNumero(0,99999);
                    s.ricercaProdotto(code);
                    break;
                case 4:
                    s.updateProdotto();     //non modifica me elimina
                    System.out.println(n);
                    break;
                case 5:
                    s.deleteProdotto();     //come prendo il prodotto da eliminare?
                case 6:
                    s.telefonoResponsabile();   //il telefono non dovrebbe essere relativo a un prodotto, come ricavo il responsabile?
                case 7:
                    //Assente
                case 8:
                    ricarica=true;
                    break;
            }
        }
    }

    public void menuGrafico(){
        System.out.println("MENU:");
        System.out.println("\t0. Esci");
        System.out.println("\t1. Aggiungi prodotto");
        System.out.println("\t2. Ricerca prodotto per nome");
        System.out.println("\t3. Ricerca prodotto per codice");
        System.out.println("\t4. Update prodotto");
        System.out.println("\t5. Delete prodotto");
        System.out.println("\t6. Recupera numero responsabile");
        System.out.println("\t7. Recupera nome responsabile");
        //8. ricarica menù
    }

}
