public class CD extends Cassetta{
    static double price;
    private int tracks;

    public CD(String title, int seconds, int tracks){
        super(title,seconds);
        this.tracks = (tracks > 0) ? tracks: 1;
    }

    public int getTracks() {
        return tracks;
    }

    public double getPrice() {
        return (price-price*(1/super.getDiscount()));
    }

    public void setPrice(double price) {
        this.price = (price > 0) ? price: 5.00;
    }

    @Override
    public String toString() {
        return "CD{" +
                "title=" + super.getTitle() +
                "seconds=" + super.getSeconds()+
                "tracks=" + tracks +
                "price=" + (price-price*(1/super.getDiscount())) +
                '}';
    }
}
