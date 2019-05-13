package com.huifer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

/**
 * <p>Title : PassWordController </p>
 * <p>Description : password</p>
 *
 * @author huifer
 * @date 2019-05-13
 */
public class PassWordController {


    @FXML
    private PasswordField passwordField;
    @FXML
    private Label label;
    @FXML
    private Button button;

    @FXML
    void initialize() {

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label.setText("密码：" + passwordField.getText());
            }
        });
    }

}
