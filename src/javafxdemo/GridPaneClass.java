package javafxdemo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneClass extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("GridPane Example");

        GridPane grid  = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);


        //Name label
        Label nameLabel = new Label("Username:");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name input
        TextField nameInput = new TextField("Ian");
        GridPane.setConstraints(nameInput, 1, 0);

        //Password label
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 1);

        //Password input
        TextField passInput = new TextField();
        passInput.setPromptText("password");
        GridPane.setConstraints(passInput, 1, 1);

        //Login button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);

        loginButton.setOnAction(e -> {
            isInt(nameInput, nameInput.getText());
            System.out.println("Password: " + passInput.getText());
        });

        //Sign up button
        Button signupButton = new Button("Sign Up");
        GridPane.setConstraints(signupButton, 1, 3);

        //Class set up
        loginButton.getStyleClass().add("red-button");
        signupButton.getStyleClass().add("red-button");

        grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton, signupButton);

        Scene scene =  new Scene(grid, 300, 200);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);

        window.show();
    }

    private boolean isInt(TextField input, String text) {
        try {
            int number = Integer.parseInt(input.getText());
            System.out.println("That's a number, not a name, silly.");
            return true;
        } catch(NumberFormatException e) {
            System.out.println("Username: " + text);
            return false;
        }
    }
}
