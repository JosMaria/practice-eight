package org.genesiscode.practiceeight.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainPane {

    private static MainPane mainPane;

    private VBox pane;
    private static final Font FONT_SUBTITLE = new Font("Monospace Bold", 14);
    private static final Font FONT_TITLE = new Font("Ubuntu Bold", 20);

    private TextField fieldSalePrice, fieldCost, fieldPriceWithDiscount, fieldDecisionVariable;

    private MainPane() {
        loadControls();
        buildPane();
    }

    public synchronized static MainPane getInstance() {
        return mainPane != null ? mainPane : new MainPane();
    }

    public VBox getPane() {
        return pane;
    }

    private void loadControls() {
        fieldDecisionVariable = new TextField();

        fieldSalePrice = new TextField();
        fieldCost = new TextField();
        fieldPriceWithDiscount = new TextField();
    }

    private VBox decisionVariablePane() {
        Label lblSubtitle = new Label("Varible de Decision");
        lblSubtitle.setFont(FONT_SUBTITLE);
        return new VBox(10, lblSubtitle, buildDataPane(fieldDecisionVariable, "Cantidad Comprada"));
    }

    private VBox parametersPane() {
        Label lblSubtitle = new Label("Parámetros");
        lblSubtitle.setFont(FONT_SUBTITLE);

        return new VBox(10, lblSubtitle,
                buildDataPane(fieldSalePrice, "Precio de Ventas"),
                buildDataPane(fieldCost, "Costo"),
                buildDataPane(fieldPriceWithDiscount, "Precio con Descuento")
        );
    }

    private HBox buildDataPane(TextField field, String text) {
        field.setPrefColumnCount(3);
        HBox pane = new HBox(10, new Label(text), field);
        pane.setAlignment(Pos.CENTER_RIGHT);
        return pane;
    }

    public void buildPane() {
        Label title = new Label("DULCE  ADA ");
        title.setFont(FONT_TITLE);

        this.pane = new VBox(20, title, decisionVariablePane(), parametersPane());
        this.pane.setAlignment(Pos.CENTER);
        this.pane.setPadding(new Insets(10));
    }
}
