public class Test {
    public static void main(String[] args) {
        //lavoratore normale
        Lavoratore Giulio = new Lavoratore("Giulio",7);
        Giulio.setSalary(1200);
        System.out.println(Giulio.printSalary());

        //lavoratore con straordinari
        LavoratoreConStraordinariPagati Pino = new LavoratoreConStraordinariPagati("Pino",8,3);
        Pino.setSalary(1200);
        System.out.println(Pino.printSalary());
    }
}
