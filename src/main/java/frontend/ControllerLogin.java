package frontend;

import backend.Date;
import backend.DipendenteAgenzia;
import backend.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControllerLogin {

    Model model = Model.getModel();


    private Stage stage;
    private Scene scene;

    @FXML
    TextField username_field;

    @FXML
    PasswordField password_field;

    @FXML
    Label status_label;

    //funzione che verifica i dati inseriti di login e ci porta ad afterlogin
    //login -> afterlogin
    public void loginAction(ActionEvent actionEvent) throws Exception {

        String username_text = username_field.getText();
        String password_text = password_field.getText();

        if (checkCredenziali(username_text, password_text)) {

            model.readJson();
            model.inizializzaListe();

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

    //ci porta in effettuaricerche da afterlogin
    //afterlogin -> effettuaricerche
    public void ricercaAction(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EffettuaRicerche.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public boolean checkCredenziali(String username, String password) throws Exception {

        List<DipendenteAgenzia> dipendenti = new ArrayList<>();

        //inizializzo la lista lavoratori ogni volta che accendo il programma
        DipendenteAgenzia aleLorini = new DipendenteAgenzia("Alessandro", "Lorini", "3317574347", "alelorini99@gmail.it", "Chiari", new Date(06,01,1999), "Italiano", "ale", "ale");
        DipendenteAgenzia gabbaFausty = new DipendenteAgenzia("Gabriele", "Faustinoni", "3288865548", "gabrielefausty7@gmail.it", "Esine", new Date(25,05,2001), "Italiano", "gabba", "gabba");
        DipendenteAgenzia poppoTosini = new DipendenteAgenzia("Giovanni", "Tosini", "3456789090", "poppo@gmail.it", "Soave", new Date(01,01,1995), "Italiano", "poppo", "poppo");

        dipendenti.add(aleLorini);
        dipendenti.add(gabbaFausty);
        dipendenti.add(poppoTosini);

        for (DipendenteAgenzia dipendente:dipendenti) {
            if(username.equals(dipendente.getLogin()) && password.equals(dipendente.getPassword()))
                return true;
        }
        return false;
    }

}
