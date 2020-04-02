import javax.xml.namespace.QName;
import java.util.GregorianCalendar;
import java.util.Vector;

public class Shop {
    private String name;
    Vector<Noleggio> products = new Vector<Noleggio>();

    public Shop(String name){
        this.name = name;
    }

    public String name(){
        return this.name;
    }

    public void name(String name){
        this.name = name;
    }

    public void take(String clientName, Product product, GregorianCalendar takeDate){
        products.add(new Noleggio(clientName, product, takeDate));
    }

    public String back(Noleggio product, GregorianCalendar dateBack){
        product.dateBack(dateBack);
        return "Need to pay " +(((((((int)product.dateBack() - (int) product.dateTake())/1000)/60)/60)/24)*product.dailyPrice())+ "";
    }

    public String showTaken(){
        String out = "";
        for(int i = 0; i < products.size(); i++){
            out += (products.elementAt(i).taken()) ? products.elementAt(i).toString(): "";
        }
        return out;
    }

    @Override
    public String toString() {
        String out = "";
        for(int i = 0; i < products.size(); i++){
            out += products.elementAt(i).toString();
        }
        return out;
    }
}
