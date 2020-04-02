import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        VettoreInteri v1 = null;
        boolean ok = true;
        try{
            v1 = new VettoreInteri("10|13|321|32|2|4|7");
        }catch (NumberFormatException e){
            System.out.println("Stringa non valida");
            ok = false;
        }
        if(ok) {
            System.out.println(v1.toString());
            System.out.println(v1.getMin());
        }

        ok = true;
        try{
            v1.eliminaElemento(13);
        }catch(Exception e){
            System.out.println("Elemento non valido");
            ok = false;
        }
        if (ok) System.out.println(v1.toString());
    }
}
