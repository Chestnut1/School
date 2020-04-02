import javax.swing.text.Element;
import java.util.Arrays;

public class VettoreInteri {
    private int dim;
    private int[] vector;

    private char sep = '|';

    public VettoreInteri(int dim){
        this.dim = (dim > 0) ? dim: 0;
        vector = new int[dim];

        //initialize vector to 0
        for (int i = 0; i < dim; i++){
            vector[i] = 0;
        }
    }

    public VettoreInteri(String elements) throws NumberFormatException{
        String number = "";
        /*
        ALTERNATIVE AND SHORTER METHOD

        String []vetS = elements.split("|");

        vector = new int[vetS.length];

        for(int i = 0; i < vetS.length; i++){
            vector[i] = Integer.parseInt(vetS[i]);
        }

         */

        for (int i = 0; i < elements.length(); i++){
            if(i == elements.length()-1 && (elements.charAt(i) == '0' || elements.charAt(i) == '1' || elements.charAt(i) == '2' || elements.charAt(i) == '3' || elements.charAt(i) == '4' || elements.charAt(i) == '5' || elements.charAt(i) == '6' || elements.charAt(i) == '7' || elements.charAt(i) == '8' || elements.charAt(i) == '9')){
                dim++;
            }else{
                if (elements.charAt(i) == sep){
                    dim++;
                }
            }
        }



        vector = new int[dim];
        int k = 0;

        for (int i = 0; i < elements.length(); i++){
            if(elements.charAt(i) != sep){
                if (elements.charAt(i) == '0' || elements.charAt(i) == '1' || elements.charAt(i) == '2' || elements.charAt(i) == '3' || elements.charAt(i) == '4' || elements.charAt(i) == '5' || elements.charAt(i) == '6' || elements.charAt(i) == '7' || elements.charAt(i) == '8' || elements.charAt(i) == '9'){
                    number = number + elements.charAt(i);
                }else{
                    NumberFormatException eccezione = new NumberFormatException();
                }
            }else{
                vector[k] = Integer.parseInt(number);
                k++;
                number = "";
            }

            if(i == elements.length()-1 && (elements.charAt(i) == '0' || elements.charAt(i) == '1' || elements.charAt(i) == '2' || elements.charAt(i) == '3' || elements.charAt(i) == '4' || elements.charAt(i) == '5' || elements.charAt(i) == '6' || elements.charAt(i) == '7' || elements.charAt(i) == '8' || elements.charAt(i) == '9')){
                vector[k] = Integer.parseInt(number);
            }
        }
    }

    public int getMin() throws ErroreVettoreVuoto{
        if(dim == 0){
            throw new ErroreVettoreVuoto("Impossibile trovare il minimo.");
        }else {
            int min = vector[0];
            for (int i = 1; i < dim; i++) {
                if (vector[i] < min) min = vector[i];
            }
            return min;
        }
    }

    public int search(int e) throws ErroreElementoEsistente{
        boolean found = false;
        for (int i = 0; i < dim && !found; i++){
            if (vector[i] == e) {
                return i;
            }
        }
        if (!found) throw new ErroreElementoEsistente();
        return -1;
    }

    public void eliminaElemento(int e) throws ErroreElementoEsistente{
        int position = search(e);
        for (int i = position; i < dim-(position); i++){
            vector[i] = vector[i+1];
        }
        dim--;
    }

    public int getDim() {
        return dim;
    }

    @Override
    public String toString() {
        String out = "";
        for(int i = 0; i < dim; i++){
            out += String.format("v[%d]\t\t->\t\t%d\n" , i, vector[i]);
        }
        return  out;
    }
}
