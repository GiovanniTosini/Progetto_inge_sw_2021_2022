package backend;

import java.util.Set;

public class Lavoro {
    private Periodo periodo;
    private String nomeAzienda;
    private String luogoLavoro;
    private Set<String> mansioniSvolte;
    private float retribuzioneLorda;

    public Lavoro(){}

    public Lavoro(Periodo periodo, String nomeAzienda, String luogoLavoro, Set<String> mansioniSvolte, float retribuzioneLorda) {
        this.periodo = periodo;
        this.nomeAzienda = nomeAzienda;
        this.luogoLavoro = luogoLavoro;
        this.mansioniSvolte = mansioniSvolte;
        this.retribuzioneLorda = retribuzioneLorda;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public String getLuogoLavoro() {
        return luogoLavoro;
    }

    public void setLuogoLavoro(String luogoLavoro) {
        this.luogoLavoro = luogoLavoro;
    }

    public Set<String> getMansioniSvolte() {
        return mansioniSvolte;
    }

    public void setMansioniSvolte(Set<String> mansioniSvolte) {
        this.mansioniSvolte = mansioniSvolte;
    }

    public float getRetribuzioneLorda() {
        return retribuzioneLorda;
    }

    public void setRetribuzioneLorda(float retribuzioneLorda) {
        this.retribuzioneLorda = retribuzioneLorda;
    }
}
