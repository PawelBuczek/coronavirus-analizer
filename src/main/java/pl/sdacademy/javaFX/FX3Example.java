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
        VBox firstMainVBox = new VBox();
        Button button = new Button("ShowGraph");
        button.setOnAction(event -> showGraph(stage));
        firstMainVBox.getChildren().add(button);
        firstMainVBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(firstMainVBox, 400, 600);
        stage.setScene(scene);
        stage.show();
    }
    private void showGraph(Stage stage) {
        VBox graphVBox = new VBox();
        Label topInfo = new Label("Here be graph");
        graphVBox.getChildren().add(topInfo);
        Scene graphScene = new Scene(graphVBox, 600, 800);
        stage.setScene(graphScene);
    }
}
