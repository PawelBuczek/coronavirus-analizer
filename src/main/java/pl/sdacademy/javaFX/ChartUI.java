package pl.sdacademy.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ChartUI extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage secondStage) throws IOException {


//        List<CovidDataForDateAndCountryFromAPI> listDataSample = ApiDataProvider.getListOfCovidCountryStatusFromJason("src/main/resources/covidData_25Sep_2020_sample.json");
//        ListView<String> listView = new ListView<>();
//        listDataSample.forEach(countryStatus -> {
//            listOfCountries.add(countryStatus());
//            return listDataSample;
//        });

        ListView<String> listView = new ListView<>();
        listView.setPrefSize(200, 400);
        listView.getItems().addAll("Polska", "Francja", "Włochy", "Norwegia", "Japonia");
        listView.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE);
        listView.getItems().addAll();

        VBox vBox = new VBox(5, listView);
        vBox.getChildren().add(new Label("Wykres"));
        vBox.getChildren().add(new Label("Aktualnie zarażonych na świecie: "));
        vBox.getChildren().add(new Label("X"));
        vBox.getChildren().add(new Label("Łącznie zgonów na świecie: "));
        vBox.getChildren().add(new Label("X"));

        Scene scene = new Scene(vBox, 400, 400);
        secondStage.setScene(scene);
        secondStage.show();

    }
}

