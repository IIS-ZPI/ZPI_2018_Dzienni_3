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
        this.addedProductName = new SimpleStringProperty(addedProductName);
        try
        {
            this.calculatedValue = Double.parseDouble(addedProductName);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Wrong number format.");
            isProperlyParsed = false;
        }
        this.testProductName = new SimpleStringProperty("140");
    }

    public String getTestProductName() {
        return testProductName.get();
    }

    public String getAddedProductName() {
        return addedProductName.get();
    }

    public void setStateName(String addedProductName) {
        this.addedProductName.set(addedProductName);
    }

    public boolean getAssignmentStatus()
    {
        return isProperlyParsed;
    }

    public double getValue()
    {
        return calculatedValue;
    }
}
