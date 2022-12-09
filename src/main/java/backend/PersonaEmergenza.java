package backend;

public class PersonaEmergenza extends Persona{


    public PersonaEmergenza(String nome, String cognome, String numeroTelefono, String indirizzoEmail) {
        super(nome, cognome, numeroTelefono, indirizzoEmail);


    }

    public PersonaEmergenza(){}

    public boolean isTelefonoCheck(String numeroTelefono) {
        boolean telefonoCheck=false;
        if(!numeroDiTelefonoCheck(numeroTelefono))
            telefonoCheck=true;
        return telefonoCheck;
    }

    public boolean numeroDiTelefonoCheck(String numero){

        if(numero.equals(""))
            return false;
        if(numero.length() != 10)
            return false;

        for(int i = 0; i < numero.length(); i++){
            if(numero.charAt(i) < '0' || numero.charAt(i) > '9')
                return false;
        }

        return true;
    }
}
