public class Test {
    public static void main(String[] args) throws ValoreNonValido {
        Compagnia spacex = new Compagnia("SpaceX");
        Sito sito = new Sito("Petroliera potente", "america");
        PozzoMarino pozzo_nel_mare = new PozzoMarino(270.0f,25);
        PozzoTerrestre pozzo_sulla_terra = new PozzoTerrestre(12, TipoTerreno.ROCCIOSO);

        System.out.println(pozzo_nel_mare.toString());
        System.out.println(pozzo_sulla_terra.toString());

        sito.addPozzo(pozzo_nel_mare);
        pozzo_sulla_terra.spegni();
        sito.addPozzo(pozzo_sulla_terra);

        spacex.addSito(sito);

        System.out.println(spacex.toString());

        System.out.println(sito.greggioAnnuo());

    }
}
