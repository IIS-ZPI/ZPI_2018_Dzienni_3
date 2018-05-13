package sample;

import javafx.beans.property.SimpleStringProperty;

public class State {
    private final SimpleStringProperty stateName;

    public State(String stateName) {
        this.stateName = new SimpleStringProperty(stateName);
    }

    public String getStateName() {
        return stateName.get();
    }

    public void setStateName(String stateName) {
        this.stateName.set(stateName);
    }
}
