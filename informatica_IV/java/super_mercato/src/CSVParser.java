import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class CSVParser {
    private String fileName;

    public CSVParser(String fileName){
        this.fileName = fileName;
    }

    public void readCSV(Vector<Prodotto> prodotti) throws IOException {
        String row;

        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            // do something with the data
            for(String value : data){
                //
            }

        }
        csvReader.close();
    }

    public void writeCSV(Prodotto p){
        
    }

}
