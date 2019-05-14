package com.huifer;

import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

/**
 * <p>Title : DatePickerController </p>
 * <p>Description : 时间选择器</p>
 *
 * @author huifer
 * @date 2019-05-14
 */
public class DatePickerController {

    @FXML
    private DatePicker datePicker;

    @FXML
    void initialize() {
        datePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                LocalDate value = datePicker.getValue();
                System.out.println(value);

            }
        });
    }


}
