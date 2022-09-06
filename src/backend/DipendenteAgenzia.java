public class DipendenteAgenzia extends Persona{

    private String luogoDiNascita, nazionalità, login, password;
    private Date dataDiNascita;

    public DipendenteAgenzia(String nome, String cognome, String numeroTelefono, String indirizzoEmail, String luogoDiNascita, Date dataDiNascita,
                             String nazionalità, String login, String password) {
        super(nome, cognome, numeroTelefono, indirizzoEmail);
        this.luogoDiNascita = luogoDiNascita;
        this.dataDiNascita = dataDiNascita;
        this.nazionalità = nazionalità;
        this.login = login;
        this.password = password;
    }
}
