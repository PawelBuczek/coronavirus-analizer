package pl.sdacademy.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainUI extends Application {
    private Label label;

    @Override
    public void start(Stage stage) {
        VBox vBox = new VBox();
        vBox.getChildren().add(new Label("Menu główne"));
        vBox.getChildren().add(new Label("Dane zaktualizowano XX.XX.XXXX"));

        vBox.getChildren().add(new Button("Aktualizuj dane"));
        vBox.getChildren().add(new Button("Wyświetl wykres"));

        Scene scene = new Scene(vBox, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    // run test
    public static void main(String[] args) {
        launch();
    }
}
