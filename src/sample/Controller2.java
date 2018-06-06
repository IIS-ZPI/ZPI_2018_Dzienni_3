package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Controller2
{

    @FXML
    private ChoiceBox categoryChoiceBox;

    @FXML
    private ChoiceBox productChoiceBox;

    @FXML
    private TextField priceInputBox;

    @FXML
    private Button addProductButton;

    @FXML
    private Button clearTableButton;

    @FXML
    private TableView mainTableView;

    @FXML
    private TableColumn stateTableColumn;

    @FXML
    private TableColumn taxTableColumn;

    private ObservableList<String> categoryObservableList = FXCollections.observableArrayList();
    private ObservableList<String> productObservableList = FXCollections.observableArrayList();
    private ObservableList<AddedProduct> addedProductsObservableList = FXCollections.observableArrayList();

    public void initialize()
    {

        categoryChoiceBox.setItems(categoryObservableList);


        addProductButton.setOnAction(event ->
        {
            System.out.println("x");

        });

    }




}
