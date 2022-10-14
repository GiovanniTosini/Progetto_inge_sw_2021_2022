package backend;

public class Lavoro {
    private Periodo periodo;
    private String nomeAzienda;
    private String luogoLavoro;
    private String mansioniSvolte;
    private String retribuzioneLorda;

    public Lavoro(){}

    public Lavoro(Periodo periodo, String nomeAzienda, String luogoLavoro, String mansioniSvolte, String retribuzioneLorda) {
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

    public String getMansioniSvolte() {
        return mansioniSvolte;
    }

    public void setMansioniSvolte(String mansioniSvolte) {
        this.mansioniSvolte = mansioniSvolte;
    }

    public String getRetribuzioneLorda() {
        return retribuzioneLorda;
    }

    public void setRetribuzioneLorda(String retribuzioneLorda) {
        this.retribuzioneLorda = retribuzioneLorda;
    }
}
