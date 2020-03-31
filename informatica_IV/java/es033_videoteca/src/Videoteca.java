public class Videoteca {
    private String name = "";
    private String address = "";
    private int MAX_PROTUDCTS = 10000;
    private Cassetta[] store;
    private int number_of_item = 0; //numero di prodotti dentro lo store

    public Videoteca(String name, String address){
        this.name = name;
        this.address = address;
        store = new Cassetta[MAX_PROTUDCTS];
        for (int i = 0; i < MAX_PROTUDCTS; i++){
            store[i] = new Cassetta();
        }
    }

    public void addCassetta(Cassetta c){
        store[number_of_item] = c;
        number_of_item++;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void sell(int code){
        for (int i = 0; i < number_of_item; i++){
            if(store[i].getCode() == code) {
                store[i].setCopies(0);
                return;
            }
        }
        number_of_item--;
        return;
    }

    public int buy(Cassetta c){
        number_of_item++;
        store[number_of_item] = c;
    }

    public double getStorePrice(){
        double ret;
        for (int i = 0; i<number_of_item; i++){
            ret +=
        }
    }

    @Override
    public String toString() {
        return "";
    }
}
