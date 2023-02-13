package backend;

import java.util.ArrayList;
import java.util.List;

public class ListaLavoratori {

    public List<Lavoratore> listaLavoratori;

    public ListaLavoratori() {
        this.listaLavoratori = new ArrayList<>();
    }

    public List<Lavoratore> getListaLavoratori() {
        return listaLavoratori;
    }

    public void setListaLavoratori(List<Lavoratore> listaLavoratori) {
        this.listaLavoratori = listaLavoratori;
    }
}
