package org.genesiscode.practiceeight.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.genesiscode.practiceeight.view.row.RowDataInterval;

public class MainPaneAssist {

    public static void show(TableView<RowDataInterval> intervalTable) {
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Resultados");

        VBox leftPane = new VBox(20, new Label("Tabla de Distribucion de probabilidades de la Demanda"), intervalTable);
        leftPane.setPadding(new Insets(10));
        Scene scene = new Scene(leftPane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
