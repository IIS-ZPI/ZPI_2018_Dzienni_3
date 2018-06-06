package sample;

import javafx.beans.property.SimpleStringProperty;

public class State {
    private final SimpleStringProperty stateName;
    private int id;

    public State(String stateName, int id) {
        this.stateName = new SimpleStringProperty(stateName);
        this.id = id;
    }

    public String getStateName() {
        return stateName.get();
    }

    public void setStateName(String stateName) {
        this.stateName.set(stateName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}