package backend;

public class Periodo {

    private Date inizioPeriodo, finePeriodo;

    public Periodo(Date inizioPeriodo, Date finePeriodo) {
        this.inizioPeriodo = inizioPeriodo;
        this.finePeriodo = finePeriodo;

        //se l'inizio periodo viene dopo il fine periodo non va bene
        if(inizioPeriodo.compareTo(finePeriodo) > 0)
            throw new IllegalArgumentException("Inizio periodo incorretto");
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
}
