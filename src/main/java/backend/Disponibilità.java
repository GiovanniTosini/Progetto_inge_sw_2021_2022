package backend;

import java.util.Set;

public class Disponibilità {

    private Periodo periodo;
    private Set<String> comuni;

    public Disponibilità(Periodo periodo, Set<String> comuni) {
        this.periodo = periodo;
        this.comuni = comuni;
    }

    @Override
    public String toString() {
        return "Disponibilità{" +
                "periodo=" + periodo +
                ", comuni=" + comuni +
                '}';
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public void setComuni(Set<String> comuni) {
        this.comuni = comuni;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public Set<String> getComuni() {
        return comuni;
    }
}
