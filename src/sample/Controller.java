package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.ArrayList;

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
    private ArrayList<StateData> data = new ArrayList<>();

    public void initialize(){
        productChoiceBox.setItems(productObservableList);

        //nazwa "stateName" jest powiązana z klasą State, tabele wymagaja innych typow niz String do rozpoznawania kolumn
        statesColumn.setCellValueFactory(new PropertyValueFactory<>("stateName"));
        statesTable.setItems(statesObservableList);

        addedProductsColumn.setCellValueFactory(new PropertyValueFactory<>("addedProductName"));
        addedProductsTable.setItems(addedProductsObservableList);

        //dodanie przykladowych danych
        productObservableList.add("SAMPLE PRODUCT");


        addingButton.setOnAction(event ->
        {
            if(addedProductsObservableList.size() > 1)
                addedProductsObservableList.remove(addedProductsObservableList.size()-1);
            addedProductsObservableList.add(new AddedProduct(priceField.getText()));
            if(addedProductsObservableList.get(addedProductsObservableList.size()-1).getAssignmentStatus()==false)
            {
                addedProductsObservableList.remove(addedProductsObservableList.size()-1);
            }
            addedProductsObservableList.add(new AddedProduct(String.valueOf(calculateSum())));
        });
        DataDownloader dataDownloader = new DataDownloader();

        data = dataDownloader.DownloadData();

        DataImporter dataImporter =new DataImporter();
        dataImporter.importData(statesObservableList,data);

        ProductDownloader product = new ProductDownloader("http://pkapust.kis.p.lodz.pl/ZPI/product_list.csv");
        product.downloadProcutList();
    }

    private double calculateSum()
    {
        Double sum = 0.0d;
        for (AddedProduct ap: addedProductsObservableList)
        {
            sum += ap.getValue();
        }
        return sum;
    }

}
