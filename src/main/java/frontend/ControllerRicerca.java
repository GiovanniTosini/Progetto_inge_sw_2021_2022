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

public class ControllerRicerca implements Initializable {

    private Stage stage;
    private Scene scene;

    Model model = Model.getModel();
    Set<String> mansioniLavoratoreRicerca = new HashSet<>();

    @FXML
    ComboBox<String> patenteRicerca_field = new ComboBox<>();
    @FXML
    ComboBox<String> mansioniRicerca_field = new ComboBox<>();
    @FXML
    TextField luogoRicerca_field;
    @FXML
    TextField nomeRicerca_field;
    @FXML
    TextField cognomeRicerca_field;
    @FXML
    RadioButton autoRicerca_field;
    @FXML
    RadioButton autoRicerca_field2;
    @FXML
    RadioButton andSearch_field;
    @FXML
    RadioButton orSearch_field;
    @FXML
    CheckBox itaRicerca_field;
    @FXML
    CheckBox alRicerca_field;
    @FXML
    CheckBox frRicerca_field;
    @FXML
    CheckBox sloRicerca_field;
    @FXML
    CheckBox deRicerca_field;
    @FXML
    CheckBox enRicerca_field;
    @FXML
    CheckBox arRicerca_field;
    @FXML
    CheckBox ruRicerca_field;
    @FXML
    CheckBox cinRicerca_field;
    @FXML
    CheckBox spaRicerca_field;
    @FXML
    TextArea textAreaMansioniRicerca;
    @FXML
    TextArea textAreaResRicerca;
    @FXML
    DatePicker inizioPeriodoRicerca_field;
    @FXML
    DatePicker finePeriodoRicerca_field;

    String mansioniRicerca;
    String nomeRicerca;
    String cognomeRicerca;
    String luogoRicerca;
    String patenteRicerca;
    Boolean autoRicerca;

    Date inizioPeriodoRicercaDate;
    Date finePeriodoRicercaDate;

    {
        try {
            inizioPeriodoRicercaDate = new Date(01,01,2000);
            finePeriodoRicercaDate = new Date(01,01,2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //effettua ricerca lavoratore in effettuaricerche
    public void effettaRicercheAction(ActionEvent actionEvent) throws Exception {

        textAreaResRicerca.clear();

        Set<String> lingueRicerca = new HashSet<>();

        boolean flag = false;

        nomeRicerca = nomeRicerca_field.getText();
        cognomeRicerca = cognomeRicerca_field.getText();
        luogoRicerca = luogoRicerca_field.getText();

        Periodo periodoRicerca = new Periodo(inizioPeriodoRicercaDate, finePeriodoRicercaDate);

        if (patenteRicerca_field.getSelectionModel().getSelectedItem() != null) {
            patenteRicerca = patenteRicerca_field.getSelectionModel().getSelectedItem();
        }

        if (autoRicerca_field.isSelected()) {
            autoRicerca = true;
        }

        if (autoRicerca_field2.isSelected()){
            autoRicerca = false;
        }

        if (itaRicerca_field.isSelected()) {
            lingueRicerca.add(itaRicerca_field.getText());
        }

        if (alRicerca_field.isSelected()) {
            lingueRicerca.add(alRicerca_field.getText());
        }

        if (frRicerca_field.isSelected()) {
            lingueRicerca.add(frRicerca_field.getText());
        }

        if (sloRicerca_field.isSelected()) {
            lingueRicerca.add(sloRicerca_field.getText());
        }

        if (deRicerca_field.isSelected()) {
            lingueRicerca.add(deRicerca_field.getText());
        }

        if (enRicerca_field.isSelected()) {
            lingueRicerca.add(enRicerca_field.getText());
        }

        if (arRicerca_field.isSelected()) {
            lingueRicerca.add(arRicerca_field.getText());
        }

        if (ruRicerca_field.isSelected()) {
            lingueRicerca.add(ruRicerca_field.getText());
        }

        if (cinRicerca_field.isSelected()) {
            lingueRicerca.add(cinRicerca_field.getText());
        }

        if (spaRicerca_field.isSelected()) {
            lingueRicerca.add(spaRicerca_field.getText());
        }

        mansioniLavoratoreRicerca.clear();

        if(textAreaMansioniRicerca.getText().compareTo("")!=0) {
            String testoMan = textAreaMansioniRicerca.getText();
            String[] arrMansioni = testoMan.split("\n");

            for (String stringa : arrMansioni) {
                mansioniLavoratoreRicerca.add(stringa);
            }
        }

        //se siamo nell and fai cose altrimenti siamo nell or
        if(andSearch_field.isSelected()){

            for(Lavoratore lavoratore : model.getListaLavoratoriFromModel().getListaLavoratori()){

                if(lavoratore.ricercaAnd(nomeRicerca, cognomeRicerca, luogoRicerca, periodoRicerca, autoRicerca, patenteRicerca, lingueRicerca, mansioniLavoratoreRicerca)) {
                    String lavoratoreDaScrivere = lavoratore.getNome() + " " + lavoratore.getCognome() + " " + lavoratore.getDataDiNascita() + "\n";
                    String testoDaControllare = textAreaResRicerca.getText();

                    if(!testoDaControllare.contains(lavoratoreDaScrivere))
                        textAreaResRicerca.appendText(lavoratoreDaScrivere);

                }

            }

        }else{

            for(Lavoratore lavoratore : model.getListaLavoratoriFromModel().getListaLavoratori()){
                //controllo primi parametri (+facili)
                if(lavoratore.getNome().equals(nomeRicerca) || lavoratore.getCognome().equals(cognomeRicerca) ||
                        lavoratore.getResidenza().getCittà().equals(luogoRicerca)){
                    flag = true;
                }

                if(lavoratore.getPatente()!=null){
                    if(lavoratore.getPatente().equals(patenteRicerca))
                        flag=true;
                }
                if(autoRicerca!=null){
                    if(lavoratore.isAutomunito()==autoRicerca)
                        flag=true;
                }

                //controllo periodo: controllo data di default, controllo date valide
                for(Disponibilità disp: lavoratore.disponibilità){
                    if(periodoRicerca.compareTo(disp.getPeriodo())){
                        flag=true;
                    }
                }

                for(String lingua:lingueRicerca){
                    if(lavoratore.lingueParlate.contains(lingua))
                        flag=true;
                }

                for(String mansione: mansioniLavoratoreRicerca){
                    for(Lavoro lavoro: lavoratore.lavori){
                        if(lavoro.getMansioniSvolte().contains(mansione))
                            flag=true;
                    }
                }



                if(flag){
                    String lavoratoreDaScrivere = lavoratore.getNome() + " " + lavoratore.getCognome() + " " + lavoratore.getDataDiNascita() + "\n";
                    String testoDaControllare = textAreaResRicerca.getText();

                    if(!testoDaControllare.contains(lavoratoreDaScrivere))
                        textAreaResRicerca.appendText(lavoratoreDaScrivere);

                }
                flag=false;


            }

        }

    }

    //in effetuaricerche, azione del pulsante che aggiunge le varie mansioni nella textarea
    public void saveMansioniRicerca(ActionEvent actionEvent) {

        if (mansioniRicerca_field.getSelectionModel().getSelectedItem() != null) {

            mansioniRicerca = textAreaMansioniRicerca.getText();

            if (!mansioniRicerca.contains(mansioniRicerca_field.getSelectionModel().getSelectedItem())) {

                textAreaMansioniRicerca.appendText(mansioniRicerca_field.getSelectionModel().getSelectedItem() + "\n");

            } else {

                int index = mansioniRicerca.indexOf(mansioniRicerca_field.getSelectionModel().getSelectedItem());

                textAreaMansioniRicerca.deleteText(index, index + mansioniRicerca_field.getSelectionModel().getSelectedItem().length() + 1);

            }

        }

    }

    //ritorna ad afterlogin e salva la disponibilità(comuni, e periodi)
    //disponibilità -> afterlogin
    public void exitAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setInizioPeriodoRicercaAction(ActionEvent actionEvent) {

        LocalDate mydate = inizioPeriodoRicerca_field.getValue();

        inizioPeriodoRicercaDate.setDay(mydate.getDayOfMonth());
        inizioPeriodoRicercaDate.setMonth(mydate.getMonthValue());
        inizioPeriodoRicercaDate.setYear(mydate.getYear());

    }

    public void setFinePeriodoRicercaAction(ActionEvent actionEvent) {

        LocalDate mydate = finePeriodoRicerca_field.getValue();

        finePeriodoRicercaDate.setDay(mydate.getDayOfMonth());
        finePeriodoRicercaDate.setMonth(mydate.getMonthValue());
        finePeriodoRicercaDate.setYear(mydate.getYear());

    }

    //ci riporta in effettuaricerche
    public void ricercaAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EffettuaRicerche.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    //funzione che inizializza i campi della patente e delle province da selezionare
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        patenteRicerca_field.setItems(model.getList());
        mansioniRicerca_field.getItems().addAll(model.getListaEsperienze());
    }

}
