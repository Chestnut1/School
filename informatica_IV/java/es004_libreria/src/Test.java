public class Test {
    public static void main (String[] args){

        String nomefile = "libreria.json";

        //creating data
        Autore collodi = new Autore("Carlo", "Collodi");
        Autore perrault = new Autore("Charles","Perrault");
        Libreria libreria = new Libreria();
        Libro l1 = new Libro("Pinocchio", collodi, 150);
        Libro l2 = new Libro("Pollicino", perrault, 80);
        Libro l3 = new Libro("La bella addormentata nel bosco", perrault, 50);

        //insert data in structure
        libreria.addVolume(l1);
        libreria.addVolume(l2);
        libreria.addVolume(l3);

        //changing price
        Libro.setCostoPagina(0.01);
        System.out.println(libreria);

        //saving library on .JSON file
        libreria.salvaLibreria (nomefile);

        // creating a new empty library
        Libreria l = new Libreria();
        System.out.println("Prima " + l);

        // loading library from JSON file
        l.caricaLibreria(nomefile);
        System.out.println("Dopo: " + l.toString());
   }
}
