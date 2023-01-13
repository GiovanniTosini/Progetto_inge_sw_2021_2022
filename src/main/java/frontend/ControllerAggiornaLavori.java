package frontend;

import backend.*;
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
import java.util.HashSet;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Set;

public class ControllerAggiornaLavori implements Initializable {

    private Stage stage;
    private Scene scene;
    Model model = Model.getModel();
    Set<String> mansioniLavoratore = new HashSet<>();

    @FXML
    TextField ricercaNome_field;

    @FXML
    TextField ricercaCognome_field;

    @FXML
    TextField nomeA_field;

    @FXML
    TextField luogoA_field;

    @FXML
    TextField cash_field;

    @FXML
    Label erroriRicercaLavoratore_label;

    @FXML
    Label erroriAggiorna_label;

    @FXML
    TextArea textAreaMansioni;

    @FXML
    ComboBox<String> mansioni_field = new ComboBox<>();

    @FXML
    DatePicker ricercaData_field;

    @FXML
    DatePicker data2_field;

    @FXML
    DatePicker data3_field;

    String ricercaNome;
    String ricercaCognome;
    String mansioni;
    String nomeAzienda;
    String luogoAzienda;
    float cash;

    Date ricercaDate;
    Date inizioPeriodoDate;
    Date finePeriodoDate;

    {
        try {
            ricercaDate = new Date(01,01,2000);
            inizioPeriodoDate = new Date(01,01,2000);
            finePeriodoDate = new Date(01,01,2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //aggiornalavoro -> afterlogin
    //updateWorkAction
    public void updateWorkAction(ActionEvent actionEvent) throws IOException {

        //listaLavoratori=model.readJson(listaLavoratori);
        erroriAggiorna_label.setStyle("-fx-text-fill:#333;");
        nomeA_field.setStyle("-fx-text-fill:black");
        luogoA_field.setStyle("-fx-text-fill:black;");
        cash_field.setStyle("-fx-text-fill:black;");
        boolean flag=true;
        nomeAzienda = nomeA_field.getText();
        luogoAzienda = luogoA_field.getText();

        Date dataDefault=null;

        try {
            dataDefault = new Date(01, 01, 2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(nomeAzienda.equals("")) {
            nomeA_field.setStyle("-fx-text-fill:red");
        }

        if(luogoAzienda.equals("")||luogoAzienda.contains("0")||luogoAzienda.contains("1")||luogoAzienda.contains("2")||luogoAzienda.contains("3")||luogoAzienda.contains("4")||luogoAzienda.contains("5")||luogoAzienda.contains("6")||luogoAzienda.contains("7")||luogoAzienda.contains("8")||luogoAzienda.contains("9")) {
            flag = false;
            luogoA_field.setStyle("-fx-text-fill:red");
        }

        try {
            cash = Float.parseFloat(cash_field.getText());
        }catch (NumberFormatException e){
            flag=false;
            cash_field.setStyle("-fx-text-fill:red");
        }

        Periodo periodo2 = new Periodo(inizioPeriodoDate, finePeriodoDate);

        String testoMan = textAreaMansioni.getText();
        String[] arrMansioni = testoMan.split("\n");

        for (String stringa: arrMansioni) {
            mansioniLavoratore.add(stringa);
        }

        //System.out.println(nomeAzienda + "\n" + luogoAzienda + "\n" + mansioni + "\n" + cash + "\n" + periodo2 + "\n");

        if(nomeAzienda.equals("") || luogoAzienda.equals("") || mansioniLavoratore.isEmpty() || cash==0 ||
                (periodo2.checkDefault() && !periodo2.checkPreviousDate()))
            flag=false;

        if(flag) {
            Lavoro lavoroTemp = new Lavoro(periodo2, nomeAzienda, luogoAzienda, mansioniLavoratore, cash);
            model.updateWorks(lavoroTemp);
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{

            erroriAggiorna_label.setStyle("-fx-text-fill:red;");

        }
    }

    //ricerca lavoratore per aggiornare lavoro
    // ricercalavoratore -> aggiornalavoro
    public void searchAction(ActionEvent actionEvent) throws IOException {

        boolean flag = false;
        erroriRicercaLavoratore_label.setStyle("-fx-text-fill:#333;");
        ricercaNome_field.setStyle("-fx-text-fill:black;");
        ricercaCognome_field.setStyle("-fx-text-fill:black;");

        ricercaNome = ricercaNome_field.getText();

        if(ricercaNome.equals("")){

            ricercaNome_field.setStyle("-fx-text-fill:red;");

        }

        ricercaCognome = ricercaCognome_field.getText();

        if(ricercaCognome.equals("")){

            ricercaCognome_field.setStyle("-fx-text-fill:red;");

        }

        //listaLavoratori = objectMapper.readValue(file, ListaLavoratori.class);
        //listaLavoratori=model.readJson(listaLavoratori);

        for(Lavoratore lavoratore : model.getListaLavoratoriFromModel().getListaLavoratori()){

            if(lavoratore.getNome().equals(ricercaNome) && lavoratore.getCognome().equals(ricercaCognome) && lavoratore.getDataDiNascita().equals(ricercaDate)){

                model.setLavoratoreDaAggiornare(lavoratore);
                model.remove_saveWorker(lavoratore);
                flag = true;
                break;
            }

        }

        if (flag) {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AggiornaLavoro.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{

            erroriRicercaLavoratore_label.setStyle("-fx-text-fill:red;");

        }

    }

    public void returnAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void saveMansioni(ActionEvent actionEvent) {

        if (mansioni_field.getSelectionModel().getSelectedItem() != null) {

            mansioni = textAreaMansioni.getText();

            if (!mansioni.contains(mansioni_field.getSelectionModel().getSelectedItem())) {

                textAreaMansioni.appendText(mansioni_field.getSelectionModel().getSelectedItem() + "\n");

            } else {

                int index = mansioni.indexOf(mansioni_field.getSelectionModel().getSelectedItem());

                textAreaMansioni.deleteText(index, index + mansioni_field.getSelectionModel().getSelectedItem().length() + 1);

            }

        }

    }

    public void setRicercaDate(ActionEvent actionEvent) {

        LocalDate mydate = ricercaData_field.getValue();

        ricercaDate.setDay(mydate.getDayOfMonth());
        ricercaDate.setMonth(mydate.getMonthValue());
        ricercaDate.setYear(mydate.getYear());

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

    //funzione che inizializza i campi (combobox) della patente e delle province da selezionare
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        mansioni_field.getItems().addAll(model.getListaEsperienze());
    }

}
