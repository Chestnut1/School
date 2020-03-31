public class Test {
    public static void main(String[] args) {
        final int CLASSI_MAX = 20;
        final int MIN_ALUNNI = 15;
        final int MAX_ALUNNI = 30;

        int classi[] = new int[CLASSI_MAX];
        int alunniTot = 0;
        float mediaAlunni;
        int i;

        for (i = 0; i<CLASSI_MAX; i++){
            classi[i] = (int) ((Math.random()*(MAX_ALUNNI-MIN_ALUNNI+1)+MIN_ALUNNI));
        }

        for ( i = 0; i<CLASSI_MAX; i++){
            alunniTot += classi[i];
        }
    if (CLASSI_MAX>0) mediaAlunni= (float) alunniTot/CLASSI_MAX;  //

        System.out.println("alunni tot = " + alunniTot + " media per classe = " + mediaAlunni);
    }
}
