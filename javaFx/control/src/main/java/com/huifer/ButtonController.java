package com.huifer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * <p>Title : ButtonController </p>
 * <p>Description : 按钮控件</p>
 *
 * @author huifer
 * @date 2019-05-10
 */
public class ButtonController {


    /**
     * 使用fx:id 以及@FXML 来获取fxml文件中的一个控件
     */
    @FXML
    private Label testLabel;
    @FXML
    private Button button;


    private Boolean aBoolean = true;


    /**
     * 用来保定button的点击事件
     */
    @FXML
    private void buttonAction() throws Exception {
        if (aBoolean) {
            aBoolean = false;
            testLabel.setText("button 点击后");
        } else {
            aBoolean = true;
            testLabel.setText("button 点击前");

        }
    }

    @FXML
    private void initialize() {
        button.setText("attr");
    }
}
