package com.huifer;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
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

    Task copyWorker;
    @FXML
    private ProgressBar progressBar;

    @FXML
    void initialize() {

        copyWorker = createWorker();
        progressBar.progressProperty().unbind();
        progressBar.progressProperty().bind(copyWorker.progressProperty());
        copyWorker.messageProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                    String newValue) {
                
                System.out.println(newValue);
            }
        });
        new Thread(copyWorker).start();


    }


    public Task createWorker() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(2000);
                    updateMessage("2000 milliseconds");
                    updateProgress(i + 1, 10);
                }
                return true;
            }
        };
    }
}
