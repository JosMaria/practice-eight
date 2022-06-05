package org.genesiscode.practiceeight.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainWindow extends Application {

    @Override
    public void start(Stage stage) {
        MainPane pane = MainPane.getInstance();
        Scene scene = new Scene(pane.getPane());
        stage.setTitle("Practica 8");
        stage.setScene(scene);
        stage.show();
    }
}
