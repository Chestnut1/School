import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Libreria {
    private Vector<Libro> libri;

    public Libreria() {
        libri = new Vector<Libro>();
    }

    public void addVolume(Libro libro) {
        libri.add(libro);
    }

    @Override
    public String toString() {
        return "Libreria = " + libri ;
    }

    public void salvaLibreria(String nomeFile){
        /**
         * JSONObject: create an Object to insert in a JSON file.
         *
         * JSONArray:  create a list of JSONObjects.
         * **/
        JSONObject dettagliLibro = new JSONObject();
        JSONObject dettagliAurore = new JSONObject();
        JSONObject libro = new JSONObject();
        JSONArray listaLibri = new JSONArray();
        Vector<JSONObject> libreria = new Vector<JSONObject>();
        Vector<JSONObject> listaDettagliAutore = new Vector<JSONObject>();
        Vector<JSONObject> listaDettagliLibro = new Vector<JSONObject>();

        for(int i =0; i<libri.size(); i++) {    //iterate on every book in Vector<> libri
            libreria.add(new JSONObject());     //assign to JSONArray a generic JSONObject whose attributes will be defined below

            //create a generic JSONObject for book detail and Author details whose attributes will be defined below
            listaDettagliAutore.add(new JSONObject());
            listaDettagliLibro.add(new JSONObject());

            //DEFINING ATTRIBUTES
            listaDettagliAutore.elementAt(i).put("nome", libri.elementAt(i).getAutore().getNome());
            listaDettagliAutore.elementAt(i).put("cognome", libri.elementAt(i).getAutore().getCognome());

            listaDettagliLibro.elementAt(i).put("autore", listaDettagliAutore.elementAt(i));    //ad author to book Object\

            listaDettagliLibro.elementAt(i).put("titolo", libri.elementAt(i).getTitolo());
            listaDettagliLibro.elementAt(i).put("numero pagine", String.valueOf(libri.elementAt(i).getNumeroPagine()));
            libreria.elementAt(i).put("libro",listaDettagliLibro.elementAt(i));


            //add to JSONArray the new JSONObject
            listaLibri.add(libreria.elementAt(i));

            //System.out.println(listaLibri);
        }

        //Write JSON file
        try (FileWriter file = new FileWriter(nomeFile)) {
            file.write(listaLibri.toJSONString());  //write JSONArry into JSON file
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaLibreria(String nomeFile){

        //Start reading the .JSON file
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(nomeFile))
        {
            Object obj = jsonParser.parse(reader);

            JSONArray listaLibri = (JSONArray) obj; //Casting from Object to JSONArray the Array inside .JSON file

            //Iterate over books array
            /**
             * Similar to python iteration, lib assume each time iterated's book value and pass it to parseOgbjectLibro() function.
             *
             * parseOgbjectLibro(JSONObject lib, Vector<Libro> libreria): put in a Vector<Libro> libreria all objects read from
             *                                                            JSON file. Lib contains all the attributes
             *                                                            ant its values that are read from the function and are
             *                                                            used to instantiate a new Libro objcet inside the
             *                                                            Vector<Libro> libreria.
             *
             * **/
            listaLibri.forEach( lib -> parseOgbjectLibro((JSONObject)lib ,libri) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseOgbjectLibro(JSONObject l, Vector<Libro> libri)
    {

        /*
        * [{"libro":{"titolo":"Pinocchio","numero pagine":"150","autore":{"cognome":"Collodi","nome":"Carlo"}}},
           {"libro":{"titolo":"Pollicino","numero pagine":"80","autore":{"cognome":"Perrault","nome":"Charles"}}},
  {         "libro":{"titolo":"La bella addormentata nel bosco","numero pagine":"50","autore":{"cognome":"Perrault","nome":"Charles"}}}]
        * */
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

        libri.add(new Libro(titolo, new Autore(nomeAutore,cognomeAutore), pagineLibro));
    }

}