public class Residenza {

    private String via, città, provincia;

    public Residenza(String via, String città, String provincia){
            this.via = via;
            this.città = città;
            this.provincia = provincia;
    }

    @Override
    public String toString() {
        return via + ", " + città + ", " + provincia;
    }
}
