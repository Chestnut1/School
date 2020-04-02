import java.util.Vector;

public class Treno {
    private String codice;
    private int portataMaxMotrice;
    private Vector<Vagone> vagoni;

    public Treno(String codice, int portataMaxMotrice) throws  ErroreValoreNonValido{
        vagoni = new Vector<Vagone>();
        this.codice = codice;
        if(portataMaxMotrice>=0) this.portataMaxMotrice = portataMaxMotrice;
        else throw new ErroreValoreNonValido("Portata massima non valida");
    }

    public void Aggancia(Vagone v){
        vagoni.add(v);
    }

    public void sgancia(Vagone v){
        boolean found = false;
        for(int i=0; i<vagoni.size() && !found; i++){
            if(vagoni.elementAt(i).getCodice().equals(v.getCodice())){
                found = true;
                vagoni.remove(i);
            }
        }
    }

    public int getPesoComplessivo(){
        int pesoComplessivo = 0;
        for(int i=0; i<vagoni.size(); i++){
            if(vagoni.elementAt(i)instanceof VagoneMerci) pesoComplessivo += (vagoni.elementAt(i).getPesoVuoto() + ((VagoneMerci) vagoni.elementAt(i)).getPesoEffettivo());
            if(vagoni.elementAt(i)instanceof VagonePasseggeri) pesoComplessivo += (vagoni.elementAt(i).getPesoVuoto() + ((VagonePasseggeri) vagoni.elementAt(i)).getPostiOccupati()*((VagonePasseggeri)vagoni.elementAt(i)).getPesoPersona());
        }
        return pesoComplessivo;
    }

    //GET

    public String getCodice() {
        return codice;
    }

    public int getPortataMaxMotrice() {
        return portataMaxMotrice;
    }

    //SET

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setPortataMaxMotrice(int portataMaxMotrice) throws ErroreValoreNonValido{
        if(portataMaxMotrice>=0) this.portataMaxMotrice = portataMaxMotrice;
        else throw new ErroreValoreNonValido("Portata massima non valida");
    }
}
