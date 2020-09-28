import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;

public class CSV {
    private String fileName;

    public CSV(String fileName){
        this.fileName = fileName;
    }

    public Vector<Prodotto> readCSV(String fileName) throws IOException, ParseException {
        String row;
        int k = 0;  //per saltare la prima linea
        Vector<Prodotto> prodotti  = new Vector<Prodotto>();  //registro dei prodotti
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); //stabilisco un format base per la data
        GregorianCalendar gregorianCalendar = null;

        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));

        //inizio lettura da file
        while ((row = csvReader.readLine()) != null){

            String[] data = row.split(","); //salvo i dati della riga

            if(k == 0){ //salta la prima linea
                k++;
            }else{
                try {   //provo ad aprire il file
                    gregorianCalendar.setTime(simpleDateFormat.parse(data[12]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                prodotti.add(new Prodotto(Reparto.valueOf(data[0]), Scaffale.valueOf(data[1]), data[2], data[3], Long.parseLong(data[4]), Integer.parseInt(data[5]), Unitamisura.valueOf(data[6]), Float.parseFloat(data[7]), (data[8] != "-") ? Taglia.valueOf(data[8]): null, Integer.parseInt(data[9]), data[10], Integer.parseInt(data[11]), gregorianCalendar));


            }
        }
        return prodotti;
    }

    public Vector
}
