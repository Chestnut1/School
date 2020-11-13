import java.sql.*;

public class TestStatement {
    public static void main(String args[]) {
        String URL = "jdbc:sqlite:test.db";
        String driver = "org.sqlite.JDBC";
        int iResult = 0;

        Connection con = null;
        ResultSet result;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL);
            System.out.println("Connessione fatta.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver non trovato");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore di connessione.");
        }
        if (con != null) {
            try {
                Statement stat1 = con.createStatement();
                result = stat1.executeQuery("SELECT * FROM impiegati;");
                Statement stat2 = con.createStatement();
                iResult = stat2.executeUpdate("INSERT INTO impiegati (nome, cognome, citta) VALUES ('Filo','Sganga','Paperopoli');");
                System.out.println("Record aggiunti: " + iResult);
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore di esecuzione query.");
            }
        }

    }
}