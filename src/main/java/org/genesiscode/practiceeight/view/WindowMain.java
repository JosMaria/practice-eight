package org.genesiscode.practiceeight.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowMain extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new VBox(10, new Label("Practice 8")));
        stage.setTitle("Practica 8");
        stage.setScene(scene);
        stage.show();
    }
}
