package org.genesiscode.practiceeight.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.genesiscode.practiceeight.view.row.RowRandomNumber;

import java.util.List;

public class MainPane {

    private static MainPane mainPane;

    private VBox pane;
    private static final Font FONT_SUBTITLE = new Font("Monospace Bold", 14);
    private static final Font FONT_TITLE = new Font("Ubuntu Bold", 20);

    private TextField fieldSalePrice, fieldCost, fieldPriceWithDiscount, fieldDecisionVariable, fieldRandomNumbers;
    private TableView<RowRandomNumber> randomNumbersTable;

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
        buildRandomNumbersTable();
    }

    private void buildRandomNumbersTable() {
        randomNumbersTable = new TableView<>();
        randomNumbersTable.setMaxWidth(170);
        randomNumbersTable.getColumns().addAll(List.of(
                column("Fila", "rowNumber", 60),
                column("Numero\nAleatorio", "randomNumber", 110)
        ));
        randomNumbersTable.setMaxHeight(300);
    }

    private VBox buildPaneInputRandomNumbers() {
        fieldRandomNumbers = new TextField();
        fieldRandomNumbers.setPrefColumnCount(20);
        Button btnAdd = new Button("Agregar");
        btnAdd.setOnAction(actionEvent -> System.out.println("Agregar"));
        return new VBox(10, new Label("Numeros Aleatorios"), fieldRandomNumbers, btnAdd);
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
        Label title = new Label("DULCE  ADA");
        title.setFont(FONT_TITLE);

        VBox rightPane = new VBox(10, buildPaneInputRandomNumbers(), randomNumbersTable);
        VBox leftPane = new VBox(40, decisionVariablePane(), parametersPane());
        leftPane.setAlignment(Pos.TOP_CENTER);
        pane = new VBox(20, title, new HBox(20, leftPane, rightPane));
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(30));
    }

    private <U, T> TableColumn<U, T> column(String titleColumn, String property, double prefSize) {
        TableColumn<U, T> column = new TableColumn<>(titleColumn);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(prefSize);
        return column;
    }
}
