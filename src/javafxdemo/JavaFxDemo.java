/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ianwood
 */
public class JavaFxDemo extends Application implements EventHandler<ActionEvent>{

    Button button;
    Button button2;
    Button button3;
    Button button4;
    
    Scene scene;
    Scene scene2;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Title of the Window");
        //Set up elements for scene1
        button = new Button();
        button.setText("Click me");
        button2 = new Button();
        button2.setText("Don't click me");
        button3 = new Button();
        button3.setText("Click me if you want");
        button4 = new Button("Go to scene 2");
        Label label1 = new Label("Scene 1");
        
        //Set up elements for scene2
        Button button5 = new Button("Go to scene 1");
        Label label2 = new Label("Scene 2");
        
        //Set up button actions for scene1
        button.setOnAction(this);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("button2 clicked");
            }
        });
        button3.setOnAction(e -> System.out.println("button3 clicked"));
        button4.setOnAction(e -> primaryStage.setScene(scene2));
        
        //Set up button action for scene2
        button5.setOnAction(e -> primaryStage.setScene(scene));
        
        //Set up layout for scene1
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button, button2, button3, button4, label1);
        scene = new Scene(layout, 300, 250);
        button2.setTranslateY(30);
        button3.setTranslateY(60);
        button4.setTranslateY(-30);
        label1.setTranslateY(-60);
        
        //Set up layout for scene2
        VBox layout2 = new VBox(20);
        layout2.getChildren().addAll(button5, label2);
        scene2 = new Scene(layout2, 600, 300);
        
        //Sets initial scene and displays it
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button) {
            System.out.println("button clicked");
        }
    }
    
    
}
