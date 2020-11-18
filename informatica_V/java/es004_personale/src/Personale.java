import java.util.*;

public class Personale {
    private String matricola;
    private String dipartimento;
    private String nominativo;
    private String qualifica;
    private String dataNascita;
    //private Date dataNascita;
    private double stipendio;

    public Personale( String matricola, String dipartimento, String nominativo, String qualifica, String dataNascita, double stipendio) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.nominativo = nominativo;
        this.qualifica = qualifica;
        this.dataNascita = dataNascita;
        this.stipendio = stipendio;
    }

    public Personale() {
        this.matricola = "";
        this.dipartimento = "";
        this.nominativo = "";
        this.qualifica = "";
        this.dataNascita = "";
        //this.dataNascita = new Date(0);
        this.stipendio = 0.0;
    }

    public Personale(Personale personale) {
        this.matricola = personale.getMatricola();
        this.dipartimento = personale.getDipartimento();
        this.nominativo = personale.getNominativo();
        this.qualifica = personale.getQualifica();
        this.dataNascita = personale.getDataNascita();
        this.stipendio = personale.getStipendio();
    }

    public String getMatricola() {
        return matricola;
    }
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getDipartimento() {
        return dipartimento;
    }
    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    public String getNominativo() {
        return nominativo;
    }
    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getQualifica() {
        return qualifica;
    }
    public void setQualifica(String qualifica) {
        this.qualifica = qualifica;
    }

    public String getDataNascita() {
        //public Date getDataNascita() {
        return dataNascita;
    }
    public void setDataNascita(String dataNascita) {
        //public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public double getStipendio() {
        return stipendio;
    }
    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public String toString() {
        return "Personale(" + matricola + "," + dipartimento + "," + nominativo + "," + qualifica + "," + dataNascita + "," + stipendio + ')';
    }
}