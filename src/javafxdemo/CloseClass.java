/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ianwood
 */
public class CloseClass extends Application {
    
    Stage window;
    Button button;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Close Program");
        button = new Button("Close Program");
        
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        
        button.setOnAction(e -> closeProgram());
        
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Title", "Are you sure you want to exit?");
        if (answer) {
            window.close();
        }
    }
}
