
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LibreriaJson {
    static Vector<Libro> libreria;


    public LibreriaJson(){
        libreria = new Vector<Libro>();
    }


    public void caricaLibreria(String nomeFile){
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(nomeFile))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray listaLibri = (JSONArray) obj;
            //System.out.println(listaLibri);

            //Iterate over employee array
            listaLibri.forEach( lib -> parseOgbjectLibro( (JSONObject) lib ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseOgbjectLibro(JSONObject l)
    {
        String nomeAutore;
        String cognomeAutore;
        String titolo;
        int pagineLibro;

        JSONObject libro = (JSONObject) l.get("libro");
        JSONObject autore = (JSONObject)  libro.get("autore");

        nomeAutore = (String) autore.get("nome");
        cognomeAutore = (String) autore.get("cognome");
        titolo = (String) libro.get("titolo");
        pagineLibro =Integer.parseInt((String) libro.get("numero pagine"));

        libreria.add(new Libro(titolo, new Autore(nomeAutore,cognomeAutore), pagineLibro));
    }

    @Override
    public String toString() {
        String out = "";
        for (int i =0; i<libreria.size();i++){
            out += libreria.elementAt(i).toString() + "\n";
        }
        return out;
    }
}
