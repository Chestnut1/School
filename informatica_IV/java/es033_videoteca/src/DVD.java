import java.util.Arrays;

public class DVD extends Cassetta {
    private double price;
    private int nLanguages = 5;
    private TipoLingua languages[];

    public DVD(String title, int seconds){
        super(title,seconds);
        this.price = 0;
    }

    public void setPrice(double price) {
        this.price = (price > 0) ? price: 5.00;
    }

    public int getnLanguages() {
        //non so come fare
        return nLanguages;
    }

    public double getPrice() {
        return (price - price*(1/super.getDiscount()));
    }

    @Override
    public String toString() {
        return "DVD{" +
                "price=" + (price - price*(1/super.getDiscount())) +
                ", nLanguages=" + nLanguages +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }
}
