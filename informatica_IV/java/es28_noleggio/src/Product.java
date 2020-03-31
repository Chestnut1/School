public class Product {
    private String title;
    private Genre genre;
    private float dailyPrice;
    private boolean taken;

    public Product(String title, Genre genre, float dailyPrice){
        this.title = title;
        this.genre = genre;
        this.dailyPrice = (dailyPrice > 0) ? dailyPrice: 2.5f;
    }

    public void take(){
        this.taken = true;
    }

    public float dailyPrice(){
        return dailyPrice;
    }

    public void back(){
        this.taken = false;
    }

    public boolean taken(){
        return taken;
    }

    public String toString(){
        return String.format("%s\t\t%s\t\t%.2f", title, genre, dailyPrice);
    }

}

