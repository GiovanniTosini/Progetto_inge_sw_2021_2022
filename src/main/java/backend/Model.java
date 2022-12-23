package backend;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Model {

    private static Model modelInstance;

    ObjectMapper objectMapper = new ObjectMapper();

    File file = new File("lavoratori.json");

    ListaLavoratori listaLavoratori = new ListaLavoratori();

    public Model() {
    }

    public static Model getModel(){

        if(modelInstance==null){
            modelInstance = new Model();
        }
        return modelInstance;

    }

    public ListaLavoratori readJson( ListaLavoratori listaLavoratori) throws IOException {

        listaLavoratori = objectMapper.readValue(file, ListaLavoratori.class);

        return listaLavoratori;

    }

    public void writeJson(ListaLavoratori listaLavoratori) throws IOException {

        objectMapper.writeValue(file, listaLavoratori);

    }

    public void add_saveWorker(Lavoratore lavoratore) throws IOException {

        listaLavoratori.getListaLavoratori().add(lavoratore);
        writeJson(listaLavoratori);

    }



}
