package javafxdemo;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PropertyClass extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Property Example");

        Person ian = new Person();
        ian.firstNameProperty().addListener((v, oldValue, newValue) -> {
            System.out.println("Name changed to " + newValue);
            System.out.println("firstNameProperty(): " + ian.firstNameProperty());
            System.out.println("getFirstName(): " + ian.getFirstName());
        });

        Button button = new Button("Submit");
        button.setOnAction(e -> {
            ian.setFirstName("Porky");
        });

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty();

        y.bind(x.multiply(10));
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue());

        x.setValue(9);
        System.out.println("x: " + x.getValue());
        System.out.println("y: " + y.getValue());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
