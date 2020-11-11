package javafxdemo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditableTableClass extends Application {

    Stage window;
    TableView<Product> productTable;
    TextField nameInput, priceInput, quantityInput;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Table View");

        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Product, Button> buttonColumn = new TableColumn<>("Buttons");
        buttonColumn.setMinWidth(200);
        buttonColumn.setCellValueFactory(new PropertyValueFactory<>("button"));

        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(100);

        priceInput = new TextField();
        priceInput.setPromptText("Price");

        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");

        Button addButton, deleteButton;
        addButton = new Button("Add");
        addButton.setOnAction(e -> addButtonClicked());
        deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10,10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        productTable = new TableView<>();
        productTable.setItems(getProductList());
        productTable.getColumns().addAll(nameColumn, priceColumn, quantityColumn, buttonColumn);
        productTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(productTable, hBox);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    public void addButtonClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        productTable.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public void deleteButtonClicked() {
        productTable.getItems().removeAll(productTable.getSelectionModel().getSelectedItems());
    }

    public ObservableList<Product> getProductList() {
        ObservableList<Product> productList = FXCollections.observableArrayList();
        productList.add(new Product("Laptop", 859.00, 20, new Button("Laptop")));
        productList.add(new Product("Bouncy Ball", 2.49, 198, new Button("Bouncy Ball")));
        productList.add(new Product("Toilet", 99.00, 74, new Button("Toilet")));
        productList.add(new Product("The Notebook DVD", 9.99, 12, new Button("The Notebook DVD")));
        productList.add(new Product("Corn", 1.49, 856, new Button("Corn")));
        return productList;
    }
}
