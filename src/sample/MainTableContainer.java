package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class MainTableContainer
{

    private final SimpleStringProperty stateName;
    private final SimpleDoubleProperty tax;
    private final SimpleDoubleProperty price;
    private final SimpleDoubleProperty priceAfterTaxing;
    private final SimpleDoubleProperty difference;
    private boolean isProperlyParsed = true;

    public MainTableContainer(String stateName,
                              double tax, String price)
    {
        Double parsedPrice = 0.0;
        this.stateName = new SimpleStringProperty(stateName);
        this.tax = new SimpleDoubleProperty(tax);
        try
        {
            parsedPrice = Double.parseDouble(price);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Wrong number format.");
            isProperlyParsed = false;
        }
        this.price = new SimpleDoubleProperty(parsedPrice);
        this.priceAfterTaxing = new SimpleDoubleProperty(parsedPrice + parsedPrice*tax);
        this.difference = new SimpleDoubleProperty((parsedPrice + parsedPrice * tax) - parsedPrice);
    }

    public String getStateName() {
        return stateName.get();
    }

    public SimpleStringProperty stateNameProperty() {
        return stateName;
    }

    public double getTax() {
        return tax.get();
    }

    public SimpleDoubleProperty taxProperty() {
        return tax;
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public double getPriceAfterTaxing() {
        return priceAfterTaxing.get();
    }

    public SimpleDoubleProperty priceAfterTaxingProperty() {
        return priceAfterTaxing;
    }

    public double getDifference() {
        return difference.get();
    }

    public SimpleDoubleProperty differenceProperty() {
        return difference;
    }
}
