package backend;

public class PersonaEmergenza extends Persona{

    public PersonaEmergenza(String nome, String cognome, String numeroTelefono, String indirizzoEmail) {
        super(nome, cognome, numeroTelefono, indirizzoEmail);

        if(!numeroDiTelefonoCheck(numeroTelefono))
            throw new IllegalArgumentException("Parametri persona emergenza errati");
    }

    public boolean numeroDiTelefonoCheck(String numero){

        if(numero.length() != 10)
            return false;

        for(int i = 0; i < numero.length(); i++){
            if(numero.charAt(i) < '0' || numero.charAt(i) > '9')
                return false;
        }

        return true;
    }
}
