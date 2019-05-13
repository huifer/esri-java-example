package com.huifer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * <p>Title : LoginController </p>
 * <p>Description : 登陆</p>
 *
 * @author huifer
 * @date 2019-05-13
 */
public class LoginController {

    @FXML
    private Button loginButton;
    @FXML
    private TextField user;
    @FXML
    private PasswordField pwd;


    @FXML
    void initialize() {

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (user.getText().equals("1") && pwd.getText().equals("1")) {
                    loginInfo("登陆成功");
                } else {
                    loginInfo("登陆失败");
                }
            }
        });


    }

    private void loginInfo(String loginfo) {
        Scene scene = new Scene(new Group());
        Stage stage = new Stage();
        stage.setTitle("登录信息");

        Label label = new Label();
        label.setText(loginfo);
        label.setTextFill(Color.web("#032677"));
        ((Group) scene.getRoot()).getChildren().add(label);

        stage.setScene(scene);
        stage.show();
    }
}
