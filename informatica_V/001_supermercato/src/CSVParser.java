import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Vector;

public class CSVParser {
    private String fileName;

    public CSVParser(String fileName){
        this.fileName = fileName;
    }

    public Vector<Prodotto> readCSV() throws IOException {
        String row;
        int k = 0;
        Vector<Prodotto> prodotti;
        prodotti = new Vector<Prodotto>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        GregorianCalendar gregorianCalendar = null;


        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            if (k == 0){
                k++;
            }else{
                try {
                    gregorianCalendar.setTime(simpleDateFormat.parse(data[13]));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                for(String value : data){
                    prodotti.add(new Prodotto(data[4],
                            Reparto.valueOf(data[0]),
                            Categoria.valueOf(data[1]),
                            data[2],
                            data[3],
                            Double.parseDouble(data[6]),
                            Long.parseLong(data[5]),
                            UnitaMisura.valueOf(data[7]),
                            Float.parseFloat(data[8]),
                            data[9],
                            Float.parseFloat(data[10]),
                            data[11],
                            data[12],
                            gregorianCalendar
                    ));
                }
            }


        }
        csvReader.close();
        return prodotti;
    }

    public void writeCSV(Vector <String> values, String fileName){
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String value : values){
            try {
                csvWriter.append(value);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            csvWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
