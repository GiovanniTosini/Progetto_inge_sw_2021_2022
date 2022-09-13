package frontend;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        stage.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login2.fxml")));
        stage.setTitle("PAG TECNOLOGY");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public static void main(String[] args) throws Exception {
        launch();
    }
}