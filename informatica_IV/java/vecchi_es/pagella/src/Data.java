public class Data {
    //declaration of attributes
    public int g;
    public int m;
    public int a;

    //methods
    public Data(int g, int m, int a){
        int []v = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(m>0 && m<13){
            this.m = m;     //this assegna il valore alla propretà m all'ggetto su cui sto lavorando
        }else{
            this.m = 1;
        }

        if(v[m-1] >= g && g >= 0){
            this.g = g;
        }else{
            this.g = 1;
        }

        if(a>2018 && a<2021){
            this.a = a;
        }else{
            this.a = 2019;
        }
    }

    public String toString(){
        String s = "";

        s = g + "/" + m + "/" + a;
        return s;
    }

    public void setG(int g){
        int []v = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(v[this.m-1] >= g && g >= 0){
            this.g = g;
        }else{
            this.g = 1;
        }
    }

    public void setM(int m){
        if(m>0 && m<13) this.m=m;
        else this.m = 1;
    }

    public void setA(int a){
        if(a>0 && a<2020) this.a = a;
        else this.a = 2019;
    }

    public int getG(){
        return this.g;
    }

    public int getM(){
        return this.m;
    }

    public int getA(){
        return this.a;
    }
}
