package sample;

import javafx.beans.property.SimpleStringProperty;
import sun.security.ssl.Debug;

public class AddedProduct {
    private final SimpleStringProperty addedProductName;
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
