package pl.sdacademy.javaFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdacademy.coronavirus.CovidDao;
import pl.sdacademy.coronavirus.EntityDataProvider;

public class MainUI extends VBox {
    Button buttonShowGraph;
    Button buttonRefreshData;
    Label labelMainMenu;
    Label labelLastUpdate;
    CovidDao covidDao;
    EntityDataProvider entityDataProvider;

    public MainUI(Stage stage, CovidDao covidDao, EntityDataProvider entityDataProvider) {
        super();
        buttonShowGraph = new Button("Wyświetl wykres");
        buttonRefreshData = new Button("Aktualizuj dane");
        labelMainMenu = new Label("Menu główne");
        labelLastUpdate = new Label("Dane zaktualizowano XX.XX.XXXX");
        this.getChildren().add(buttonShowGraph);
        this.getChildren().add(buttonRefreshData);
        this.getChildren().add(labelMainMenu);
        this.getChildren().add(labelLastUpdate);
        buttonShowGraph.setOnAction(event -> showGraph(stage));
        buttonRefreshData.setOnAction(event -> refreshData(stage));
        this.setAlignment(Pos.CENTER);
        this.covidDao = covidDao;
        this.entityDataProvider = entityDataProvider;
    }

    private void showGraph(Stage stage) {
        VBox graphVBox = new VBox();
        Label topInfo = new Label("Here be graph");
        graphVBox.getChildren().add(topInfo);
        Scene graphScene = new Scene(graphVBox, 600, 800);
        stage.setScene(graphScene);
    }

    private void refreshData(Stage stage) {
        //rzeczy sie tu beda dziac
    }
}
