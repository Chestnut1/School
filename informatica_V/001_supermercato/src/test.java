public class test {
    public static void main(String[] args) {
        try {
            Supermercato s = new Supermercato("coop", "megazzino", "data.csv");
            Menu m = new Menu();
            m.menu(s);
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
