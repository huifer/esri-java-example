package com.huifer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

/**
 * <p>Title : ChoiceBoxController </p>
 * <p>Description : 下拉选择器</p>
 *
 * @author huifer
 * @date 2019-05-13
 */
public class ChoiceBoxController {

    @FXML
    private ChoiceBox choiceBox;
    @FXML
    private Label label;


    @FXML
    private void initialize() {

//        defaultWithFxml();
        userDefinedItems();
    }

    /**
     * 自定义items
     */
    private void userDefinedItems() {
        ObservableList<String> strings = FXCollections.observableArrayList("A", "B", "C", "D");
        choiceBox.setItems(strings);
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue,
                            Number number, Number t1) {
                        System.out.println("当前选择" + strings.get(t1.intValue()));

                        label.setText(String.valueOf(strings.get(t1.intValue())));
                    }
                });
    }


    /**
     * 使用fxml中写好的参数
     */
    private void defaultWithFxml() {
        ObservableList items = choiceBox.getItems();

        choiceBox.getSelectionModel().selectedIndexProperty().addListener(
                new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observableValue,
                            Number number, Number t1) {
                        Object o = items.get(t1.intValue());
                        System.out.println("当前选择" + o);
                        label.setText(String.valueOf(o));
                    }
                });
    }


}
