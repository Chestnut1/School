
import org.w3c.dom.html.HTMLParagraphElement;

import java.lang.*;
import java.io.*;

import java.sql.*;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Connection conn;
        String URL = "jdbc:sqlite:test.db";
        String driver = "org.sqlite.jdbc";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(URL);   //qui fa la connessione
            conn.close();
        }catch(ClassNotFoundException e){
            System.out.println("Driver non trovato.\n");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
