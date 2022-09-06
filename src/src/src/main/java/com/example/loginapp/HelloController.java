package com.example.loginapp;

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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable{

    private Stage stage;
    private Scene scene;

    ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C");

    @FXML
    ComboBox<String> patente_field = new ComboBox<>();

    ObservableList<String> list2 = FXCollections.observableArrayList("Brescia", "Bergamo", "Verona");

    @FXML
    ComboBox<String> disp_field = new ComboBox<>();

    String[] list3 = {"caz", "in", "cul"};

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
    TextField giorno_field;

    @FXML
    TextField mese_field;

    @FXML
    TextField anno_field;

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
    CheckBox lingue_field;

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
    TextField giornoP_field;

    @FXML
    TextField meseP_field;

    @FXML
    TextField annoP_field;

    @FXML
    TextField giornoP2_field;

    @FXML
    TextField meseP2_field;

    @FXML
    TextField annoP2_field;

    @FXML
    TextField giorno2_field;

    @FXML
    TextField mese2_field;

    @FXML
    TextField anno2_field;

    @FXML
    TextField giorno3_field;

    @FXML
    TextField mese3_field;

    @FXML
    TextField anno3_field;

    @FXML
    TextField nomeA_field;

    @FXML
    TextField luogoA_field;

    @FXML
    TextArea mansioni_field;

    @FXML
    TextField cash_field;


    //fare con database (check admin)
    String username = "admin";
    String password = "admin";
    String codFis = "fstgrl01e25d434q";
    String nome;
    String cognome;
    String luogo;
    String giorno;
    String mese;
    String anno;
    String nazio;
    String via;
    String citta;
    String prov;
    String tel;
    String email;
    String esp;
    String nome2;
    String cognome2;
    String tel2;
    String email2;
    String lingue;
    String patente;
    Boolean auto = false;
    String disp;
    String codFisS;
    String nomeS;
    String cognomeS;
    String giornoP;
    String meseP;
    String annoP;
    String giornoP2;
    String meseP2;
    String annoP2;
    String giorno2;
    String mese2;
    String anno2;
    String giorno3;
    String mese3;
    String anno3;
    String nomeA;
    String luogoA;
    String mansioni;
    String cash;

    public void loginAction(ActionEvent actionEvent) throws IOException {

        String username_text = username_field.getText();
        String password_text = password_field.getText();

        //check con database
        if(username_text.compareTo(username)==0 && password_text.compareTo(password)==0){

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }else{

            status_label.setText("Login status: FIELDS INCORRECT");

        }

    }


    public void addAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AggiungiLavoratore.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void aggAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RicercaLavoratore.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void saveAction(ActionEvent actionEvent) throws IOException {

        nome = nome_field.getText();
        cognome = cognome_field.getText();
        luogo = luogo_field.getText();
        giorno = giorno_field.getText();
        mese = mese_field.getText();
        anno = anno_field.getText();
        nazio = nazio_field.getText();
        via = via_field.getText();
        citta = citta_field.getText();
        prov = prov_field.getText();
        tel = tel_field.getText();
        email = email_field.getText();
        esp = esp_field.getText();
        nome2 = nome2_field.getText();
        cognome2 = cognome2_field.getText();
        tel2 = tel2_field.getText();
        email2 = email2_field.getText();

        if(lingue_field.isSelected()){

            lingue = lingue_field.getText();

        }

        if(patente_field.getSelectionModel().getSelectedItem()!=null){

            patente = patente_field.getSelectionModel().getSelectedItem();

        }

        if(auto_field.isSelected()){

            auto = true;

        }

        if(disp_field.getSelectionModel().getSelectedItem()!=null){

            //disp = textAreaComune.getText();

        }

        System.out.println(nome +  "\n" + cognome + "\n" + luogo + "\n" + giorno + "\n" + mese + "\n" + anno +
                "\n"+ nazio + "\n" + via + "\t" + citta + "\t" + prov + "\n" + tel + "\n" + email + "\n" + esp +
                "\n" + nome2 + "\n" + cognome2 + "\n" + tel2 + "\n" + email2 + "\n" + lingue + "\n" + auto + "\n"
                + patente + "\n" + disp);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("disponibilità.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        patente_field.setItems(list);
        disp_field.getItems().addAll(list3);

    }

    public void save2Action(ActionEvent actionEvent) throws IOException {

        giorno2 = giorno2_field.getText();
        mese2 = mese2_field.getText();
        anno2 = anno2_field.getText();
        giorno3 = giorno3_field.getText();
        mese3 = mese3_field.getText();
        anno3 = anno3_field.getText();
        nomeA = nomeA_field.getText();
        luogoA = luogoA_field.getText();
        mansioni = mansioni_field.getText();
        cash = cash_field.getText();

        System.out.println(giorno2 + "\n" + mese2 + "\n" + anno2 + "\n" + giorno3 + "\n" + mese3 + "\n" + anno3 + "\n"
                + nomeA + "\n" + luogoA + "\n" + mansioni + "\n" + cash + "\n");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void searchAction(ActionEvent actionEvent) throws IOException {

        nomeS = nomeS_field.getText();
        cognomeS = cognomeS_field.getText();
        codFisS = codFis_field.getText();

        if(nomeS.compareTo(username)==0 && cognomeS.compareTo(password)==0 && codFisS.compareTo(codFis)==0){

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AggiornaLavoro.fxml")));
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

    public void saveComune(ActionEvent actionEvent) {

        if(disp_field.getSelectionModel().getSelectedItem()!=null){

            disp = textAreaComune.getText();

            if(!disp.contains(disp_field.getSelectionModel().getSelectedItem())) {

                textAreaComune.appendText(disp_field.getSelectionModel().getSelectedItem() + "\n");

            }else{

                int index = disp.indexOf(disp_field.getSelectionModel().getSelectedItem());

                textAreaComune.deleteText(index, index + disp_field.getSelectionModel().getSelectedItem().length()+1);

            }

        }

    }

    public void save3Action(ActionEvent actionEvent) throws IOException {

        //salvo parametri periodi e zone

        System.out.println("Salvo date e periodi:\n");

        giornoP = giornoP_field.getText();
        meseP = meseP_field.getText();
        annoP = annoP_field.getText();
        giornoP2 = giornoP2_field.getText();
        meseP2 = meseP2_field.getText();
        annoP2 = annoP2_field.getText();

        System.out.println("da: " + giornoP + " / " + meseP + " / " + annoP + " a: " + giornoP2 + " / " + meseP2 + " / "
                + annoP2 + "\n" + "Nei comuni di: " + textAreaComune.getText());

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("disponibilità.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void exitAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void ricercaAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EffettuaRicerche.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void search2Action(ActionEvent actionEvent) {

        //da implementare

        System.out.println("SCEMO CHI LEGGE (SIETE TUTTI E DUE DEI TACCHINI FIGA)");

    }
}
