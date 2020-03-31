import java.util.GregorianCalendar;

public class Noleggio {
    private String name;
    private Product product;
    private GregorianCalendar dateTake;
    private GregorianCalendar dateBack;

    public Noleggio(String name, Product product, GregorianCalendar dateTake){
        this.name = name;
        this.product = product;
        this.dateTake = dateTake;
        this.product.take();
    }

    public long dateTake(){
        return dateTake.getTimeInMillis();
    }

    public float dailyPrice(){
        return product.dailyPrice();
    }

    public boolean taken(){
        return product.taken();
    }

    public long dateBack(){
        return dateBack.getTimeInMillis();
    }

    public void dateBack(GregorianCalendar dateBack){
        this.dateBack = dateBack;
        product.back();
    }

    @Override
    public String toString() {
        return product.toString() + String.format("\t\t%s\t\t" , name) + dateTake.toString();
    }
}
