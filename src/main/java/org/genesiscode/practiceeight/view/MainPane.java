package org.genesiscode.practiceeight.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.genesiscode.practiceeight.service.DulceAda;
import org.genesiscode.practiceeight.service.utils.Util;
import org.genesiscode.practiceeight.view.row.RowDataInterval;
import org.genesiscode.practiceeight.view.row.RowRandomNumber;
import org.genesiscode.practiceeight.view.row.RowResult;

import java.util.List;

public class MainPane {

    private static MainPane mainPane;
    private final DulceAda dulceAda;

    private VBox pane;
    private static final Font FONT_SUBTITLE = new Font("Monospace Bold", 14);
    private static final Font FONT_TITLE = new Font("Ubuntu Bold", 20);

    private TextField fieldSalePrice, fieldCost, fieldPriceWithDiscount, fieldDecisionVariable, fieldRandomNumbers;
    private TableView<RowRandomNumber> randomNumbersTable;
    private TableView<RowDataInterval> dataIntervalTable;
    private TableView<RowResult> resultTable;

    private MainPane() {
        dulceAda = DulceAda.getInstance();
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
        buildDataIntervalTable();
        buildResultTable();
    }

    private void buildRandomNumbersTable() {
        randomNumbersTable = new TableView<>();
        randomNumbersTable.setMaxWidth(175);
        randomNumbersTable.setMaxHeight(300);
        randomNumbersTable.getColumns().addAll(List.of(
                column("Fila", "rowNumber", 60),
                column("Numero\nAleatorio", "randomNumber", 110)
        ));
    }

    private VBox buildPaneInputRandomNumbers() {
        fieldRandomNumbers = new TextField();
        fieldRandomNumbers.setPrefColumnCount(20);
        Button btnAdd = new Button("Agregar");
        btnAdd.setOnAction(actionEvent -> click_btn_add());
        return new VBox(10, new Label("Numeros Aleatorios"), fieldRandomNumbers, btnAdd);
    }

    private void click_btn_add() {
        List<Double> list = Util.convertToList(fieldRandomNumbers.getText());
        dulceAda.setRandomNumbers(list);
        randomNumbersTable.setItems(dulceAda.getObservableListRandomNumbers());
    }

    private VBox decisionVariablePane() {
        Label lblSubtitle = new Label("Varible de Decision");
        lblSubtitle.setFont(FONT_SUBTITLE);
        return new VBox(10, lblSubtitle, buildDataPane(fieldDecisionVariable, "Cantidad Comprada"));
    }

    private VBox parametersPane() {
        Label lblSubtitle = new Label("Parámetros");
        lblSubtitle.setFont(FONT_SUBTITLE);

        Button start = new Button("Comenzar");
        start.setOnAction(actionEvent -> click_btn_start());
        HBox buttonPane = new HBox(start);
        buttonPane.setPadding(new Insets(30));
        buttonPane.setAlignment(Pos.CENTER);

        return new VBox(10, lblSubtitle,
                buildDataPane(fieldSalePrice, "Precio de Ventas"),
                buildDataPane(fieldCost, "Costo"),
                buildDataPane(fieldPriceWithDiscount, "Precio con Descuento"),
                buttonPane
        );
    }

    private void click_btn_start() {
        dataIntervalTable.setItems(dulceAda.getObservableListInterval());
        MainPaneAssist.show(dataIntervalTable, resultTable);
    }

    private HBox buildDataPane(TextField field, String text) {
        field.setPrefColumnCount(3);
        HBox pane = new HBox(10, new Label(text), field);
        pane.setAlignment(Pos.CENTER_RIGHT);
        return pane;
    }

    private void buildPane() {
        Label title = new Label("DULCE  ADA");
        title.setFont(FONT_TITLE);

        VBox rightPane = new VBox(10, buildPaneInputRandomNumbers(), randomNumbersTable);
        VBox leftPane = new VBox(40, decisionVariablePane(), parametersPane());
        leftPane.setAlignment(Pos.TOP_CENTER);
        pane = new VBox(20, title, new HBox(20, leftPane, rightPane));
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(30));
    }

    private void buildDataIntervalTable() {
        dataIntervalTable = new TableView<>();
        dataIntervalTable.maxWidth(380);
        dataIntervalTable.getColumns().addAll(List.of(
                column("Probabilidad", "probability", 100),
                column("Distribución\nAcumulada", "accumulated", 100),
                column("Rango de #s\naleatorios", "range", 140),
                column("Demanda", "demand", 80)));
    }

    private void buildResultTable() {
        resultTable = new TableView<>();
        resultTable.maxWidth(400);
        resultTable.getColumns().addAll(List.of(
                column("Replica", "replica", 100),
                column("# Aleatorio", "randomNumber", 100),
                column("Demanda", "demand", 100),
                column("Ganancia", "gain", 100)));

    }

    private <U, T> TableColumn<U, T> column(String titleColumn, String property, double prefSize) {
        TableColumn<U, T> column = new TableColumn<>(titleColumn);
        column.setCellValueFactory(new PropertyValueFactory<>(property));
        column.setPrefWidth(prefSize);
        return column;
    }
}
