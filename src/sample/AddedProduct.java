package sample;

import javafx.beans.property.SimpleStringProperty;

public class AddedProduct {
    private final SimpleStringProperty addedProductName;

    public AddedProduct(String stateName) {
        this.addedProductName = new SimpleStringProperty(stateName);
    }

    public String getAddedProductName() {
        return addedProductName.get();
    }

    public void setStateName(String addedProductName) {
        this.addedProductName.set(addedProductName);
    }
}
