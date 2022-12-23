package frontend;

import backend.*;
import backend.Date;
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

public class ControllerAggiungiLavoratore implements Initializable {

    private Stage stage;
    private Scene scene;

    Model model = Model.getModel();

    ListaLavoratori listaLavoratori = new ListaLavoratori();

    Set<String> comuni = new HashSet<>();
    Set<String> esperienze = new HashSet<>();

    static List<Disponibilità> disponibilità = new ArrayList<>();

    ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");

    List<Lavoro> lavori = new ArrayList<>();

    String[] listaComuni = new String[110];

    String[] listaEsperienze = new String[69];

    String[] listaProvince = new String[110];

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
    TextField tel_field;

    @FXML
    TextField email_field;

    @FXML
    TextField nome2_field;

    @FXML
    TextField cognome2_field;

    @FXML
    TextField tel2_field;

    @FXML
    TextField email2_field;

    @FXML
    TextArea textAreaComune;

    @FXML
    TextArea textAreaEsp;

    @FXML
    DatePicker data_field;

    @FXML
    DatePicker dataP_field;

    @FXML
    DatePicker dataP2_field;

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
    ComboBox<String> disp_field = new ComboBox<>();

    @FXML
    ComboBox<String> esp_field = new ComboBox<>();

    @FXML
    ComboBox<String> province_field = new ComboBox<>();

    @FXML
    ComboBox<String> patente_field = new ComboBox<>();

    @FXML
    RadioButton auto_field;

    @FXML
    Label campiObbligatori_label;

    @FXML
    Label campiObbligatoriDisponibilità_label;

    String nome;
    String cognome;
    String luogo;
    String nazio;
    String tel;
    String email;
    String nome2;
    String cognome2;
    String tel2;
    String email2;
    String patente;
    String province;
    String disp;
    String esp;
    Boolean auto = false;

    Date birthDate;
    Date inizioPeriodoDate;
    Date finePeriodoDate;


    {
        try {
            birthDate = new Date(01,01,2000);
            inizioPeriodoDate = new Date(01, 01, 2000);
            finePeriodoDate = new Date(01, 01, 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //salva prima parte del lavoratore tranne mappaperiodi
    //salva i dati del lavoratore, i dati del contatto di emergenza e gli scrive nel json
    // aggiungilavoratore -> disponibilità
    //saveWorkerAction
    public void saveWorkerAction(ActionEvent actionEvent) throws Exception {

        //listaLavoratori = objectMapper.readValue(file, ListaLavoratori.class);
        //listaLavoratori=model.readJson(listaLavoratori);
        List<Disponibilità> disponibilitàTemp = new ArrayList<>();
        Set<String> lingue = new HashSet<>();
        boolean flag=false;

        nome_field.setStyle("-fx-text-fill:black;");
        cognome_field.setStyle("-fx-text-fill:black;");
        email_field.setStyle("-fx-text-fill:black;");
        tel_field.setStyle("-fx-text-fill:black;");
        luogo_field.setStyle("-fx-text-fill:black;");
        nazio_field.setStyle("-fx-text-fill:black;");
        via_field.setStyle("-fx-text-fill:black;");
        citta_field.setStyle("-fx-text-fill:black;");
        nome2_field.setStyle("-fx-text-fill:black;");
        cognome2_field.setStyle("-fx-text-fill:black;");
        email2_field.setStyle("-fx-text-fill:black;");
        tel2_field.setStyle("-fx-text-fill:black;");
        campiObbligatori_label.setStyle("-fx-text-fill:white;");



        nome = nome_field.getText();
        cognome = cognome_field.getText();
        luogo = luogo_field.getText();
        nazio = nazio_field.getText();
        if (province_field.getSelectionModel().getSelectedItem() != null)
            province = province_field.getSelectionModel().getSelectedItem();
        else{

            flag=true;

        }

        Residenza residenza = new Residenza(via_field.getText(), citta_field.getText(), province);

        tel = tel_field.getText();
        email = email_field.getText();
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

        }else{

            flag=true;

        }

        if (auto_field.isSelected()) {

            auto = true;

        }

        String testoesp = textAreaEsp.getText();

        String[] arrEsp = testoesp.split("\n");

        for (String stringa: arrEsp) {
            esperienze.add(stringa);
        }

        PersonaEmergenza personaemergenza = new PersonaEmergenza(nome2, cognome2, tel2, email2);

        Lavoratore lavoratore = new Lavoratore(nome, cognome, luogo, nazio, email, tel, birthDate, residenza, patente, auto, lingue, disponibilitàTemp, esperienze, personaemergenza, lavori);

        if(lavoratore.getResidenza().isViaCheck(via_field.getText())){
            via_field.setStyle("-fx-text-fill:red;");
            flag=true;
        }

        if(lavoratore.getResidenza().isCittàCheck(citta_field.getText())){
            citta_field.setStyle("-fx-text-fill:red;");
            flag=true;
        }

        if(lavoratore.isNomeCheck(nome)){

            nome_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(lavoratore.isCognomeCheck(cognome)){

            cognome_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(lavoratore.isMailCheck(email)){

            email_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(lavoratore.isTelefonoCheck(tel)){

            tel_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(lavoratore.isLuogoCheck(luogo)){

            luogo_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(lavoratore.isNazionalitàCheck(nazio)){

            nazio_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(lingue.isEmpty()){

            flag=true;

        }

        if(personaemergenza.isNomeCheck(nome2)){

            nome2_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(personaemergenza.isCognomeCheck(cognome2)){

            cognome2_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(personaemergenza.isMailCheck(email2)){

            email2_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(personaemergenza.isTelefonoCheck(tel2)){

            tel2_field.setStyle("-fx-text-fill:red;");
            flag=true;

        }

        if(!flag) {

            //listaLavoratori.getListaLavoratori().add(lavoratore);

            //objectMapper.writeValue(file, listaLavoratori);
            //model.writeJson(listaLavoratori);

            model.add_saveWorker(lavoratore);

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("disponibilità.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{
            campiObbligatori_label.setStyle("-fx-text-fill:red;");
        }

    }

    //salva disponibilità lavoratore in disponibilità
    //salva anche parte di mappaperiodi in json
    //saveAvailabilityAction
    public void saveAvailabilityAction(ActionEvent actionEvent) throws IOException {

        //salvo parametri periodi e zone

        campiObbligatoriDisponibilità_label.setStyle("-fx-text-fill:#333;");

        comuni.clear();

        Date dataDefault=null;

        try {
            dataDefault = new Date(01, 01, 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Periodo periodo = new Periodo(inizioPeriodoDate, finePeriodoDate);

        String testo = textAreaComune.getText();

        String[] arrComuni = testo.split("\n");

        for (String stringa : arrComuni) {
            comuni.add(stringa);
        }

        if(!comuni.isEmpty() && !inizioPeriodoDate.equals(dataDefault) && !finePeriodoDate.equals(dataDefault)) {

            disponibilità.add(new Disponibilità(periodo,comuni));

            System.out.println(disponibilità);

            /*dataP_field.getEditor().clear();
            dataP2_field.getEditor().clear();
            disp_field.getSelectionModel().clearSelection();
            textAreaComune.clear();*/

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("disponibilità.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{

            campiObbligatoriDisponibilità_label.setStyle("-fx-text-fill:red;");

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

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

        patente_field.setItems(list);
        disp_field.getItems().addAll(listaComuni);
        esp_field.getItems().addAll(listaEsperienze);
        province_field.getItems().addAll(listaProvince);

    }

    //ritorna ad afterlogin e salva la disponibilità(comuni, e periodi)
    //disponibilità -> afterlogin
    public void exitAction(ActionEvent actionEvent) throws IOException {

        //inizializzazione nuova disponibilità

        //listaLavoratori = objectMapper.readValue(file, ListaLavoratori.class);

        listaLavoratori = model.readJson(listaLavoratori);

        Lavoratore newlavoratore = listaLavoratori.getListaLavoratori().get(listaLavoratori.getListaLavoratori().size() - 1);

        listaLavoratori.getListaLavoratori().remove(listaLavoratori.getListaLavoratori().size()-1);

        newlavoratore.setDisponibilità(disponibilità);

        listaLavoratori.getListaLavoratori().add(newlavoratore);

        //objectMapper.writeValue(file, listaLavoratori);
        model.writeJson(listaLavoratori);

        disponibilità.clear();

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void returnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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

    public void saveEsp(ActionEvent actionEvent) {

        if (esp_field.getSelectionModel().getSelectedItem() != null) {

            esp = textAreaEsp.getText();

            if (!esp.contains(esp_field.getSelectionModel().getSelectedItem())) {

                textAreaEsp.appendText(esp_field.getSelectionModel().getSelectedItem() + "\n");

            } else {

                int index = esp.indexOf(esp_field.getSelectionModel().getSelectedItem());

                textAreaEsp.deleteText(index, index + esp_field.getSelectionModel().getSelectedItem().length() + 1);

            }

        }

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

}
