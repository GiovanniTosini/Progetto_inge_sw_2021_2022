package backend;

public class Residenza {

    private String via, città, provincia;

    boolean cittàCheck=false;
    boolean provinciaCheck=false;

    public Residenza(String via, String città, String provincia){
            this.via = via;
            this.città = città;
            this.provincia = provincia;

            if(numberChecker(città))
                cittàCheck=true;
            if(numberChecker(provincia))
                provinciaCheck=true;
    }

    public Residenza(){}

    public boolean isCittàCheck() {
        return cittàCheck;
    }

    public boolean isProvinciaCheck() {
        return provinciaCheck;
    }

    @Override
    public String toString() {
        return via + ", " + città + ", " + provincia;
    }

    private boolean numberChecker(String string){
        return string.contains("0") || string.contains("1") || string.contains("2") || string.contains("3") || string.contains("4") || string.contains("5") ||
                string.contains("6") || string.contains("7") || string.contains("8") || string.contains("9");
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
