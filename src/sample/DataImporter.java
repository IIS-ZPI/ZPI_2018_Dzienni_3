package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DataImporter {

    public void importData(ObservableList<State> statesList, ArrayList<StateData> rawData){

        for(int i=0; i<rawData.size(); i++){
            statesList.add(new State(rawData.get(i).getStateName(),i));
        }
    }

    public void importProductData(ObservableList<ImportedProduct> ipol, ArrayList<ImportedProductData> ipal)
    {
        for(int i = 0; i < ipal.size(); i++)
        {
            ipol.add(new ImportedProduct(ipal.get(i).getProductName(), ipal.get(i).getProductCategory(), ipal.get(i).getProductValue()));
        }
    }

}
