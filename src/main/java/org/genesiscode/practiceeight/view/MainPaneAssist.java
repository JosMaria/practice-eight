package org.genesiscode.practiceeight.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.genesiscode.practiceeight.view.row.RowDataInterval;
import org.genesiscode.practiceeight.view.row.RowResult;

public class MainPaneAssist {

    public static void show(TableView<RowDataInterval> intervalTable, TableView<RowResult> resultTable) {
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Resultados");
        VBox leftPane = new VBox(20, new Label("Tabla de Distribucion de probabilidades de la Demanda"), intervalTable);

        HBox pane = new HBox(10, leftPane, resultTable);
        pane.setPadding(new Insets(10));
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
