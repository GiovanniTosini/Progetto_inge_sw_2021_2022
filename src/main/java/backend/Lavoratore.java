package backend;

import java.util.Set;

public class Lavoratore extends Persona{

    private Residenza residenza;
    private char patente;
    private boolean automunito;
    private Date dataDiNascita;
    private String luogoDiNascita, nazionalità;
    private Persona personaEmergenza;
    public Set<String> lingueParlate; //conterrà le lingue che conosce il lavoratore
    public Set<String> comuni;
    public Set<String> esperienze; //esperienze/specializzazioni del lavoratore

    public Lavoratore(String nome, String cognome, String luogoDiNascita, String nazionalità, String indirizzoEmail, String numeroTelefono,
                      Date dataDiNascita, Residenza residenza, char patente, boolean automunito,
                      Set<String> lingueParlate, Set<String> comuni, Set<String> esperienze, Persona personaEmergenza) throws Exception {
        super(nome, cognome, numeroTelefono, indirizzoEmail);
        this.luogoDiNascita = luogoDiNascita;
        this.nazionalità = nazionalità;
        this.dataDiNascita = dataDiNascita;
        this.residenza = residenza;
        this.patente = patente; //ipotizzo una singola lettera (A, B, C, D) in ordine crescente simile all'es fatto da Spoto
        this.automunito = automunito; //verificare se ha senso
        this.lingueParlate = lingueParlate;
        this.comuni = comuni;
        this.esperienze = esperienze;
        this.personaEmergenza = personaEmergenza;
    }
}
