package com.huifer;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

/**
 * <p>Title : ProgressBarController </p>
 * <p>Description : 进度条</p>
 *
 * @author huifer
 * @date 2019-05-13
 */
public class ProgressBarController {

    @FXML
    private ProgressBar progressBar;


    @FXML
    void initialize() {

        progressBar.setProgress(0);
        progressBar.setProgress(0.5);



    }
}
