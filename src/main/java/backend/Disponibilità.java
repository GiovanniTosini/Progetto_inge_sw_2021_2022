package backend;

import java.util.HashSet;
import java.util.Set;

public class Disponibilità {

    private Periodo periodo;
    private Set<String> comuni = new HashSet<>();

    public Disponibilità(Periodo periodo, Set<String> comuni) {
        this.periodo = periodo;
        this.comuni = comuni;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Set<String> getComuni() {
        return comuni;
    }
}
