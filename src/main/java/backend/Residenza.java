package backend;

public class Residenza {

    private String via, città, provincia;
    public Residenza(String via, String città, String provincia){
            this.via = via;
            this.città = città;
            this.provincia = provincia;

    }

    private boolean isFieldNull(String stringa) {
        if(stringa.equals(""))
            return false;
        else return true;
    }

    public Residenza(){}

    public boolean isCittàCheck(String città) {
        boolean cittàCheck=true;
        if(numberChecker(città) || !isFieldNull(città))
            cittàCheck=false;
        return cittàCheck;
    }

    public boolean isViaCheck(String via) {
        boolean viaCheck=false;
        if(!isFieldNull(via))
            viaCheck=true;
        return viaCheck;
    }

    @Override
    public String toString() {
        return via + ", " + città + ", " + provincia;
    }

    public boolean numberChecker(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return false;
        }
        String regex = "^[A-Z][a-z ]*([ ][A-Z][a-z]*)*$";
        return inputString.matches(regex);
    }

    public String getVia() {
        return via;
    }

    public String getCittà() {
        return città;
    }

    public String getProvincia() {
        return provincia;
    }

}
