module com.huifer.button {

    requires javafx.controls;
    requires javafx.fxml;

    opens com.huifer to javafx.fxml;
    exports com.huifer;
}
