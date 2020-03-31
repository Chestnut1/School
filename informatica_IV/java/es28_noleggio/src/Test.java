import java.util.Date;
import java.util.GregorianCalendar;

public class Test {
    public static void main(String[] args) {
        Genre horror = Genre.HORROR;
        Genre dramma = Genre.DRAMMA;
        Genre bambini = Genre.BAMBINI;
        Genre avventura = Genre.AVVENTURA;

        Shop video_noleggio = new Shop("Pizzaplanet");

        Product frozen = new Product("Frozen" , bambini, 3.0f);
        Product interstellar = new Product("Interstellar" , avventura , 2.5f);

        video_noleggio.take("Luca" , frozen, new GregorianCalendar(2020,2,6));

        System.out.println(video_noleggio.showTaken());

        System.out.println(video_noleggio.back(frozen,new GregorianCalendar(2020,2,9)));


    }

}
