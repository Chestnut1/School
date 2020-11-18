import java.sql.*;

public class GestionePersonale {
    final String URL = "jdbc:sqlite:test.db";
    final String driver = "org.sqlite.JDBC";
    private Connection con;

    public GestionePersonale() throws SQLException {
        con = DriverManager.getConnection(URL);
    }

    /* Inserimento unità di personale nel database */
    public boolean aggiungiPersonale(Personale personale) {
        Statement stat;
        ResultSet result;
        String id_dipartimento;
        String data_nascita;
        try { // ricerca identificatore dipartimento a partire dal nome
            stat = con.createStatement();
            String query = "SELECT id_dipartimento FROM Dipartimento WHERE nome_dipartimento = '" + personale.getDipartimento() + "';";
            result = stat.executeQuery(query);
            result.next();
            id_dipartimento = result.getString(1);
            result.close();
            stat.close();
        }
        catch (SQLException exception) {
            return false;
        }
        try {
            stat = con.createStatement();
            data_nascita = personale.getDataNascita();
            //data_nascita = personale.getDataNascita().toString();
            String command = "INSERT INTO Personale(matricola, id_dipartimento, nominativo, data_nascita, qualifica, stipendio) VALUES ('" + personale.getMatricola() + "', " + id_dipartimento + ", '" + personale.getNominativo() + "', '" + data_nascita + "', '" + personale.getQualifica() + "', " + personale.getStipendio() + ");";
            if (stat.executeUpdate(command) == 0) {
                return false;
            }
            stat.close();
        }
        catch (SQLException exception) {
            return false;
        }
        return true;
    }

    /* Aggiornamento dati unità di personale nel database */
    public boolean aggiornaPersonale(Personale personale) {
        Statement stat;
        ResultSet result;
        String id_dipartimento;
        String data_nascita;

        try { // verifica presenza nel database unità di personale
            stat = con.createStatement();
            String query = "SELECT COUNT(*) AS numero FROM Personale WHERE matricola = '" + personale.getMatricola() + "';";
            result = stat.executeQuery(query);
            result.next();
            if (result.getInt(1) == 0) {
                return false;
            }
            result.close();
            stat.close();
        }
        catch (SQLException exception) {
            return false;
        }
        try { // ricerca identificatore dipartimento a partire dal nome
            stat = con.createStatement();
            String query = "SELECT id_dipartimento FROM Dipartimento WHERE nome_dipartimento = '" + personale.getDipartimento() +"';";
            result = stat.executeQuery(query);
            result.next();
            id_dipartimento = result.getString(1);
            result.close();
            stat.close();
        }
        catch (SQLException exception) {
            return false;
        }
        try {
            stat = con.createStatement();
            data_nascita = personale.getDataNascita();
            //data_nascita = personale.getDataNascita().toString();
            String command = "UPDATE Personale SET id_dipartimento=" + id_dipartimento + ", nominativo='" + personale.getNominativo() + "', data_nascita= '" + data_nascita + "', qualifica='" + personale.getQualifica() + "', stipendio=" + personale.getStipendio() + " WHERE matricola='" + personale.getMatricola() + "';";
            if (stat.executeUpdate(command) == 0) {
                return false;
            }
            stat.close();
        }
        catch (SQLException exception) {
            return false;
        }
        return true;
    }

    /* Ricerca nel database i dati di una unità di personale */
    public Personale datiPersonale(String matricola) {
        Personale personale;
        Statement stat;
        ResultSet result;
        String nominativo;
        String data_nascita;
        //Date data_nascita;
        String nome_dipartimento;
        String qualifica;
        double stipendio;

        try {
            stat = con.createStatement();
            String query = "SELECT * FROM Personale, Dipartimento WHERE Personale.id_dipartimento = Dipartimento.id_dipartimento AND matricola = '" + matricola + "';";
            result = stat.executeQuery(query);
            result.next();
            nominativo = result.getString("nominativo");
            data_nascita = result.getString("data_nascita");
            //data_nascita = result.getDate("data_nascita");
            nome_dipartimento = result.getString("nome_dipartimento");
            qualifica = result.getString("qualifica");
            stipendio = result.getDouble("stipendio");
            personale = new Personale( matricola, nome_dipartimento, nominativo, qualifica, data_nascita, stipendio);
            result.close();
            stat.close();
            return personale;
        }
        catch (SQLException exception) {
            return null;
        }
    }

    /* Ricerca nel database i dati di tutte le unità di personale */
    public Personale[] elencoPersonale() {
        Personale elenco_personale[];
        Statement stat;
        ResultSet result;
        int numero_personale;
        String matricola;
        String nominativo;
        String data_nascita;
        //Date data_nascita;
        String nome_dipartimento;
        String qualifica;
        double stipendio;

        try { // conteggio unità di personale presenti nel database
            stat = con.createStatement();
            String query = "SELECT COUNT(*) AS numero FROM Personale;";
            result = stat.executeQuery(query);
            result.next();
            numero_personale = result.getInt(1);
            if (numero_personale > 0) {
                elenco_personale = new Personale[numero_personale];
            }
            else {
                return null;
            }
            result.close();
            stat.close();
        }
        catch (SQLException exception) {
            return null;
        }
        try {
            stat = con.createStatement();
            String query = "SELECT * FROM Personale, Dipartimento WHERE Personale.id_dipartimento = Dipartimento.id_dipartimento;";
            result = stat.executeQuery(query);
            numero_personale = 0;
            while (result.next()) {
                matricola = result.getString("matricola");
                nominativo = result.getString("nominativo");
                data_nascita = result.getString("data_nascita");
                //data_nascita = result.getDate("data_nascita");
                nome_dipartimento = result.getString("nome_dipartimento");
                qualifica = result.getString("qualifica");
                stipendio = result.getDouble("stipendio");
                elenco_personale[numero_personale] = new Personale( matricola, nome_dipartimento, nominativo, qualifica, data_nascita, stipendio);
                numero_personale++;
            }
            result.close();
            stat.close();
            return elenco_personale;
        }
        catch (SQLException exception) {
            return null;
        }
    }

    /* Eliminazione unità di personale dal database */
    public boolean eliminaPersonale(String matricola) {
        Statement stat;
        ResultSet result;

        try {
            stat = con.createStatement();
            String command = " DELETE FROM Personale WHERE matricola = '" + matricola + "';";
            if (stat.executeUpdate(command) == 0) {
                return false;
            }
            stat.close();
        }
        catch (SQLException exception) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        String data_nascita = "1965-3-23";
        //Date data_nascita = new Date(65, 2, 23); // 23-3-1965
        Personale personale = new Personale( "01234","Meccanica","MEINI GIORGIO", "09",data_nascita,9999.99);
        GestionePersonale gestione_personale;
        Personale elenco_personale[];

        try {
            gestione_personale = new GestionePersonale();
        }
        catch (SQLException exception) {
            System.out.println("Errore connessione server DBMS.");
            return;
        }
        if (gestione_personale.aggiungiPersonale(personale)) {
            System.out.println("Unità di personale aggiunta al database.");
        }
        else {
            System.out.println("Errore aggiunta unità di personale.");
        }
        elenco_personale = gestione_personale.elencoPersonale();
        if (elenco_personale != null) {
            System.out.println("Elenco personale: ");
            for (int i=0; i<elenco_personale.length; i++) {
                System.out.println(elenco_personale[i]);
            }
        }
        else {
            System.out.println("Errore ricerca unità di personale.");
        }
        personale.setQualifica("00");
        personale.setStipendio(999.99);
        if (gestione_personale.aggiornaPersonale(personale)) {
            System.out.println("Unità di personale del database aggiornata.");
        }
        else {
            System.out.println("Errore aggiornamento unità di personale.");
        }
        personale = gestione_personale.datiPersonale("01234");
        if (personale != null) {
            System.out.println("Unità di personale: " + personale);
        }
        else {
            System.out.println("Errore ricerca unità di personale.");
        }
        if (gestione_personale.eliminaPersonale("01234")) {
            System.out.println("Unità di personale eliminata dal database.");
        }
        else {
            System.out.println("Errore eliminazione unità di personale.");
        }
    }
}