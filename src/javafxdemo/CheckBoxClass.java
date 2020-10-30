package javafxdemo;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxClass extends Application {

    Stage window;
    Scene scene;
    Button button;
    ComboBox<String> comboBox;
    ListView<String> listView;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Sub Shop");

        //Combo box set up
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "Small",
                "Medium",
                "Large"
        );
        comboBox.setPromptText("Sandwich size");
        comboBox.setEditable(true);

        comboBox.setOnAction(e -> System.out.println(comboBox.getValue()));

        //Choice box set up
        ChoiceBox<String> breadBox = new ChoiceBox<>();
        breadBox.getItems().addAll("White", "Wheat", "Rye", "Sourdough");

        //Sets default value on choice box
        breadBox.setValue("White");

        //Listen for selection changes
        breadBox.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> System.out.println(newValue) );

        listView = new ListView<>();
        listView.getItems().addAll("Lettuce", "Tomoto", "Olives", "Pickles", "Onions");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        //Checkboxes
        CheckBox box1 = new CheckBox("Bacon");
        CheckBox box2 = new CheckBox("Tuna");

        //Button
        button = new Button("Order now!");
        button.setOnAction(e -> handleOptions(box1, box2, breadBox, comboBox, listView));

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, breadBox, listView, box1, box2, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    //Handle checkbox options
    private void handleOptions(CheckBox box1, CheckBox box2, ChoiceBox<String> choiceBox, ComboBox<String> comboBox, ListView<String> listView) {
        String message = "User's Order:\n";
        String bread = choiceBox.getValue();

        ObservableList<String> toppings;
        toppings = listView.getSelectionModel().getSelectedItems();

        message += "A " + comboBox.getValue() + " sandwich with ";
        for (String m: toppings) {
            message += m + ", ";
        }

        if (box1.isSelected()) {
            message += "Bacon, ";
        }

        if (box2.isSelected()) {
            message += "Tuna";
        }

        message += " on " + bread + " bread";

        System.out.println(message);
    }
}
