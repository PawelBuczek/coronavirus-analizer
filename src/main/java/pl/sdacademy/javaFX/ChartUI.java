package pl.sdacademy.javaFX;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import pl.sdacademy.coronavirus.dao.CovidDao;

import java.time.LocalDate;

public class ChartUI extends VBox {


    private final CovidDao dao;
    Label primaryChart;
    Label totalCases;
    Label countOfTotalCases;
    Label totalDeath;
    Label countOfTotalDeath;

    public ChartUI(CovidDao dao) {
        super();
        //FX12
        this.dao = dao;
        //1
        primaryChart = new Label("Wykres");
        totalCases = new Label("Aktualnie zarażonych na świecie: ");
        countOfTotalCases = new Label("X");
        totalDeath = new Label("Łącznie zgonów na świecie: ");
        countOfTotalDeath = new Label("X");

        //2
        ListView<String> countryListView = new ListView<>();
        countryListView.getItems().addAll("Polska", "Francja", "Włochy", "Włochy");
        countryListView.getSelectionModel().selectFirst();

        //3
        final DatePicker datePicker = new DatePicker();
        datePicker.setOnAction(actionEvent -> {
            LocalDate chooseTheDate;
            chooseTheDate = datePicker.getValue();
            System.err.println("Selected date: " + chooseTheDate);
        });

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
    }
}
