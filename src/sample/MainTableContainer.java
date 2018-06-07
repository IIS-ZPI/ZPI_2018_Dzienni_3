package sample;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class MainTableContainer
{

    private final SimpleStringProperty stateName;
    private final SimpleFloatProperty tax;
    private final SimpleFloatProperty price;
    private final SimpleFloatProperty priceAfterTaxing;
    private final SimpleFloatProperty difference;


    public MainTableContainer(String stateName,
                              float tax, float price)
    {
        this.stateName = new SimpleStringProperty(stateName);
        this.tax = new SimpleFloatProperty(tax);
        this.price = new SimpleFloatProperty(price);
        this.priceAfterTaxing = new SimpleFloatProperty(price + price*tax);
        this.difference = new SimpleFloatProperty((price + price*tax) - price);
    }

    public String getStateName() {
        return stateName.get();
    }

    public SimpleStringProperty stateNameProperty() {
        return stateName;
    }

    public float getTax() {
        return tax.get();
    }

    public SimpleFloatProperty taxProperty() {
        return tax;
    }

    public float getPrice() {
        return price.get();
    }

    public SimpleFloatProperty priceProperty() {
        return price;
    }

    public float getPriceAfterTaxing() {
        return priceAfterTaxing.get();
    }

    public SimpleFloatProperty priceAfterTaxingProperty() {
        return priceAfterTaxing;
    }

    public float getDifference() {
        return difference.get();
    }

    public SimpleFloatProperty differenceProperty() {
        return difference;
    }
}
