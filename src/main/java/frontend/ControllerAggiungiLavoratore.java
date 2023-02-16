package frontend;

import backend.*;
import backend.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class ControllerAggiungiLavoratore implements Initializable {

    private Stage stage;
    private Scene scene;

    private Model model = Model.getModel();

    private Set<String> comuni = new HashSet<>();

    private Set<String> esperienze = new HashSet<>();

    public List<Lavoro> lavori = new ArrayList<>();

    @FXML
    public TextField nome_field;

    @FXML
    public TextField cognome_field;

    @FXML
    public TextField luogo_field;

    @FXML
    public TextField nazio_field;

    @FXML
    public TextField via_field;

    @FXML
    public TextField citta_field;

    @FXML
    public TextField tel_field;

    @FXML
    public TextField email_field;

    @FXML
    public TextField nome2_field;

    @FXML
    public TextField cognome2_field;

    @FXML
    public TextField tel2_field;

    @FXML
    public TextField email2_field;

    @FXML
    public TextArea textAreaComune;

    @FXML
    public TextArea textAreaEsp;

    @FXML
    public DatePicker data_field;

    @FXML
    public DatePicker dataP_field;

    @FXML
    public DatePicker dataP2_field;

    @FXML
    public CheckBox ita_field;

    @FXML
    public CheckBox al_field;

    @FXML
    public CheckBox fr_field;

    @FXML
    public CheckBox slo_field;

    @FXML
    public CheckBox de_field;

    @FXML
    public CheckBox en_field;

    @FXML
    public CheckBox ar_field;

    @FXML
    public CheckBox ru_field;

    @FXML
    public CheckBox cin_field;

    @FXML
    public CheckBox spa_field;

    @FXML
    public ComboBox<String> disp_field = new ComboBox<>();

    @FXML
    public ComboBox<String> esp_field = new ComboBox<>();

    @FXML
    public ComboBox<String> province_field = new ComboBox<>();

    @FXML
    public ComboBox<String> patente_field = new ComboBox<>();

    @FXML
    public RadioButton auto_field;

    @FXML
    public Label campiObbligatori_label;

    @FXML
    public Label campiObbligatoriDisponibilità_label;

    public String nome;
    public String cognome;
    public String luogo;
    public String nazio;
    public String tel;
    public String email;
    public String nome2;
    public String cognome2;
    public String tel2;
    public String email2;
    public String patente;
    public String province;
    public String disp;
    public String esp;
    public Boolean auto = false;

    public Date birthDate;
    public Date inizioPeriodoDate;
    public Date finePeriodoDate;


    {
        try {
            birthDate = new Date(01,01,1920);
            inizioPeriodoDate = new Date(01, 01, 1920);
            finePeriodoDate = new Date(01, 01, 1920);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //salva prima parte del lavoratore tranne mappaperiodi
    //salva i dati del lavoratore, i dati del contatto di emergenza e gli scrive nel json
    // aggiungilavoratore -> disponibilità
    //saveWorkerAction
    public void saveWorkerAction(ActionEvent actionEvent) throws Exception {

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
        data_field.setEditable(true);
        data_field.setStyle("-fx-border-color:black;");
        data_field.setStyle("-fx-background-color:gray;");
        data_field.setEditable(false);


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

        if(lavoratore.checkDate(birthDate)){
            data_field.setEditable(true);
            data_field.setStyle("-fx-border-color:red;");
            data_field.setStyle("-fx-background-color:red;");
            data_field.setEditable(false);
            flag=true;
        }

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

        if(!lavoratore.mailChecker(email)){

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

        if(!personaemergenza.mailChecker(email2)){

            email2_field.setStyle("-fx-text-fill:red;");
            flag=true;
        }

        if(personaemergenza.isTelefonoCheck(tel2)){

            tel2_field.setStyle("-fx-text-fill:red;");
            flag=true;
        }

        if(!flag) {

            model.saveNewWorker(lavoratore);

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


        Periodo periodo = new Periodo(inizioPeriodoDate, finePeriodoDate);
        String testo = textAreaComune.getText();
        String[] arrComuni = testo.split("\n");

        for (String stringa : arrComuni) {
            comuni.add(stringa);
        }

        if(!comuni.contains("") && periodo.checkDefault() && periodo.checkDate()) {

            model.addDisponibilità(periodo,comuni);

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

        patente_field.setItems(model.getList());
        disp_field.getItems().addAll(model.getListaComuni());
        esp_field.getItems().addAll(model.getListaEsperienze());
        province_field.getItems().addAll(model.getListaProvince());

    }

    //ritorna ad afterlogin e salva la disponibilità(comuni, e periodi)
    //disponibilità -> afterlogin
    public void exitAction(ActionEvent actionEvent) throws IOException {

        //salvataggio nuova disponibilità

        if(model.getDisponibilità().isEmpty()){

            campiObbligatoriDisponibilità_label.setStyle("-fx-text-fill:red;");

        }else{

            model.saveLavoratoreConDisponibilità();

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

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
