public class Test {
    public static void main(String[] args){
        Data d; //dichiarazione
        d = new Data(18, 10, 2019);
        System.out.println(d.toString());

        d.setG(32);
        System.out.println(d.toString());

        Voto v1 = new Voto(d,7,0.5f,'s');
        Voto v = new Voto(new Data(24,10,2019),9f,1f,'o');

        System.out.println(v1.toString());
        System.out.println(v.toString());
    }
}