package backend;

import java.util.regex.Pattern;

public class Persona {

    private String nome, cognome, indirizzoEmail, numeroTelefono;

    public Persona(String nome, String cognome, String numeroTelefono, String indirizzoEmail){
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzoEmail = indirizzoEmail;
        this.numeroTelefono = numeroTelefono;
    }

    public Persona(){}

    public boolean isNomeCheck(String nome) {
        boolean nomeCheck=true;
        if(numberChecker(nome))
            nomeCheck=false;
        return nomeCheck;
    }

    public boolean isCognomeCheck(String cognome) {
        boolean cognomeCheck=true;
        if(numberChecker(cognome))
            cognomeCheck=false;
        return cognomeCheck;
    }

    /*
    verifica dell'indirizzo email tramite regex per il grosso delle cose
    più verifica se è presente più di una @ (errore nel caso)
     */
    public boolean mailChecker(String indirizzoEmail){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(indirizzoEmail).matches();
    }

    /*
    ritorna true se la stringa contiene almeno un numero
    cicla un carattere alla volta controllando il valose ASCII
     */
    public boolean numberChecker(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return false;
        }
        String regex = "^[A-Z][a-z ]*([ ][A-Z][a-z]*)*$";
        return inputString.matches(regex);
    }

    /*
    è un toString Ale che vuoi che faccia? il caffè?!
     */
    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", indirizzoEmail='" + indirizzoEmail + '\'' +
                ", numeroTelefono='" + numeroTelefono + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getIndirizzoEmail() {
        return indirizzoEmail;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }
}
