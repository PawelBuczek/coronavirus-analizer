package pl.sdacademy.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyApp2 extends Application {
    @Override
    public void start(Stage stage) {
        VBox firstMainVBox = new VBox();
        Button button = new Button("Start Game");
        Scene scene = new Scene(firstMainVBox, 400, 600);
        stage.setScene(scene);
        stage.show();
    }
}
