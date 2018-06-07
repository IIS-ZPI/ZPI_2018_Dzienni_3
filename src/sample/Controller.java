package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.HashSet;

public class Controller
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
    private TableColumn<State, String> stateTableColumn;

    @FXML
    private TableColumn<State, String> taxTableColumn;

    @FXML
    private TableColumn valueTableColumn;

    @FXML
    private TableColumn sumTableColumn;

    @FXML
    private TableColumn differenceTableColumn;

    // these two arraylists are neccessary for filling ObservableLists for buttons
    private ArrayList<ImportedProductData> importedProductDataArrayList = new ArrayList<>();
    private ArrayList<StateData> stateDataArrayList = new ArrayList<>();

    private ObservableList<String> categoryChoiceOL = FXCollections.observableArrayList();
    private ObservableList<String> productChoiceOL = FXCollections.observableArrayList();

    private ObservableList<AddedProduct> addedProductObservableList = FXCollections.observableArrayList();
    private ObservableList<ImportedProduct> importedProductDataObservableList = FXCollections.observableArrayList();
    private ObservableList<State> statesObservableList = FXCollections.observableArrayList();



    /*
    state, podatek, wartość bez podatku, wartość z podatkiem, ile zarabiasz
     */

    public void initialize()
    {
        // retrieve list of states and tax values
        ProductDownloader product = new ProductDownloader("http://pkapust.kis.p.lodz.pl/ZPI/product_list.csv");
        product.downloadProductList();
        importedProductDataArrayList = product.getImportedProductData();

        DataDownloader dataDownloader = new DataDownloader();
        DataImporter dataImporter = new DataImporter();
        stateDataArrayList = dataDownloader.DownloadData();
        dataImporter.importData(statesObservableList, stateDataArrayList);
        dataImporter.importProductData(importedProductDataObservableList, importedProductDataArrayList);

        clearForObservableList();

        categoryChoiceBox.setItems(categoryChoiceOL);
        productChoiceBox.setItems(productChoiceOL);

        mainTableView.setItems(addedProductObservableList);


        stateTableColumn.setCellValueFactory(new PropertyValueFactory<>("addedProductName"));
        taxTableColumn.setCellValueFactory(new PropertyValueFactory<>("testProductName"));
        mainTableView.getColumns().setAll(stateTableColumn, taxTableColumn, valueTableColumn);


        addProductButton.setOnAction(event ->
        {
            addedProductObservableList.add(new AddedProduct("10.0f"));
        });
    }

    private void clearForObservableList()
    {
        HashSet<String> buf = new HashSet<>();
        for(ImportedProductData a : importedProductDataArrayList)
        {
            buf.add(a.getProductCategory());
        }

        categoryChoiceOL.addAll(buf);

        buf.clear();

        for(ImportedProductData a : importedProductDataArrayList)
        {
            buf.add(a.getProductName());
        }

        productChoiceOL.addAll(buf);
    }

}
