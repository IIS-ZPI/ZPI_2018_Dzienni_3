package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.*;

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
    private TableColumn<MainTableContainer, String> stateTableColumn;

    @FXML
    private TableColumn<MainTableContainer, String> earningsColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> taxTableColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> minimumDesiredMarginColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> basePriceColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> marginColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> priceBeforeTaxingColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> endResultTableColumn;

    private boolean isInfoDisplayed = false;

    // these two arraylists are neccessary for filling ObservableLists for buttons
    private ArrayList<ImportedProductData> importedProductDataArrayList = new ArrayList<>();
    private ArrayList<StateData> stateDataArrayList = new ArrayList<>();

    private ObservableList<String> categoryChoiceOL = FXCollections.observableArrayList();
    private ObservableList<String> productChoiceOL = FXCollections.observableArrayList();
    private ObservableList<MainTableContainer> mainTableContainerObservableList = FXCollections.observableArrayList();

    private ObservableList<ImportedProduct> importedProductDataObservableList = FXCollections.observableArrayList();
    private ObservableList<State> statesObservableList = FXCollections.observableArrayList();
    private HashMap<String, String> importedProductDataCategoryList;

    private double margin = 0.1;

    /*
    state, podatek, wartość bez podatku, wartość z podatkiem, ile zarabiasz
     */

    public void initialize()
    {

        // retrieve list of states and tax values
        ProductDownloader product = new ProductDownloader("http://pkapust.kis.p.lodz.pl/ZPI/product_list.csv");
        product.downloadProductList();
        importedProductDataArrayList = product.getImportedProductData();
        importedProductDataCategoryList = product.getProductWithCategory();

        DataDownloader dataDownloader = new DataDownloader();
        DataImporter dataImporter = new DataImporter();
        stateDataArrayList = dataDownloader.DownloadData();
        dataImporter.importData(statesObservableList, stateDataArrayList);
        dataImporter.importProductData(importedProductDataObservableList, importedProductDataArrayList);

        clearObservableList();

        categoryChoiceBox.setItems(categoryChoiceOL);
        productChoiceBox.setItems(productChoiceOL);


        mainTableView.setItems(mainTableContainerObservableList);


        stateTableColumn.setCellValueFactory(new PropertyValueFactory<>("stateName"));
        taxTableColumn.setCellValueFactory(new PropertyValueFactory<>("tax"));
        basePriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        minimumDesiredMarginColumn.setCellValueFactory(new PropertyValueFactory<>("minimumDesiredMargin"));
        marginColumn.setCellValueFactory(new PropertyValueFactory<>("marginForProduct"));
        priceBeforeTaxingColumn.setCellValueFactory(new PropertyValueFactory<>("priceBeforeTaxingSDP"));
        endResultTableColumn.setCellValueFactory(new PropertyValueFactory<>("endPrice"));
        earningsColumn.setCellValueFactory(new PropertyValueFactory<>("earnings"));

        mainTableView.getColumns().setAll(stateTableColumn, taxTableColumn, basePriceColumn, minimumDesiredMarginColumn, marginColumn, priceBeforeTaxingColumn, endResultTableColumn, earningsColumn);

        addProductButton.setOnAction(event ->
        {
            if(!isInfoDisplayed)
            {
                ImportedProductData ip = new ImportedProductData();
                for(ImportedProductData ip2 : importedProductDataArrayList)
                {
                    if(ip2.getProductName().equals(productChoiceBox.getValue()))
                        ip = ip2;
                }

                for (StateData aStateDataArrayList : stateDataArrayList)
                    mainTableContainerObservableList.add(new MainTableContainer(
                            aStateDataArrayList.getStateName(),
                            aStateDataArrayList.getBaseTaxConverted(),
                            ip.getProductValue(),
                            margin,
                            priceInputBox.getText()));
                isInfoDisplayed = true;
            }
        });

        clearTableButton.setOnAction(event ->
        {
            for(int i = 0; i < stateDataArrayList.size(); i++)
                mainTableContainerObservableList.clear();
            isInfoDisplayed = false;
        });


        categoryChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, number2) -> {
            productChoiceOL.clear();
            String category = categoryChoiceBox.getItems().get((Integer) number2);
            HashSet<String> tmpSet = new HashSet<>();
            for (Object o : importedProductDataCategoryList.entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                if (pair.getValue().equals(category))
                    tmpSet.add(pair.getKey().toString());
            }
            productChoiceOL.addAll(tmpSet);
        });


        productChoiceBox.setOnAction(event ->
        {
            ImportedProductData ip = new ImportedProductData();
            for(ImportedProductData ip2 : importedProductDataArrayList)
            {
                if(ip2.getProductName().equals(productChoiceBox.getValue()))
                    ip = ip2;
            }
            if(ip.getProductValue() != -50000)
            priceInputBox.setText(Float.toString(ip.getProductValue()));

        });
    }



    private void clearObservableList()
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
