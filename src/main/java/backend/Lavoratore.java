package backend;

import java.util.ArrayList;
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

    //varaibili per check parametri in aggiungi lavoratore
    //boolean telefonoCheck=false;
    //boolean luogoCheck=false;
    //boolean nazionalitàCheck=false;

    public List<Lavoro> lavori; //elenco lavoro(<5 anni)
    //TODO: aggiungere lavoro al costruttore...
    public Lavoratore(String nome, String cognome, String luogoDiNascita, String nazionalità, String indirizzoEmail, String numeroTelefono,
                      Date dataDiNascita, Residenza residenza, String patente, boolean automunito,
                      Set<String> lingueParlate, List<Disponibilità> disponibilità, Set<String> esperienze, PersonaEmergenza personaEmergenza, List<Lavoro> lavori) throws Exception {
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
        this.lavori = lavori;



        boolean nazionalitàCheck=false;

        if(numberChecker(nazionalità))
            nazionalitàCheck=true;
    }

    public Lavoratore(){}

    public boolean isTelefonoCheck(String numeroTelefono) {
        boolean telefonoCheck=false;
        if(!numeroDiTelefonoCheck(numeroTelefono))
            telefonoCheck=true;
        return telefonoCheck;
    }

    public boolean isLuogoCheck(String luogoDiNascita) {
        boolean luogoCheck=false;
        if(numberChecker(luogoDiNascita))
            luogoCheck=true;
        return luogoCheck;
    }

    public boolean isNazionalitàCheck(String nazionalità) {
        boolean nazionalitàCheck=false;
        if(numberChecker(nazionalità))
            nazionalitàCheck=true;
        return nazionalitàCheck;
    }

    public boolean numeroDiTelefonoCheck(String numero){

        if(numero.equals(""))
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
        return string.equals("") || string.contains("0") || string.contains("1") || string.contains("2") || string.contains("3") || string.contains("4") || string.contains("5") ||
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


    public Boolean ricercaAnd(String nomeRicerca, String cognomeRicerca, String luogoRicerca, Periodo periodoRicerca, Boolean autoRicerca, String patenteRicerca, Set<String> lingueRicerca, Set<String> mansioniLavoratoreRicerca) {

        Date dataDefault=null;

        try {
            dataDefault = new Date(01, 01, 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(nomeRicerca.equals("") && cognomeRicerca.equals("") && luogoRicerca.equals("") &&
                autoRicerca == null && patenteRicerca == null && (periodoRicerca.getInizioPeriodo().equals(dataDefault) &&
                periodoRicerca.getFinePeriodo().equals(dataDefault)) && lingueRicerca.isEmpty() && mansioniLavoratoreRicerca.isEmpty())
            return false;

        if ((nomeRicerca.compareTo("") != 0 && getNome().compareTo(nomeRicerca) != 0) ||
                (cognomeRicerca.compareTo("") != 0 && getCognome().compareTo(cognomeRicerca) != 0) ||
                (luogoRicerca.compareTo("") != 0 && getResidenza().getCittà().compareTo(luogoRicerca) != 0) ||
                (autoRicerca != null && automunito != autoRicerca) ||
                (patenteRicerca != null && getPatente().compareTo(patenteRicerca) != 0)) {
            return false;
        }
        //verifica che la data non sia di default
        if (!(periodoRicerca.getInizioPeriodo().equals(dataDefault) && periodoRicerca.getFinePeriodo().equals(dataDefault))){
            for (Disponibilità disp : disponibilità) {
                if (periodoRicerca.getInizioPeriodo().equals(periodoRicerca.getFinePeriodo()) ||
                        !periodoRicerca.compareTo(disp.getPeriodo()))
                    return false;
            }
        }


        if(!lingueRicerca.isEmpty()){
            for(String lingua:lingueRicerca){
                if(!lingueParlate.contains(lingua))
                    return false;
            }
        }
        boolean flag;
        if(!mansioniLavoratoreRicerca.isEmpty()) {
            for (String mansione : mansioniLavoratoreRicerca) {
                flag=false;
                for (Lavoro lavoro : lavori) {
                    if (lavoro.getMansioniSvolte().contains(mansione))
                        flag=true;
                }
                if(!flag)
                    return false;
            }
        }
        return true;
    }
}
