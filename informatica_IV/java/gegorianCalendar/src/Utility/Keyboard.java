package Utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.GregorianCalendar;

public class Keyboard {
    private BufferedReader bf;
    private InputStreamReader reader;
    boolean ok = true;

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

    public int readInteger(String msg){
        int ret = 0;
        do {
            ok = true;
            try{
                ret = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    public float readFloat(String msg){
        float ret = 0;
        do {
            ok = true;
            try{
                ret = Float.parseFloat(new BufferedReader(new InputStreamReader(System.in)).readLine());
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    public double readDouble(String msg){
        double ret = 0;
        do {
            ok = true;
            try{
                ret = Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine());
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    public char readChar(String msg){
        char ret = ' ';
        do {
            ok = true;
            try{
                ret = (char) new BufferedReader(new InputStreamReader(System.in)).read();
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }

    public String readString(String msg){
        String ret = "";
        do {
            ok = true;
            try{
                ret = new BufferedReader(new InputStreamReader(System.in)).readLine();
            }catch (RuntimeException | IOException e){
                System.out.println(msg);
                ok = false;
            }
        }while(!ok);

        return ret;
    }
}
