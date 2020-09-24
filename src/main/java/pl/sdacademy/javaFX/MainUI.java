package pl.sdacademy.javaFX;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainUI extends VBox {
    public MainUI() {
        super();
        this.getChildren().add(new Label("Menu główne"));
        this.getChildren().add(new Label("Dane zaktualizowano XX.XX.XXXX"));
        this.getChildren().add(new Button("Aktualizuj dane"));
        this.getChildren().add(new Button("Wyświetl wykres"));
        
    }
}
