package backend;

import java.util.List;
import java.util.Set;

public class Lavoratore extends Persona{

    private Residenza residenza;
    private String patente;
    private boolean automunito;
    private Date dataDiNascita;
    private String luogoDiNascita, nazionalità;
    private PersonaEmergenza personaEmergenza;
    public Set<String> lingueParlate; //conterrà le lingue che conosce il lavoratore
    public List<Disponibilità> disponibilità;
    public Set<String> esperienze; //esperienze/specializzazioni del lavoratore

    public Lavoratore(String nome, String cognome, String luogoDiNascita, String nazionalità, String indirizzoEmail, String numeroTelefono,
                      Date dataDiNascita, Residenza residenza, String patente, boolean automunito,
                      Set<String> lingueParlate, List<Disponibilità> disponibilità, Set<String> esperienze, PersonaEmergenza personaEmergenza) throws Exception {
        super(nome, cognome, numeroTelefono, indirizzoEmail);
        this.luogoDiNascita = luogoDiNascita;
        this.nazionalità = nazionalità;
        this.dataDiNascita = dataDiNascita; //si usa date picker, è un tipo Date controlli già apposto
        this.residenza = residenza; //già controllato nella classe
        this.patente = patente; //ipotizzo una singola lettera (A, B, C, D) in ordine crescente simile all'es fatto da Spoto
        this.automunito = automunito; //verificare se ha senso
        this.lingueParlate = lingueParlate;
        this.disponibilità = disponibilità;
        this.esperienze = esperienze; //TODO da controllare?
        this.personaEmergenza = personaEmergenza; //controlli nella classe

        if(!numeroDiTelefonoCheck(numeroTelefono) || numberChecker(luogoDiNascita) || numberChecker(nazionalità))
            throw new IllegalArgumentException("Parametri lavoratore errati");
    }

    public Lavoratore(){}

    public boolean numeroDiTelefonoCheck(String numero){

        if(numero == null)
            return true;
        else if(numero.length() != 10)
            return false;

        for(int i = 0; i < numero.length(); i++){
            if(numero.charAt(i) < '0' || numero.charAt(i) > '9')
                return false;
        }

        return true;
    }

    private boolean numberChecker(String string){
        return string.contains("0") || string.contains("1") || string.contains("2") || string.contains("3") || string.contains("4") || string.contains("5") ||
                string.contains("6") || string.contains("7") || string.contains("8") || string.contains("9");
    }

    public void setDisponibilità(List<Disponibilità> disponibilità) {
        this.disponibilità = disponibilità;
    }

    @Override
    public String toString() {
        return super.toString() + "Lavoratore{" +
                "residenza=" + residenza +
                ", patente='" + patente + '\'' +
                ", automunito=" + automunito +
                ", dataDiNascita=" + dataDiNascita +
                ", luogoDiNascita='" + luogoDiNascita + '\'' +
                ", nazionalità='" + nazionalità + '\'' +
                ", personaEmergenza=" + personaEmergenza +
                ", lingueParlate=" + lingueParlate +
                ", disponibilità=" + disponibilità +
                ", esperienze=" + esperienze +
                '}';
    }

    public Residenza getResidenza() {
        return residenza;
    }

    public String getPatente() {
        return patente;
    }

    public boolean isAutomunito() {
        return automunito;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public String getLuogoDiNascita() {
        return luogoDiNascita;
    }

    public String getNazionalità() {
        return nazionalità;
    }

    public PersonaEmergenza getPersonaEmergenza() {
        return personaEmergenza;
    }



}
