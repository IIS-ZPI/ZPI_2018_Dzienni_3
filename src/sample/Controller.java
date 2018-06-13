package sample;

import com.sun.xml.internal.ws.wsdl.writer.document.Import;
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
    private TableColumn<MainTableContainer, String> stateTableColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> taxTableColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> valueTableColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> sumTableColumn;

    @FXML
    private TableColumn<MainTableContainer, Float> differenceTableColumn;

    boolean isInfoDisplayed = false;

    // these two arraylists are neccessary for filling ObservableLists for buttons
    private ArrayList<ImportedProductData> importedProductDataArrayList = new ArrayList<>();
    private ArrayList<StateData> stateDataArrayList = new ArrayList<>();

    private ObservableList<String> categoryChoiceOL = FXCollections.observableArrayList();
    private ObservableList<String> productChoiceOL = FXCollections.observableArrayList();
    private ObservableList<MainTableContainer> mainTableContainerObservableList = FXCollections.observableArrayList();

    private ObservableList<ImportedProduct> importedProductDataObservableList = FXCollections.observableArrayList();
    private ObservableList<State> statesObservableList = FXCollections.observableArrayList();



    /*
    state, podatek, wartość bez podatku, wartość z podatkiem, ile zarabiasz
     */

    public void initialize()
    {
        /*  GENERAL ALGORITHM:
            We need one ObservableList for the main table
            from which table columns will be able to get their data from.
            Upon choosing a category, product, inputting a price and pressing the addProductButton,
            the ObservableList must be filled with as many rows
            as many states there are present in the stateDataArrayList.

            importedProductDataArrayList and stateDataArrayList store raw data,
            retrieved straight from the source (Wikipedia/.csv file).
            Since there is no real need for state info to have their own ObservableList,
            it will be safe to delete it,
            as long as the new class holding the data for the main TableView will be implemented.
         */


        // retrieve list of states and tax values
        ProductDownloader product = new ProductDownloader("http://pkapust.kis.p.lodz.pl/ZPI/product_list.csv");
        product.downloadProductList();
        importedProductDataArrayList = product.getImportedProductData();

        DataDownloader dataDownloader = new DataDownloader();
        DataImporter dataImporter = new DataImporter();
        stateDataArrayList = dataDownloader.DownloadData();
        dataImporter.importData(statesObservableList, stateDataArrayList);
        dataImporter.importProductData(importedProductDataObservableList, importedProductDataArrayList);
      
       /*From DKaito ver.
        DataDownloader dataDownloader = new DataDownloader();
        data = dataDownloader.DownloadData();

        System.out.println(data.get(0).getStateName() + " groce "+data.get(0).getTaxForProductType("Groceries"));

        DataImporter dataImporter =new DataImporter();
        dataImporter.importData(statesObservableList,data);
      */
      

        clearObservableList();

        categoryChoiceBox.setItems(categoryChoiceOL);
        productChoiceBox.setItems(productChoiceOL);


        mainTableView.setItems(mainTableContainerObservableList);


        stateTableColumn.setCellValueFactory(new PropertyValueFactory<>("stateName"));
        taxTableColumn.setCellValueFactory(new PropertyValueFactory<>("tax"));
        valueTableColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        sumTableColumn.setCellValueFactory(new PropertyValueFactory<>("priceAfterTaxing"));
        differenceTableColumn.setCellValueFactory(new PropertyValueFactory<>("difference"));

        mainTableView.getColumns().setAll(stateTableColumn, taxTableColumn, valueTableColumn, sumTableColumn, differenceTableColumn);

        addProductButton.setOnAction(event ->
        {
            if(isInfoDisplayed == false)
            {
                for(int i = 0; i < stateDataArrayList.size(); i++)
                    mainTableContainerObservableList.add(new MainTableContainer(stateDataArrayList.get(i).getStateName(),
                            stateDataArrayList.get(i).getBaseTaxConverted(), priceInputBox.getText()));
                isInfoDisplayed = true;
            }
        });

        clearTableButton.setOnAction(event ->
        {
            for(int i = 0; i < stateDataArrayList.size(); i++)
                mainTableContainerObservableList.clear();
            isInfoDisplayed = false;
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
