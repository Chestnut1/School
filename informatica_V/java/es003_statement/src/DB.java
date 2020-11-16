import javax.xml.transform.Result;
import java.sql.*;

public class DB {

    private String URL = "jdbc:sqlite:fabbrica.db";
    private String DRIVER = "org.sqlite.JDBC";
    private Connection con = null;


    int iResult = 0;

    public DB(){
        // establish connection and set drivers
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL);
            System.out.println("Connessione fatta.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver non trovato");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore di connessione.");
        }
    }

    public DB(String url, String driver){

        this.URL = url;
        this.DRIVER = driver;


        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL);
            System.out.println("Connessione fatta.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver non trovato");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore di connessione.");
        }
    }

    public void setDRIVER(String DRIVER) {
        this.DRIVER = DRIVER;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String executeQuery(String query){
        ResultSet result = null;
        String txtresult = "";
        if (con != null) {
            try {
                Statement stat = con.createStatement();
                result = stat.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore di esecuzione query.");
            }
        }
        try {
            ResultSetMetaData rsmd = result.getMetaData();
            int column_number = rsmd.getColumnCount();

            while(result.next()){
                for(int i = 1; i <= column_number; i++){
                    if(i == column_number) txtresult +=  " " +result.getString(i) + "\n";
                    else txtresult +=  " " +result.getString(i) + ",";

                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return txtresult;
    }

    public int executeUpdate (String query){
        int result = 0;
        if (con != null) {
            try {
                Statement stat = con.createStatement();
                result = stat.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore di esecuzione query.");
            }
        }

        return result;
    }

    public void closeDB(){
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
