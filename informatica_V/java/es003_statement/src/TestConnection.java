import java.sql.*;

public class TestConnection {

    public static void main(String args[]) {
        Connection con = null;
        String URL = "jdbc:sqlite:test.db";
        String driver = "org.sqlite.JDBC";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL);
            System.out.println("Connessione fatta.");
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver non trovato");
        } catch (SQLException e) {
            System.out.println("Errore di connessione.");
        }
    }
}