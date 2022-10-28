package backend;

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

    public DipendenteAgenzia(){}

    public String getLuogoDiNascita() {
        return luogoDiNascita;
    }

    public void setLuogoDiNascita(String luogoDiNascita) {
        this.luogoDiNascita = luogoDiNascita;
    }

    public String getNazionalità() {
        return nazionalità;
    }

    public void setNazionalità(String nazionalità) {
        this.nazionalità = nazionalità;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }
}
