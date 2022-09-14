module frontend{
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens frontend to javafx.fxml;
    exports frontend;
    exports backend;

    opens backend to com.fasterxml.jackson.databind;
}
