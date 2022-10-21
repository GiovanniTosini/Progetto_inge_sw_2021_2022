package frontend;

import backend.Date;
import backend.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class HelloController implements Initializable {

    private Stage stage;
    private Scene scene;

    File file = new File("lavoratori.json");

    ObjectMapper objectMapper = new ObjectMapper();

    ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");
    Set<String> comuni = new HashSet<>();
    static List<Disponibilità> disponibilità = new ArrayList<>();

    ListaLavoratori listaLavoratori = new ListaLavoratori();

    @FXML
    ComboBox<String> patente_field = new ComboBox<>();

    String[] list3 = new String[110];

    @FXML
    ComboBox<String> disp_field = new ComboBox<>();

    @FXML
    TextField username_field;

    @FXML
    PasswordField password_field;

    @FXML
    Label status_label;

    @FXML
    TextField nome_field;

    @FXML
    TextField cognome_field;

    @FXML
    TextField luogo_field;

    @FXML
    TextField nazio_field;

    @FXML
    TextField via_field;

    @FXML
    TextField citta_field;

    @FXML
    TextField prov_field;

    @FXML
    TextField tel_field;

    @FXML
    TextField email_field;

    @FXML
    TextField esp_field;

    @FXML
    TextField nome2_field;

    @FXML
    TextField cognome2_field;

    @FXML
    TextField tel2_field;

    @FXML
    TextField email2_field;

    @FXML
    CheckBox ita_field;

    @FXML
    CheckBox al_field;

    @FXML
    CheckBox fr_field;

    @FXML
    CheckBox slo_field;

    @FXML
    CheckBox de_field;

    @FXML
    CheckBox en_field;

    @FXML
    CheckBox ar_field;

    @FXML
    CheckBox ru_field;

    @FXML
    CheckBox cin_field;

    @FXML
    CheckBox spa_field;

    @FXML
    RadioButton auto_field;

    @FXML
    RadioButton auto_field2;

    @FXML
    TextField nomeS_field;

    @FXML
    TextField cognomeS_field;

    @FXML
    TextField codFis_field;

    @FXML
    TextArea textAreaComune;

    @FXML
    TextField nomeA_field;

    @FXML
    TextField luogoA_field;

    @FXML
    TextArea mansioni_field;

    @FXML
    TextField cash_field;

    @FXML
    DatePicker data_field;

    @FXML
    DatePicker dataP_field;

    @FXML
    DatePicker dataP2_field;

    @FXML
    DatePicker data2_field;

    @FXML
    DatePicker data3_field;


    //fare con database (check admin)
    String username = "admin";
    String password = "admin";
    String nome;
    String cognome;
    String luogo;
    String nazio;
    String tel;
    String email;
    String esp;
    String nome2;
    String cognome2;
    String tel2;
    String email2;
    String patente;
    Boolean auto = false;
    String disp;
    String codFisS;
    String nomeS;
    String cognomeS;
    String nomeA;
    String luogoA;
    String mansioni;
    String cash;
    Date birthDate;
    Date inizioPeriodoDate;
    Date finePeriodoDate;

    {
        try {
            birthDate = new Date(01,01,2000);
            inizioPeriodoDate = new Date(01,01,2000);
            finePeriodoDate = new Date(01,01,2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //funzione che verifica i dati inseriti di login e ci porta ad afterlogin
    //login -> afterlogin
    public void loginAction(ActionEvent actionEvent) throws IOException {

        String username_text = username_field.getText();
        String password_text = password_field.getText();

        //check con jackson
        if (username_text.compareTo(username) == 0 && password_text.compareTo(password) == 0) {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {

            status_label.setText("Login status: FIELDS INCORRECT");

        }

    }

    //ci porta ad aggiungilavoratore dopo afterlogin
    //afterlogin -> aggiungilavoratore
    //addWorkerAction
    public void addWorkerAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AggiungiLavoratore.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //funzione che viene richiamata con ricercalavoratore
    // afterlogin -> ricercalavoratore
    //searchWorkerAction
    public void searchWorkerAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RicercaLavoratore.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    //salva prima parte del lavoratore tranne mappaperiodi
    //salva i dati del lavoratore, i dati del contatto di emergenza e gli scrive nel json
    // aggiungilavoratore -> disponibilità
    //saveWorkerAction
    public void saveWorkerAction(ActionEvent actionEvent) throws Exception {

        Set<String> lingue = new HashSet<>();
        Set<String> esp = new HashSet<>();
        nome = nome_field.getText();
        cognome = cognome_field.getText();
        luogo = luogo_field.getText();
        nazio = nazio_field.getText();

        Residenza residenza = new Residenza(via_field.getText(), citta_field.getText(), prov_field.getText());

        System.out.println(residenza);

        tel = tel_field.getText();
        email = email_field.getText();
        esp.add(esp_field.getText());
        nome2 = nome2_field.getText();
        cognome2 = cognome2_field.getText();
        tel2 = tel2_field.getText();
        email2 = email2_field.getText();

        if (ita_field.isSelected()) {

            lingue.add(ita_field.getText());

        }

        if (al_field.isSelected()) {

            lingue.add(al_field.getText());

        }

        if (fr_field.isSelected()) {

            lingue.add(fr_field.getText());

        }

        if (slo_field.isSelected()) {

            lingue.add(slo_field.getText());

        }

        if (de_field.isSelected()) {

            lingue.add(de_field.getText());

        }

        if (en_field.isSelected()) {

            lingue.add(en_field.getText());

        }

        if (ar_field.isSelected()) {

            lingue.add(ar_field.getText());

        }

        if (ru_field.isSelected()) {

            lingue.add(ru_field.getText());

        }

        if (cin_field.isSelected()) {

            lingue.add(cin_field.getText());

        }

        if (spa_field.isSelected()) {

            lingue.add(spa_field.getText());

        }

        if (patente_field.getSelectionModel().getSelectedItem() != null) {

            patente = patente_field.getSelectionModel().getSelectedItem();

        }

        if (auto_field.isSelected()) {

            auto = true;

        }

        PersonaEmergenza personaemergenza = new PersonaEmergenza(nome2, cognome2, tel2, email2);

        Periodo p=new Periodo();
        Lavoro lavoro=new Lavoro(); //passo perido, ...
        //TODO: aggiunta Periodi e lavori


        List<Lavoro> lavori = new ArrayList<>();
        Lavoratore lavoratore = new Lavoratore(nome, cognome, luogo, nazio, email, tel, birthDate, residenza, patente, auto, lingue, disponibilità, esp, personaemergenza, lavori);

        System.out.println(lavoratore);

        listaLavoratori.getListaLavoratori().add(lavoratore);

        objectMapper.writeValue(file, listaLavoratori);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("disponibilità.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //funzione che inizializza i campi della patente e delle province da selezionare
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String file = "src/main/resources/frontend/province.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                list3[i] = line;
                i++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        patente_field.setItems(list);
        disp_field.getItems().addAll(list3);

    }

    //aggiorna lavoro
    //aggioralavoro -> afterlogin
    //updateWorkAction
    public void updateWorkAction(ActionEvent actionEvent) throws IOException {

        nomeA = nomeA_field.getText();
        luogoA = luogoA_field.getText();
        mansioni = mansioni_field.getText();
        cash = cash_field.getText();
        Periodo periodo2 = new Periodo(inizioPeriodoDate, finePeriodoDate);

        System.out.println(nomeA + "\n" + luogoA + "\n" + mansioni + "\n" + cash + "\n" + periodo2 + "\n");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //ricerva lavoro per aggiornare lavoratore
    // ricercalavoratore -> aggiornalavoro
    public void searchAction(ActionEvent actionEvent) throws IOException {

        nomeS = nomeS_field.getText();
        cognomeS = cognomeS_field.getText();
        codFisS = codFis_field.getText();

        if (nomeS.compareTo(username) == 0 && cognomeS.compareTo(password) == 0) {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AggiornaLavoro.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

    //salvataggio comune in disponibilità
    public void saveComune(ActionEvent actionEvent) {

        if (disp_field.getSelectionModel().getSelectedItem() != null) {

            disp = textAreaComune.getText();

            if (!disp.contains(disp_field.getSelectionModel().getSelectedItem())) {

                textAreaComune.appendText(disp_field.getSelectionModel().getSelectedItem() + "\n");

            } else {

                int index = disp.indexOf(disp_field.getSelectionModel().getSelectedItem());

                textAreaComune.deleteText(index, index + disp_field.getSelectionModel().getSelectedItem().length() + 1);

            }

        }

    }

    //salva disponibilità lavoratore in disponibilità
    //salva anche parte di mappaperiodi in json
    //saveAvailabilityAction
    public void saveAvailabilityAction(ActionEvent actionEvent) throws IOException {

        //salvo parametri periodi e zone

        Periodo periodo = new Periodo(inizioPeriodoDate, finePeriodoDate);

        String testo = textAreaComune.getText();

        String[] arrComuni = testo.split("\n");

        for (String stringa: arrComuni) {
            comuni.add(stringa);
        }

        Disponibilità newdisponibilità = new Disponibilità(periodo,comuni);

        disponibilità.add(newdisponibilità);

        System.out.println(disponibilità);

        dataP_field.getEditor().clear();
        dataP2_field.getEditor().clear();
        disp_field.getSelectionModel().clearSelection();
        textAreaComune.clear();

    }

    //ritorna ad afterlogin e salva la disponibilità(comuni, e periodi)
    //disponibilità -> afterlogin
    public void exitAction(ActionEvent actionEvent) throws IOException {

        //inizializzazione nuova disponibilità

        listaLavoratori = objectMapper.readValue(file, ListaLavoratori.class);

        Lavoratore newlavoratore = listaLavoratori.getListaLavoratori().get(listaLavoratori.getListaLavoratori().size() - 1);

        newlavoratore.setDisponibilità(disponibilità);

        objectMapper.writeValue(file, listaLavoratori);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //ci porta in effettuaricerche da afterlogin
    //afterlogin -> effettuaricerche
    public void ricercaAction(ActionEvent actionEvent) throws IOException {


        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EffettuaRicerche.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //effettua ricerca lavoratore in effettuaricerche
    public void search2Action(ActionEvent actionEvent) {

        //da implementare

        System.out.println("SCEMO CHI LEGGE (SIETE TUTTI E DUE DEI TACCHINI FIGA)");

    }

    public void setBirthDate(ActionEvent actionEvent) throws Exception {

        LocalDate mydate = data_field.getValue();

        birthDate.setDay(mydate.getDayOfMonth());
        birthDate.setMonth(mydate.getMonthValue());
        birthDate.setYear(mydate.getYear());

    }

    public void setInizioPeriodo(ActionEvent actionEvent) {

        LocalDate mydate = dataP_field.getValue();

        inizioPeriodoDate.setDay(mydate.getDayOfMonth());
        inizioPeriodoDate.setMonth(mydate.getMonthValue());
        inizioPeriodoDate.setYear(mydate.getYear());

    }

    public void setFinePeriodo(ActionEvent actionEvent) {

        LocalDate mydate = dataP2_field.getValue();

        finePeriodoDate.setDay(mydate.getDayOfMonth());
        finePeriodoDate.setMonth(mydate.getMonthValue());
        finePeriodoDate.setYear(mydate.getYear());

    }

    public void setInizioPeriodo2(ActionEvent actionEvent) {

        LocalDate mydate = data2_field.getValue();

        inizioPeriodoDate.setDay(mydate.getDayOfMonth());
        inizioPeriodoDate.setMonth(mydate.getMonthValue());
        inizioPeriodoDate.setYear(mydate.getYear());

    }

    public void setFinePeriodo2(ActionEvent actionEvent) {

        LocalDate mydate = data3_field.getValue();

        finePeriodoDate.setDay(mydate.getDayOfMonth());
        finePeriodoDate.setMonth(mydate.getMonthValue());
        finePeriodoDate.setYear(mydate.getYear());

    }

}
