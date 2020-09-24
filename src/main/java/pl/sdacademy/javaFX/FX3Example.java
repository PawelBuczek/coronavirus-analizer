package pl.sdacademy.javaFX;

import javafx.application.Application;
import javafx.scene.Scene;
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
