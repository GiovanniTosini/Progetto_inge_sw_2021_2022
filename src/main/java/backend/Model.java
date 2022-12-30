package backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Model {

    private static Model modelInstance;
    private ObjectMapper objectMapper = new ObjectMapper();
    private File file = new File("lavoratori.json");
    private ListaLavoratori listaLavoratori = new ListaLavoratori();
    private List<Disponibilità> disponibilità = new ArrayList<>();
    private Lavoratore lavoratoreDaAggiornare = new Lavoratore();


    Set<String> esperienze = new HashSet<>();

    ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");

    List<Lavoro> lavori = new ArrayList<>();

    String[] listaComuni = new String[110];

    String[] listaEsperienze = new String[69];

    String[] listaProvince = new String[110];

    public Model() {

    }

    public static Model getModel(){

        if(modelInstance==null){
            modelInstance = new Model();

        }
        return modelInstance;

    }

    public ObservableList<String> getList() {
        return list;
    }

    public void setLavoratoreDaAggiornare(Lavoratore lavoratoreDaAggiornare) {
        this.lavoratoreDaAggiornare = lavoratoreDaAggiornare;
    }
    public ListaLavoratori getListaLavoratoriFromModel() {
        return listaLavoratori;
    }
    public String[] getListaComuni() {
        return listaComuni;
    }

    public String[] getListaEsperienze() {
        return listaEsperienze;
    }

    public String[] getListaProvince() {
        return listaProvince;
    }

    public Set<String> getEsperienze() {
        return esperienze;
    }
    public void readJson() throws IOException {

        listaLavoratori = objectMapper.readValue(file, ListaLavoratori.class);
    }

    public void writeJson(ListaLavoratori listaLavoratori) throws IOException {

        objectMapper.writeValue(file, listaLavoratori);

    }

    public void add_saveWorker(Lavoratore lavoratore) throws IOException {

        listaLavoratori.getListaLavoratori().add(lavoratore);
        writeJson(listaLavoratori);
    }


    public void addDisponibilità(Periodo periodo, Set<String> comuni) {

        Disponibilità nuovaDisp = new Disponibilità(periodo,comuni);

        disponibilità.add(nuovaDisp);

    }


    public void saveDisponibilità() throws IOException {

        Lavoratore newlavoratore = listaLavoratori.getListaLavoratori().get(listaLavoratori.getListaLavoratori().size() - 1);

        listaLavoratori.getListaLavoratori().remove(listaLavoratori.getListaLavoratori().size()-1);

        newlavoratore.setDisponibilità(disponibilità);

        listaLavoratori.getListaLavoratori().add(newlavoratore);

        //objectMapper.writeValue(file, listaLavoratori);
        writeJson(listaLavoratori);

        disponibilità.clear();
    }

    public void inizializzaListe(){
        String file = "src/main/resources/frontend/province.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                listaComuni[i] = line;
                i++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String fileesp = "src/main/resources/frontend/lavori_stagionali.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileesp))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                listaEsperienze[i] = line;
                i++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String fileProvince = "src/main/resources/frontend/sigla_province.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileProvince))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                listaProvince[i] = line;
                i++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void remove_saveWorker(Lavoratore lavoratore) throws IOException {
        listaLavoratori.getListaLavoratori().remove(lavoratore);
        writeJson(listaLavoratori);
    }

    public void updateWorks(Lavoro lavoro) throws IOException {
        lavoratoreDaAggiornare.lavori.add(lavoro);
        add_saveWorker(lavoratoreDaAggiornare);
    }

}
