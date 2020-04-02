import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.GregorianCalendar;

public class Keyboard {
    private BufferedReader bf;
    private InputStreamReader reader;
    boolean ok = true;

    /***
     * @author Bruno Luca
     * @return integer read
     */

    public int readInteger(){
        int ret = 0;
        do {
            ok = true;
            try{
                ret = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            }catch (RuntimeException | IOException e){
                System.out.println("Intero non valido.");
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    /***
     * @author Bruno Luca
     * @return float read
     */

    public float readFloat(){
        float ret = 0;
        do {
            ok = true;
            try{
                ret = Float.parseFloat(new BufferedReader(new InputStreamReader(System.in)).readLine());
            }catch (RuntimeException | IOException e){
                System.out.println("Float non valido.");
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    /***
     * @author Bruno Luca
     * @return double read
     */

    public double readDouble(){
        double ret = 0;
        do {
            ok = true;
            try{
                ret = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
            }catch (RuntimeException | IOException e){
                System.out.println("Double non valido.");
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    /***
     * @author Bruno Luca
     * @return char read
     */

    public char readChar(){
        char ret = ' ';
        do {
            ok = true;
            try{
                ret = new BufferedReader(new InputStreamReader(System.in)).readLine().charAt(0);
            }catch (RuntimeException | IOException e){
                System.out.println("Carattere non valido.");
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    /***
     * @author Bruno Luca
     * @return string read
     */

    public String readString(){
        String ret = "";
        do {
            ok = true;
            try{
                ret = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }catch (RuntimeException | IOException e){
                System.out.println("Stringa non valido.");
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    /***
     * @author Bruno Luca
     * @param msg input message
     * @return integer read
     */

    public int readInteger(String msg){
        int ret = 0;
        do {
            ok = true;
            try{
                System.out.println(msg);
                ret = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    /***
     * @author Bruno Luca
     * @param msg input message
     * @return float read
     */

    public float readFloat(String msg){
        float ret = 0;
        do {
            ok = true;
            try{
                System.out.println(msg);
                ret = Float.parseFloat(new BufferedReader(new InputStreamReader(System.in)).readLine());
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    /***
     * @author Bruno Luca
     * @param msg input message
     * @return double read
     */

    public double readDouble(String msg){
        double ret = 0;
        do {
            ok = true;
            try{
                System.out.println(msg);
                ret = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    /***
     * @author Bruno Luca
     * @param msg input message
     * @return char read
     */

    public char readChar(String msg){
        char ret = ' ';
        do {
            ok = true;
            try{
                System.out.println(msg);
                ret = (char) new BufferedReader(new InputStreamReader(System.in)).read();
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    /***
     * @author Bruno Luca
     * @param msg input message
     * @return string read
     */

    public String readString(String msg){
        String ret = "";
        do {
            ok = true;
            try{
                System.out.println(msg);
                ret = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }
}
