package pl.sdacademy.javaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FX3Example extends Application {
    @Override
    public void start(Stage stage) {
        MainUI firstMainVBox = new MainUI(stage);
        Scene scene = new Scene(firstMainVBox, 400, 600);
        stage.setScene(scene);
        stage.show();
    }
}
