/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxdemo;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.w3c.dom.ls.LSOutput;

/**
 *
 * @author ianwood
 */
public class AlertBoxDemo extends Application {
    
    Stage window;
    Button button;
    Button button2;
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Alert Box Demo");
        
        button = new Button("Click me");
        button2 = new Button("Click me?");
        button.setOnAction(e -> AlertBox.display("Title of Window", "This alert box is awesome."));
        button2.setOnAction(e -> {
            boolean result = ConfirmBox.display("Title of Window", "Are you sure about that?");
            System.out.println(result);
        });
        
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button, button2);
        button2.setTranslateY(30);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
