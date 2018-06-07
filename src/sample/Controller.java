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

    // these two arraylists are neccessary for filling ObservableLists for buttons
    private ArrayList<ImportedProductData> ipal = new ArrayList<>();
    private ArrayList<StateData> sdal = new ArrayList<>();


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
        ipal = product.getImportedProductData();

        DataDownloader dataDownloader = new DataDownloader();
        DataImporter dataImporter = new DataImporter();
        sdal = dataDownloader.DownloadData();
        dataImporter.importData(statesObservableList, sdal);
        dataImporter.importProductData(importedProductDataObservableList, ipal);

        HashSet<String> buf = new HashSet();
        for(ImportedProductData a : ipal)
        {
            buf.add(a.getProductCategory());
        }

        for(String a : buf)
        {
            categoryChoiceOL.add(a);
        }

        buf.clear();

        for(ImportedProductData a : ipal)
        {
            buf.add(a.getProductName());
        }

        for(String a : buf)
        {
            productChoiceOL.add(a);
        }

        categoryChoiceBox.setItems(categoryChoiceOL);
        productChoiceBox.setItems(productChoiceOL);

        mainTableView.setItems(addedProductObservableList);


        stateTableColumn.setCellValueFactory(new PropertyValueFactory<>("stateName"));
        taxTableColumn.setCellValueFactory(new PropertyValueFactory<>("testProductName"));
        mainTableView.getColumns().setAll(stateTableColumn, taxTableColumn);


        addProductButton.setOnAction(event ->
        {
            addedProductObservableList.add(new AddedProduct("10"));
        });




    }




}
