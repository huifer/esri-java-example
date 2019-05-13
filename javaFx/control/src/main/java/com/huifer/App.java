package com.huifer;

import java.io.IOException;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 控件
 *
 * @author huifer
 */
public class App extends Application {

    private static Scene scene;

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        // label 标签
//        helloLabelNotFxml(stage);
//        helloLabelFxml(stage);

        // button 按钮
//        helloButtonFxml(stage);
//        helloButtonNotFxml(stage);

        // RadioButton 单选框
//        helloRadioButtonFxml(stage);
//        helloRadioButtonNotFxml(stage);

        // check box 勾选框
//        helloCheckBoxFxml(stage);

//        choiceBox 下拉选择器
//        helloChoiceBoxFxml(stage);

        // textField 文本输入框
//        helloTextField(stage);

//        password 密码框
        helloPassWord(stage);
        // 登陆
//        login(stage);

        // 进度条
        helloProgressBar(stage);
    }

    private void helloProgressBar(Stage stage) throws IOException {
        scene = new Scene(loadFXML("progressBar"));
        stage.setTitle("hello ProgressBar");
        stage.setScene(scene);
        stage.show();
    }

    private void login(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"));
        stage.setTitle("login");
        stage.setScene(scene);
        stage.show();
    }

    private void helloPassWord(Stage stage) throws IOException {
        scene = new Scene(loadFXML("password"));
        stage.setTitle("hello password");
        stage.setScene(scene);
        stage.show();
    }

    private void helloTextField(Stage stage) throws IOException {
        scene = new Scene(loadFXML("textField"));
        stage.setTitle("hello textField");
        stage.setScene(scene);
        stage.show();
    }

    private void helloChoiceBoxFxml(Stage stage) throws IOException {
        scene = new Scene(loadFXML("choiceBox"));
        stage.setTitle("hello choiceBox");
        stage.setScene(scene);
        stage.show();
    }

    private void helloCheckBoxFxml(Stage stage) throws IOException {
        scene = new Scene(loadFXML("checkBox"));
        stage.setTitle("hello checkBox");
        stage.setScene(scene);
        stage.show();
    }

    private void helloRadioButtonNotFxml(Stage stage) {
        scene = new Scene(new Group());
        stage.setTitle("hello RadioButton");
        stage.setWidth(400);
        stage.setHeight(400);

        ToggleGroup group = new ToggleGroup();
        RadioButton r1 = new RadioButton("r1");
        r1.setToggleGroup(group);
        r1.setUserData("r1");

        RadioButton r2 = new RadioButton("r2");
        r2.setToggleGroup(group);
        r2.setUserData("r2");

        RadioButton r3 = new RadioButton("r3");
        r3.setToggleGroup(group);
        r3.setUserData("r3");

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle,
                    Toggle t1) {
                if (group.getSelectedToggle() != null) {
                    System.out.println(group.getSelectedToggle().getUserData());
                    System.out.println(t1.getUserData().toString());
                }
            }
        });
        HBox hBox = new HBox();
        VBox vBox = new VBox();

        vBox.getChildren().add(r1);
        vBox.getChildren().add(r2);
        vBox.getChildren().add(r3);

        hBox.getChildren().add(vBox);

        hBox.setSpacing(50);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        ((Group) scene.getRoot()).getChildren().add(hBox);

        stage.setScene(scene);
        stage.show();

    }

    private void helloRadioButtonFxml(Stage stage) throws IOException {
        scene = new Scene(loadFXML("RadioButton"));
        stage.setTitle("hello RadioButton");
        stage.setScene(scene);
        stage.show();
    }

    private void helloLabelNotFxml(Stage stage) throws IOException {
        scene = new Scene(new Group());
        stage.setTitle("hello Label");
        stage.setWidth(400);
        stage.setHeight(400);

        HBox hBox = new HBox();
        Label label = new Label("标签");
        label.setTextFill(Color.web("#032677"));
        hBox.setSpacing(10);
        hBox.getChildren().add(label);
        ((Group) scene.getRoot()).getChildren().add(hBox);

        stage.setScene(scene);
        stage.show();

    }

    private void helloLabelFxml(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Label"));
        stage.setTitle("hello Label2");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * 通过文件读取来显示按钮
     */
    private void helloButtonFxml(Stage stage) throws IOException {
        scene = new Scene(loadFXML("button"));
        stage.setTitle("hello button1");
        stage.setScene(scene);
        stage.show();
    }

    private void helloButtonNotFxml(Stage stage) throws IOException {

        stage.setTitle("hello button2");
        Button button = new Button();

        button.setText("button");
        button.setOnAction(actionEvent -> System.out.println("button onclick"));

        StackPane root = new StackPane();
        root.getChildren().add(button);
        stage.setScene(new Scene(root, 300, 250));
        stage.show();


    }
}
