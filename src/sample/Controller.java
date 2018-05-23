package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private ChoiceBox productChoiceBox;

    @FXML
    private TextField priceField;

    @FXML
    private Button addingButton;

    @FXML
    private TableView statesTable;

    @FXML
    private TableColumn statesColumn;

    @FXML
    private TableView addedProductsTable;

    @FXML
    private TableColumn addedProductsColumn;



    //arraylisty troche inny bo javafx,
    private ObservableList<String> productObservableList = FXCollections.observableArrayList();
    private ObservableList<AddedProduct> addedProductsObservableList = FXCollections.observableArrayList();
    private ObservableList<State> statesObservableList = FXCollections.observableArrayList();

    public void initialize(){
        productChoiceBox.setItems(productObservableList);

        //nazwa "stateName" jest powiązana z klasą State, tabele wymagaja innych typow niz String do rozpoznawania kolumn
        statesColumn.setCellValueFactory(new PropertyValueFactory<>("stateName"));
        statesTable.setItems(statesObservableList);

        addedProductsColumn.setCellValueFactory(new PropertyValueFactory<>("addedProductName"));
        addedProductsTable.setItems(addedProductsObservableList);

        //dodanie przykladowych danych
        productObservableList.add("SAMPLE PRODUCT");
        addedProductsObservableList.add(new AddedProduct("test"));
        statesObservableList.add(new State("SAMPLE STATE"));

        addingButton.setOnAction(event -> {
            addedProductsObservableList.add(new AddedProduct(priceField.getText()));
        });


    }



}
