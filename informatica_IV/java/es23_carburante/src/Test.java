import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        Carburante carburante_conveniente = new Carburante();

        /*
        carburante_conveniente.add(12.4f);
        carburante_conveniente.add(123.1f);
         */

        System.out.println(carburante_conveniente.toString());
        System.out.println(carburante_conveniente.min());
        System.out.println(carburante_conveniente.max());
        System.out.println(carburante_conveniente.media());
    }
}
