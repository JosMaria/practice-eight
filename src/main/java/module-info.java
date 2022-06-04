module org.genesiscode.practiceeight {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.genesiscode.practiceeight to javafx.fxml;
    exports org.genesiscode.practiceeight;
}