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
        boolean cittàCheck=false;
        if(numberChecker(città) || !isFieldNull(città))
            cittàCheck=true;
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

    private boolean numberChecker(String string){
        for(int i = 0; i < string.length(); i++){
            if(((int)string.charAt(i) < 65 || (int)string.charAt(i) > 90) &&
                    ((int)string.charAt(i) < 97 || (int)string.charAt(i) > 122))
                return true;
        }
        return false;
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
