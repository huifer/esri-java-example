package com.huifer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * <p>Title : MenuController </p>
 * <p>Description : 菜单</p>
 *
 * @author huifer
 * @date 2019-05-14
 */
public class MenuController {

    @FXML
    private Menu menuFile;


    @FXML
    private MenuItem f1;

    @FXML
    private Menu f2;


    @FXML
    void initialize() {

        CheckMenuItem c1 = new CheckMenuItem("Java");
        c1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("java");

            }
        });
        f2.getItems().addAll(
                c1,
                new CheckMenuItem("python"),
                new CheckMenuItem("c++"));

        f1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(f1.getText());
            }
        });
    }

}
