import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        int num1 = Keyboard.readInteger("Inserisci il numero 1:");

        System.out.println("num 1 = " + num1);

        num1 = Keyboard.readInteger("Inserisci il numero 1: ");
        System.out.println("num1 = " + num1);
    }
}
