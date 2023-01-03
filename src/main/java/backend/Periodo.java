package backend;

import java.time.LocalDate;

public class Periodo {

    private Date inizioPeriodo, finePeriodo;

    public Periodo(Date inizioPeriodo, Date finePeriodo) {
        this.inizioPeriodo = inizioPeriodo;
        this.finePeriodo = finePeriodo;

        //se l'inizio periodo viene dopo il fine periodo non va bene
        //if(inizioPeriodo.compareTo(finePeriodo) > 0)
            //throw new IllegalArgumentException("Inizio periodo incorretto");
    }

    public Periodo(){}

    //torna true se il periodo this è contenuto all interno del periodo other
    public boolean compareTo(Periodo other){
        if ((this.inizioPeriodo.compareTo(other.inizioPeriodo)>=0) && (this.finePeriodo.compareTo(other.finePeriodo)<=0))
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Periodo{" +
                "inizioPeriodo=" + inizioPeriodo +
                ", finePeriodo=" + finePeriodo +
                '}';
    }

    public Date getInizioPeriodo() {
        return inizioPeriodo;
    }

    public Date getFinePeriodo() {
        return finePeriodo;
    }

    public boolean checkDefault(){
        Date dataDefault=null;
        try {
            dataDefault = new Date(01, 01, 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(inizioPeriodo==dataDefault ||finePeriodo==dataDefault){
            return false;
        }
        return true;
    }

    public boolean checkDate(){
        LocalDate mydate = LocalDate.now();

        Date date=new Date();
        date.setDay(mydate.getDayOfMonth());
        date.setMonth(mydate.getMonthValue());
        date.setYear(mydate.getYear());
        if(inizioPeriodo.compareTo(date)<0)
            return false;
        return inizioPeriodo.compareTo(finePeriodo)<0;
    }
}
