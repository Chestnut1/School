public class Test {
    public static void main(String[] args) {
        Scuola itis = new Scuola("Mario Delpozzo");

        itis.addClasse(new ClasseConAlunni(4,"A^rob", 21));
        System.out.println(itis.toString());
    }
}
