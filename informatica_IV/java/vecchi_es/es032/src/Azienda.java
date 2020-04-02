public class Azienda {
    private final int MAX_WORKERS = 1000;   //numero massimo di lavoratori
    private LavoratoreConStraordinariPagati[] company;
    public int workers = 0; //numero di lavoratori

    public Azienda(int workers){
        company = new LavoratoreConStraordinariPagati[MAX_WORKERS];
    }

    public void addWorker(LavoratoreConStraordinariPagati worker){
        if(workers<MAX_WORKERS){
            company[workers] = new LavoratoreConStraordinariPagati(worker.getName(),worker.getLevel(),worker.getExtraHours());
            workers++;
        }
    }

    public String seeCompany(){
        String out = "";
        for (int k = 0; k<workers;k++){
            out += company[k].getName() + " " company[k].getSalary() +  String.format("\n");
        }
        return out;
    }
}
