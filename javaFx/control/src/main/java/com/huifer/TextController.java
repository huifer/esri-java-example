package com.huifer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * <p>Title : TextController </p>
 * <p>Description : 文本输入框</p>
 *
 * @author huifer
 * @date 2019-05-13
 */
public class TextController {

    @FXML
    private TextField textField;

    @FXML
    private Label label;

    @FXML
    private Button button;

    @FXML
    void initialize() {

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                label.setText(textField.getText());
            }
        });
    }
}
