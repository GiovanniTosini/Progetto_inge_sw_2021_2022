package backend;

import java.util.regex.Matcher;
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
        boolean nomeCheck=false;
        if(numberChecker(nome))
            nomeCheck=true;
        return nomeCheck;
    }

    public boolean isCognomeCheck(String cognome) {
        boolean cognomeCheck=false;
        if(numberChecker(cognome))
            cognomeCheck=true;
        return cognomeCheck;
    }

    public boolean isMailCheck(String indirizzoEmail) {
        boolean mailCheck=false;
        if(!mailChecker(indirizzoEmail))
            mailCheck=true;
        return mailCheck;
    }

    /*
                verifica dell'indirizzo email tramite regex per il grosso delle cose
                più verifica se è presente più di una @ (errore nel caso)
                 */
    private boolean mailChecker(String indirizzoEmail){
         if(!indirizzoEmail.equals("")) {
             Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");
             Matcher matcher = pattern.matcher(indirizzoEmail);
             int counter = 0;
             for (int i = 0; i < indirizzoEmail.length(); i++) {
                 if (indirizzoEmail.charAt(i) == '@')
                     counter++;
                 if (counter > 1) {
                     return false;
                 }
             }
             return matcher.matches();
         }else{
             return false;
         }
    }

    /*
    ritorna true se la stringa contiene almeno un numero
     */
    private boolean numberChecker(String string){
        return string.equals("") || string.contains("0") || string.contains("1") || string.contains("2") || string.contains("3") || string.contains("4") || string.contains("5") ||
                string.contains("6") || string.contains("7") || string.contains("8") || string.contains("9");
    }

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
