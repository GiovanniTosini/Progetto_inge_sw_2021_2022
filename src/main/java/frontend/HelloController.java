package frontend;

import backend.Date;
import backend.Periodo;
import backend.Residenza;
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
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class HelloController implements Initializable {

    private Stage stage;
    private Scene scene;

    ObservableList<String> list = FXCollections.observableArrayList("A", "B", "C", "D");
    Set<String> comuni = new HashSet<>();
    Map<Periodo,Set<String>> mappaPeriodi = new HashMap();

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


    //fare con database (check admin)
    String username = "admin";
    String password = "admin";
    String codFis = "fstgrl01e25d434q";
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
    Date birthDate = new Date(01,01,2000);
    Date inizioPeriodoDate = new Date(01,01,2000);
    Date finePeriodoDate = new Date(01,01,2000);

    public HelloController() throws Exception {
    }

    public void loginAction(ActionEvent actionEvent) throws IOException {

        String username_text = username_field.getText();
        String password_text = password_field.getText();

        //check con database
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


    public void addAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AggiungiLavoratore.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void aggAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RicercaLavoratore.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void saveAction(ActionEvent actionEvent) throws IOException {

        Set<String> lingue = new HashSet<>();

        nome = nome_field.getText();
        cognome = cognome_field.getText();
        luogo = luogo_field.getText();
        nazio = nazio_field.getText();

        Residenza residenza = new Residenza(via_field.getText(), citta_field.getText(), prov_field.getText());

        tel = tel_field.getText();
        email = email_field.getText();
        esp = esp_field.getText();
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

        System.out.println(nome + "\n" + cognome + "\n" + luogo + "\n" + "\n" + nazio + "\n" + "\n" + tel + "\n" + email + "\n" + esp +
                "\n" + nome2 + "\n" + cognome2 + "\n" + tel2 + "\n" + email2 + "\n" + "\n" + auto + "\n"
                + patente + "\n" + disp);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("disponibilità.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

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

    public void save2Action(ActionEvent actionEvent) throws IOException {

        nomeA = nomeA_field.getText();
        luogoA = luogoA_field.getText();
        mansioni = mansioni_field.getText();
        cash = cash_field.getText();

        System.out.println(nomeA + "\n" + luogoA + "\n" + mansioni + "\n" + cash + "\n");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void searchAction(ActionEvent actionEvent) throws IOException {

        nomeS = nomeS_field.getText();
        cognomeS = cognomeS_field.getText();
        codFisS = codFis_field.getText();

        if (nomeS.compareTo(username) == 0 && cognomeS.compareTo(password) == 0 && codFisS.compareTo(codFis) == 0) {

            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AggiornaLavoro.fxml")));
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

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

    public void save3Action(ActionEvent actionEvent) throws IOException {

        //salvo parametri periodi e zone

        Periodo periodo = new Periodo(inizioPeriodoDate, finePeriodoDate);

        String testo = textAreaComune.getText();

        String[] arrComuni = testo.split("\n");

        for (String stringa: arrComuni) {
            comuni.add(stringa);
        }

        //inizializzazione mappa

        mappaPeriodi.put(periodo,comuni);

        System.out.println(mappaPeriodi);

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("disponibilità.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void exitAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterlogin.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void ricercaAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EffettuaRicerche.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void search2Action(ActionEvent actionEvent) {

        //da implementare

        System.out.println("SCEMO CHI LEGGE (SIETE TUTTI E DUE DEI TACCHINI FIGA)");

    }

    public void setBirthDate(ActionEvent actionEvent) throws Exception {

        int day;
        int month;
        int year;

        LocalDate mydate = data_field.getValue();

        day = mydate.getDayOfMonth();
        month = mydate.getMonthValue();
        year = mydate.getYear();

        birthDate.setDay(day);
        birthDate.setMonth(month);
        birthDate.setYear(year);

    }

    public void setInizioPeriodo(ActionEvent actionEvent) {

        int day;
        int month;
        int year;

        LocalDate mydate = dataP_field.getValue();

        day = mydate.getDayOfMonth();
        month = mydate.getMonthValue();
        year = mydate.getYear();

        inizioPeriodoDate.setDay(day);
        inizioPeriodoDate.setMonth(month);
        inizioPeriodoDate.setYear(year);

    }

    public void setFinePeriodo(ActionEvent actionEvent) {

        int day;
        int month;
        int year;

        LocalDate mydate = dataP2_field.getValue();

        day = mydate.getDayOfMonth();
        month = mydate.getMonthValue();
        year = mydate.getYear();

        finePeriodoDate.setDay(day);
        finePeriodoDate.setMonth(month);
        finePeriodoDate.setYear(year);

    }
}
