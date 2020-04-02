import java.lang.Math;
public class Rettangolo {
    private float width;
    private float height;

    public Rettangolo(){
        this.width = 0;
        this.height = 0;
    }

    public Rettangolo(float width, float height){
        this.width = (width>=0) ? width: 0;
        this.height = (height>=0) ? height: 0;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getArea(){
        return width*height;
    }

    public float getPerimeter(){
        return (height + width)*2;
    }

    public void setWidth(float width){
        this.width = (width>=0) ? width: 0;
    }

    public void setHeight(float height) {
        this.height = (height>=0) ? height: 0;
    }

    @Override
    public String toString() {
        return "Rettangolo{" +
                "base=" + this.getWidth() + "|altezza=" + this.getHeight() + "|area=" + this.getArea() + "|perimetro" + this.getPerimeter() +
                '}';
    }
}