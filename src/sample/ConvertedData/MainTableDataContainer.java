package sample.ConvertedData;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.DecimalFormat;

public class MainTableDataContainer
{
    private final SimpleStringProperty stateName;
    private final SimpleDoubleProperty tax;
    private final SimpleDoubleProperty price;
    private final SimpleDoubleProperty minimumDesiredMargin;
    private final SimpleFloatProperty marginForProduct;
    private final SimpleDoubleProperty priceBeforeTaxingSDP;
    private final SimpleDoubleProperty endPrice;
    private final SimpleStringProperty earnings;
    private boolean isProperlyParsed = true;

    public MainTableDataContainer(String stateName,
                                  double tax, double basePrice, double margin,
                                  String price)
    {
        Double endPrice = 0.0;
        this.stateName = new SimpleStringProperty(stateName);
        this.tax = new SimpleDoubleProperty(tax);
        try
        {
            endPrice = Double.parseDouble(price);
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Wrong number format.");
            isProperlyParsed = false;
        }


        this.endPrice = new SimpleDoubleProperty(endPrice);
        double priceWithMarginBeforeTaxing = endPrice - endPrice * tax;
        float marginForCurrentEndPrice = (float)(priceWithMarginBeforeTaxing - basePrice);
        double minimumDesiredMrg = basePrice * margin;
        double earnings = priceWithMarginBeforeTaxing - (basePrice);

        this.priceBeforeTaxingSDP = new SimpleDoubleProperty(priceWithMarginBeforeTaxing);
        this.marginForProduct = new SimpleFloatProperty(marginForCurrentEndPrice);
        this.minimumDesiredMargin = new SimpleDoubleProperty(minimumDesiredMrg);
        if(earnings < 0)
            this.earnings = new SimpleStringProperty("Na minusie (" + earnings + ")");
        else if (earnings < minimumDesiredMrg)
            this.earnings = new SimpleStringProperty("Niewystarczający zarobek (" + earnings + ")");
        else
            this.earnings = new SimpleStringProperty("Zarobek: " + earnings);
        this.price = new SimpleDoubleProperty(basePrice);
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

    public double getPriceBeforeTaxingSDP() {
        return priceBeforeTaxingSDP.get();
    }

    public SimpleDoubleProperty priceBeforeTaxingSDPProperty() {
        return priceBeforeTaxingSDP;
    }

    public double getEndPrice() {
        return endPrice.get();
    }

    public SimpleDoubleProperty endPriceProperty() {
        return endPrice;
    }

    public double getMarginForProduct() {
        return marginForProduct.get();
    }

    public SimpleFloatProperty marginForProductProperty() {
        return marginForProduct;
    }

    public void setMarginForProduct(float marginForProduct) {
        this.marginForProduct.set(marginForProduct);
    }

    public String getEarnings() {
        return earnings.get();
    }

    public SimpleStringProperty earningsProperty() {
        return earnings;
    }

    public double getMinimumDesiredMargin() {
        return minimumDesiredMargin.get();
    }

    public SimpleDoubleProperty minimumDesiredMarginProperty() {
        return minimumDesiredMargin;
    }
}
