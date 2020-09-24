package pl.sdacademy.javaFX;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyApp extends Application {

    @Override
    public void start(Stage stage) {
        VBox vBox = new VBox();
        vBox.getChildren().add(new Label("Menu główne"));
        vBox.getChildren().add(new Label("Dane zaktualizowano XX.XX.XXXX"));

        vBox.getChildren().add(new Button("Aktualizuj dane"));
        vBox.getChildren().add(new Button("Wyświetl wykres"));
    }

}
