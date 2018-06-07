package sample;

import javafx.beans.property.SimpleStringProperty;
import sun.security.ssl.Debug;

public class AddedProduct {
    private final SimpleStringProperty addedProductName;
    private final SimpleStringProperty testProductName;
    private double calculatedValue;
    private boolean isProperlyParsed = true;

    public AddedProduct(String addedProductName)
    {
        this.addedProductName = new SimpleStringProperty("19");
        /*
        try
        {
            this.calculatedValue = Double.parseDouble(addedProductName);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Wrong number format.");
            isProperlyParsed = false;
        }
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
