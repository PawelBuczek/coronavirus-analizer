package pl.sdacademy.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChartUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        VBox vBox = new VBox();
        vBox.getChildren().add(new Label("Wykres"));
        vBox.getChildren().add(new Label("Aktualnie zarażonych na świecie:"));
        vBox.getChildren().add(new Label("X"));
        vBox.getChildren().add(new Label("Łącznie zgonów na świecie:"));
        vBox.getChildren().add(new Label("X"));

        Scene scene = new Scene(vBox, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

