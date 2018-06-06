package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;

public class Controller2
{

    @FXML
    private ChoiceBox<String> categoryChoiceBox;

    @FXML
    private ChoiceBox<String> productChoiceBox;

    @FXML
    private TextField priceInputBox;

    @FXML
    private Button addProductButton;

    @FXML
    private Button clearTableButton;

    @FXML
    private TableView mainTableView;

    @FXML
    private TableColumn<AddedProduct, String> stateTableColumn;

    @FXML
    private TableColumn<AddedProduct, String> taxTableColumn;

    private ObservableList<String> categoryObservableList = FXCollections.observableArrayList();
    private ObservableList<String> productObservableList = FXCollections.observableArrayList();

    /* wrong class is being used here! AddedProduct is used here merely for testing/developing purposes */
    private ObservableList<AddedProduct> addedProductObservableList = FXCollections.observableArrayList();
    private ObservableList<AddedProduct> tableStatesObservableList = FXCollections.observableArrayList();
    private ObservableList<AddedProduct> taxStatesObservableList = FXCollections.observableArrayList();

    /*
    state, podatek, wartość bez podatku, wartość z podatkiem, ile zarabiasz
     */

    public void initialize()
    {
        categoryObservableList.add("Sample category");
        productObservableList.add("Sample product");
        mainTableView.setItems(addedProductObservableList);


        categoryChoiceBox.setItems(categoryObservableList);
        productChoiceBox.setItems(productObservableList);

        stateTableColumn.setCellValueFactory(new PropertyValueFactory<>("addedProductName"));
        taxTableColumn.setCellValueFactory(new PropertyValueFactory<>("testProductName"));
        mainTableView.getColumns().setAll(stateTableColumn, taxTableColumn);


        addProductButton.setOnAction(event ->
        {
            addedProductObservableList.add(new AddedProduct("10"));
        });

    }




}
