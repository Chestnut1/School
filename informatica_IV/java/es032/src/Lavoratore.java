public class Lavoratore {
    private String name = "";   //nome del lavoratore
    private int level;          //livello del lavoratore
    private int salary;         //salario del lavoratore
    private final int LVL_MIN = 0;  //limiti per livello e salario
    private final int LVL_MAX = 10;
    private final int SLR_MIN = 800;
    private final int SLR_MAX = 2500;

    public Lavoratore(String name, int level){
        this.level = (level >= LVL_MIN && level <= LVL_MAX) ? level: LVL_MIN;
        this.name = name;
    }

    public String printSalary(){
        return "lavoratore: " + name + "    ->    " + salary;
    }

    public int getSalary(){
        return salary;
    }

    public int getLevel(){
        return level;
    }

    public String getName(){
        return name;
    }

    public void setLevel(int level) {
        this.level = (level >= LVL_MIN && level <= LVL_MAX) ? level: LVL_MIN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = (salary >= SLR_MIN && salary <= SLR_MAX) ? salary: SLR_MIN;
    }
}