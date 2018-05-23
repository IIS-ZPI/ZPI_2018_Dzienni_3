package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DataImporter {

    public void importData(ObservableList<State> statesList, ArrayList<StateData> rawData){

        for(int i=0; i<rawData.size(); i++){
            statesList.add(new State(rawData.get(i).getStateName(),i));
        }
    }

}
