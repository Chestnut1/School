public class VagonePasseggeri extends Vagone {
    private int classe;
    private int postiTotali;
    private int postiOccupati;
    private static final int PESO_PERSONA = 75;

    public VagonePasseggeri(String codice, String aziendaCostruttrice, int pesoVuoto, int annoCostruzione, int classe, int postiTotali, int postiOccupati) throws ErroreValoreNonValido {
        super(codice, aziendaCostruttrice, pesoVuoto, annoCostruzione);

        if(classe == 1 || classe == 2 || classe ==3) this.classe = classe;
        else throw new ErroreValoreNonValido("Classe inserita inesistente.");

        if(postiTotali > 0) this.postiTotali = postiTotali;
        else throw new ErroreValoreNonValido("Valore posti totali non valido.");

        if(postiOccupati>=0 && postiOccupati<=postiTotali) this.postiOccupati = postiOccupati;
        else throw new ErroreValoreNonValido("Valore posti occupati non valido");
    }

    //GET

    public int getClasse() {
        return classe;
    }

    public int getPostiOccupati() {
        return postiOccupati;
    }

    public static int getPesoPersona() {
        return PESO_PERSONA;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    //SET

    public void setClasse(int classe) throws ErroreValoreNonValido {
        if(classe == 1 || classe == 2 || classe ==3) this.classe = classe;
        else throw new ErroreValoreNonValido("Classe inserita inesistente.");
    }

    public void setPostiOccupati(int postiOccupati) throws ErroreValoreNonValido {
        if(postiOccupati>=0 && postiOccupati<=postiTotali) this.postiOccupati = postiOccupati;
        else throw new ErroreValoreNonValido("Valore posti occupati non valido");
    }

    public void setPostiTotali(int postiTotali) throws ErroreValoreNonValido {
        if(postiTotali > 0) this.postiTotali = postiTotali;
        else throw new ErroreValoreNonValido("Valore posti totali non valido.");
    }
}
