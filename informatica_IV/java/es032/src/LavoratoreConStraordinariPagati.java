public class LavoratoreConStraordinariPagati extends Lavoratore{
    private int extraHours;         //ore di straordinario
    private static final double EXTRA = 10.0;   //retribuzione all'ora straordinaria


    public LavoratoreConStraordinariPagati(String name, int level, int extraHours){
        super(name, level);
        this.extraHours = (extraHours >= 0 ) ? extraHours: 0;
    }

    public String printExtra(){
        return super.getName() + "->|ORE STRAORDINARIO|" + "         " + extraHours;
    }

    public String printSalary(){
        return super.getName() + " stipendio: " + (super.getSalary()+extraHours*EXTRA);
    }

    public int getExtraHours(){
        return extraHours;
    }
}
