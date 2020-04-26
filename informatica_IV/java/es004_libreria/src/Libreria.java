import java.util.Vector;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
        /*First Employee
        JSONObject employeeDetails = new JSONObject();
        employeeDetails.put("firstName", "Lokesh");
        employeeDetails.put("lastName", "Gupta");
        employeeDetails.put("website", "howtodoinjava.com");

        JSONObject employeeObject = new JSONObject();
        employeeObject.put("employee", employeeDetails);*/

        JSONObject dettagliLibro = new JSONObject();
        JSONObject dettagliAurore = new JSONObject();
        JSONObject autore = new JSONObject();
        JSONObject libro = new JSONObject();
        JSONArray listaLibri = new JSONArray();
        Vector<JSONObject> libreria = new Vector<JSONObject>();
        Vector<JSONObject> listaDettagliAutore = new Vector<JSONObject>();
        Vector<JSONObject> listaDettagliLibro = new Vector<JSONObject>();

        for(int i =0; i<libri.size(); i++) {
            libreria.add(new JSONObject());
            listaDettagliAutore.add(new JSONObject());
            listaDettagliLibro.add(new JSONObject());



            listaDettagliAutore.elementAt(i).put("nome", libri.elementAt(i).getAutore().getNome());
            listaDettagliAutore.elementAt(i).put("cognome", libri.elementAt(i).getAutore().getCognome());

            listaDettagliLibro.elementAt(i).put("autore", listaDettagliAutore.elementAt(i));
            listaDettagliLibro.elementAt(i).put("titolo", libri.elementAt(i).getTitolo());
            listaDettagliLibro.elementAt(i).put("numero pagine", String.valueOf(libri.elementAt(i).getNumeroPagine()));
            libreria.elementAt(i).put("libro",listaDettagliLibro.elementAt(i));



            listaLibri.add(libreria.elementAt(i));

            System.out.println(listaLibri);
        }

        //Write JSON file
        try (FileWriter file = new FileWriter(nomeFile)) {


            file.write(listaLibri.toJSONString());
            file.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addLibro(JSONObject lib){

    }

}