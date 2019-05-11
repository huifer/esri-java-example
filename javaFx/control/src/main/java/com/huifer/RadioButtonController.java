package com.huifer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * <p>Title : RadioButtonController </p>
 * <p>Description : 单选框</p>
 *
 * @author huifer
 * @date 2019-05-10
 */
public class RadioButtonController {

    @FXML
    private RadioButton r1;

    @FXML
    private RadioButton r2;

    @FXML
    private ToggleGroup group;

    @FXML
    private Label showLabel;


    @FXML
    void initialize() {
        // 设置真实使用的属性
        r1.setUserData("男");
        r2.setUserData("女");

        // ToggleGroup 监听r1,r2的具体点击情况
        group.selectedToggleProperty().addListener((observableValue, toggle, t1) -> {
            if (group.getSelectedToggle() != null) {
                Object userData = t1.getUserData();
                showLabel.setText(String.valueOf(userData));
                hello(String.valueOf(userData));
            }
        });
    }


    private void hello(String s) {
        System.out.println("当前选择" + s);
    }
}
