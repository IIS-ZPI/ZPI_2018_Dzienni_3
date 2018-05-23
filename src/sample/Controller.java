package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Controller {

    @FXML
    private ChoiceBox productChoice;

    @FXML
    private TextField priceField;

    @FXML
    private TableView statesTable;

    @FXML
    private TableColumn statesColumn;

    //arraylisty troche inny bo javafx,
    private ObservableList<String> productObservableList = FXCollections.observableArrayList();
    private ObservableList<State> statesObservableList = FXCollections.observableArrayList();
    private ArrayList<StateData> data = new ArrayList<>();

    public void initialize(){
        productChoice.setItems(productObservableList);

        //nazwa "stateName" jest powiązana z klasą State, tabele wymagaja innych typow niz String do rozpoznawania kolumn
        statesColumn.setCellValueFactory(new PropertyValueFactory<>("stateName"));
        statesTable.setItems(statesObservableList);

        //dodanie przykladowych danych
        productObservableList.add("SAMPLE PRODUCT");
        //statesObservableList.add(new State("SAMPLE STATE"));

        DataDownloader dataDownloader = new DataDownloader();
        data = dataDownloader.DownloadData();

        DataImporter dataImporter =new DataImporter();
        dataImporter.importData(statesObservableList,data);
    }
}
