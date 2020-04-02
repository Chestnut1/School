public class Cassetta{
    private int code;
    private String title;
    private int seconds;
    private double discount;
    private int copies;

    public Cassetta(String title, int seconds){
        this.title = title;
        this.seconds = (seconds > 0) ? seconds: 3600;
    }

    public Cassetta(){
        title = "";
    }

    public String getTitle() {
        return title;
    }

    public int getSeconds() {
        return seconds;
    }

    public double getDiscount() {
        return discount;
    }

    public int getCode() {
        return code;
    }

    public void setDiscount(double discount) {
        this.discount = (discount > 0) ? discount: 0;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCopies(int copies) {
        this.copies = (copies > 0) ? copies : 1;
    }

    @Override
    public String toString() {
        return "Cassetta{" +
                "code=" + code +
                ", title='" + title + '\'' +
                ", seconds=" + seconds +
                ", discount=" + discount +
                ", copies=" + copies +
                '}';
    }
}
