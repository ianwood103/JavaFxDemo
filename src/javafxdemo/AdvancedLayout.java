package javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdvancedLayout extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Advanced Layout");

        HBox topMenu = new HBox();
        Button fileButton = new Button("File");
        Button editButton = new Button("Edit");
        Button viewButton = new Button("View");
        topMenu.getChildren().addAll(editButton, fileButton, viewButton);

        VBox leftMenu = new VBox();
        Button buttonA = new Button("A");
        Button buttonB = new Button("B");
        Button buttonC = new Button("C");
        leftMenu.getChildren().addAll(buttonA, buttonB, buttonC);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        StackPane layout = new StackPane();
        Scene scene = new Scene(borderPane, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
