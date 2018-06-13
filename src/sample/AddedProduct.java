package sample;

import javafx.beans.property.SimpleStringProperty;

public class AddedProduct {
    private final SimpleStringProperty addedProductName;
    private final SimpleStringProperty testProductName;
    private double calculatedValue;


    public AddedProduct(String addedProductName)
    {
        this.addedProductName = new SimpleStringProperty("19");
        /*

        */
        this.testProductName = new SimpleStringProperty("140");
    }

    public String getAddedProductName() {
        return addedProductName.get();
    }

    public SimpleStringProperty addedProductNameProperty() {
        return addedProductName;
    }

    public String getTestProductName() {
        return testProductName.get();
    }

    public SimpleStringProperty testProductNameProperty() {
        return testProductName;
    }
}
