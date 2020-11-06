package javafxdemo;

import com.sun.source.tree.Tree;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewClass extends Application {

    Stage window;
    TreeView<String> tree;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Tree View Class");

        TreeItem<String> root, test1, test2, example;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Test1 branch
        test1 = makeBranch("test1", root);
        example = makeBranch("branch1 of test1", test1);
        makeBranch("branch2 of test1", test1);
        makeBranch("branch3 of test1", test1);

        //Test2 branch
        test2 = makeBranch("test2", root);
        makeBranch("branch1 of test2", test2);
        makeBranch("branch2 of test2", test2);
        makeBranch("branch3 of test2", test2);

        //Create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue.getChildren().equals(example.getChildren())) {
                        System.out.println(newValue.getValue());
                    }
                });

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    public TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }
}
