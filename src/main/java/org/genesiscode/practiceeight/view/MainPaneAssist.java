package org.genesiscode.practiceeight.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.genesiscode.practiceeight.view.row.RowDataInterval;
import org.genesiscode.practiceeight.view.row.RowResult;

public class MainPaneAssist {

    private static final Font FONT_SUBTITLE = new Font("Monospace Bold", 15);

    public static void show(TableView<RowDataInterval> intervalTable, TableView<RowResult> resultTable) {
        Stage stage = new Stage(StageStyle.DECORATED);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Resultados");
        VBox leftPane = new VBox(20, new Label("Tabla de Distribucion de probabilidades de la Demanda"), intervalTable);
        Label title = new Label("TABLA DE SIMULACIÓN");
        title.setFont(FONT_SUBTITLE);
        VBox rightPane = new VBox(10, title, resultTable);
        rightPane.setAlignment(Pos.CENTER);
        HBox pane = new HBox(30, leftPane, rightPane);
        pane.setPadding(new Insets(30));

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
