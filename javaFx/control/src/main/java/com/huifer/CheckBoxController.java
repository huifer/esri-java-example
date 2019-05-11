package com.huifer;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

/**
 * <p>Title : CheckBoxController </p>
 * <p>Description : checkBox</p>
 *
 * @author huifer
 * @date 2019-05-10
 */
public class CheckBoxController {

    @FXML
    private CheckBox c1;
    @FXML
    private CheckBox c2;
    @FXML
    private CheckBox c3;
    @FXML
    private Label label;

    @FXML
    private Button button;

    private ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxes = FXCollections.observableSet();

    private IntegerBinding numCheckBoxesSelected = Bindings.size(selectedCheckBoxes);

    @FXML
    private void initialize() {
        c1.setUserData("c1");
        c2.setUserData("c2");
        c3.setUserData("c3");
        configureCheckBox(c1);
        configureCheckBox(c2);
        configureCheckBox(c3);

        /**
         * 最多选择2个
         */
        int maxSelect = 2;
        numCheckBoxesSelected.addListener((obs, oldSelectedCount, newSelectedCount) -> {

            String s = selectString();
            label.setText(s);
            if (newSelectedCount.intValue() >= maxSelect) {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(true));
            } else {
                unselectedCheckBoxes.forEach(cb -> cb.setDisable(false));
            }
        });

        // 题外话: 此处的按钮仅用来形容勾选复选框后的操作
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                int size = selectedCheckBoxes.size();
                System.out.println("当前选择的数量" + size);

            }
        });

    }

    private String selectString() {
        StringBuilder sb = new StringBuilder();
        selectedCheckBoxes.forEach(s -> sb.append(s.getUserData()));
        return sb.toString();
    }


    /**
     * 配置选择框到底在那个列表中
     */
    private void configureCheckBox(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            selectedCheckBoxes.add(checkBox);
        } else {
            unselectedCheckBoxes.add(checkBox);
        }

        checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue,
                    Boolean wasSelected, Boolean isNowSelected) {
                if (isNowSelected) {
                    unselectedCheckBoxes.remove(checkBox);
                    selectedCheckBoxes.add(checkBox);

                } else {
                    selectedCheckBoxes.remove(checkBox);
                    unselectedCheckBoxes.add(checkBox);
                }
            }
        });

    }
}
