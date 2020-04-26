public class Test2 {
    public static void main(String[] args) {
        // creazione nuova libreria vuota
        LibreriaJson l = new LibreriaJson();
        System.out.println("Prima " + l);
        // caricamento libreria da file METODO DA IMPLEMENTARE
        l.caricaLibreria("libreria.json");
        System.out.println("Dopo: " + l.toString());
    }
}
