package javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuClass extends Application {

    Stage window;
    BorderPane layout;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Menu Class");

        //File menu
        Menu fileMenu = new Menu("File");
        Menu helpMenu = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show Line Numbers");
        showLines.setOnAction(e -> {
            if (showLines.isSelected()) {
                System.out.println("Program will now display line numbers");
            } else {
                System.out.println("Program will now hide line numbers");
            }
        });
        helpMenu.getItems().addAll(showLines);

        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easyRadio = new RadioMenuItem("Easy");
        RadioMenuItem mediumRadio = new RadioMenuItem("Medium");
        RadioMenuItem hardRadio = new RadioMenuItem("Hard");

        easyRadio.setToggleGroup(difficultyToggle);
        mediumRadio.setToggleGroup(difficultyToggle);
        hardRadio.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easyRadio, mediumRadio, hardRadio);


        //Menu items
        MenuItem newFile = new MenuItem("New Project...");
        newFile.setOnAction(e -> System.out.println("Creating new file..."));
        fileMenu.getItems().add(newFile);

        fileMenu.getItems().add(new MenuItem("New Module..."));
        fileMenu.getItems().add(new MenuItem("Import Project..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Settings..."));

        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(e -> System.out.println("Exiting program..."));
        fileMenu.getItems().add(exit);
        exit.setDisable(true);

        //Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu, difficultyMenu);

        layout = new BorderPane();
        layout.setTop(menuBar);

        Scene scene = new Scene(layout, 400, 400);
        window.setScene(scene);
        window.show();
    }
}
