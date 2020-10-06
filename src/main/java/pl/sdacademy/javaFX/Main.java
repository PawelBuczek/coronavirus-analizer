package pl.sdacademy.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sdacademy.coronavirus.dao.DummyCovidDao;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(new ChartUI(new DummyCovidDao())));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
