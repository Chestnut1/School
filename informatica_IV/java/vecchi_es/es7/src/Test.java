public class Test {
    public static void main(String[] args) {
        Temperatura gradi = new Temperatura(0f);

        System.out.println(gradi.getCelsius());
        System.out.println(gradi.getFahrenheit());

        gradi.setCelsius(10f);
        System.out.println(gradi.getCelsius());
        System.out.println(gradi.getFahrenheit());

        System.out.println(gradi.toString());


    }
}
