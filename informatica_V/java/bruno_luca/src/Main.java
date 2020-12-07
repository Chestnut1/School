import java.security.KeyStore;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean close = false;
        DB libreria = new DB();
        String books;   //list of books
        String arguments;   //list of books
        String[] data;
        String[] argomentiLibro;
        String out;
        boolean primary_argument = false;

        while(!close){
            out = "";   //clear the output string

            System.out.println("\n-----------------------------------------------------------------\n\t1> Mostra libri (libro, argomento principale, argomento secondario)\n\t2>aggiungi libro\n\t3> Cerca per argomento\n\t4> Cencella record livello 0\n\t5>Chiudi\n-----------------------------------------------------------------\n");

            int resp = Integer.parseInt(String.valueOf(input.next()));

            switch (resp){
                case 1: //mostra libri con arg principale e secondario

                    books = libreria.executeQuery("SELECT l.* FROM Libri l");
                    arguments = libreria.executeQuery("SELECT l.* FROM argomentiLibro l");
                    System.out.println(arguments);
                    System.out.println(books);

                    argomentiLibro = arguments.split(",");
                    data = books.split(",");

                    for(int i = 0; i < data.length; i+=3){
                        out += data[i+1] + " - " + data[i+2];
                        for(int k = 0; k < argomentiLibro.length;k+=5){
                                    if (Integer.parseInt(argomentiLibro[k+1]) == 3 && !primary_argument){
                                        out += ", linux";
                                        primary_argument = true;
                                    }else if(Integer.parseInt(argomentiLibro[k+1]) == 2 && primary_argument){
                                        out += ", linux";
                                    }
                                    if (Integer.parseInt(argomentiLibro[k+2]) == 3 && !primary_argument){
                                        out += ", elettronica";
                                        primary_argument = true;
                                    }else if(Integer.parseInt(argomentiLibro[k+2]) == 2 && primary_argument){
                                        out += ", elettronica";
                                    }
                                    if (Integer.parseInt(argomentiLibro[k+3]) == 3 && !primary_argument){
                                        out += ", assembly";
                                        primary_argument = true;
                                    }else if(Integer.parseInt(argomentiLibro[k+3]) == 2 && primary_argument){
                                        out += ", assembly";
                                    }
                                    if (Integer.parseInt(argomentiLibro[k+4]) == 3 && !primary_argument){
                                        out +=  ", linugaggio c";
                                        primary_argument = true;
                                    }else if(Integer.parseInt(argomentiLibro[k+4]) == 2 && primary_argument){
                                        out += ", linugaggio c";
                                    }
                            primary_argument = false;
                            out += "\n";
                        }


                    }

                    System.out.println(out);


                    break;

                case 2: //aggiungi libro
                    break;

                case 3: //chiedi argomento
                    break;

                case 4: //cancellare record lvl 0
                    break;

                case 5: //uscire
                    close = true;
                    break;

                default:
                    System.out.println("NON IN ELENCO");


            }

        }

        //kill connection with db
        libreria.closeDB();

    }
}
