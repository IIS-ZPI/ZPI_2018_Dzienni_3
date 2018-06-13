package sample;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class MainTableContainer
{
    private double margin;
    private final SimpleStringProperty stateName;
    private final SimpleDoubleProperty tax;
    private final SimpleDoubleProperty price;
    private final SimpleDoubleProperty minimumDesiredMargin;
    private final SimpleDoubleProperty marginForProduct;
    private final SimpleDoubleProperty priceBeforeTaxingSDP;
    private final SimpleDoubleProperty endPrice;
    private final SimpleDoubleProperty earnings;
    private boolean isProperlyParsed = true;

    public MainTableContainer(String stateName,
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
        /*
        margin dictates how much I want to earn on each product
        I need to calculate how much I will earn (or lose) for each product sold in each state
         */

        /*
        kolejno:
        cena w sklepie
        cena przed nałożeniem podatku (cena bazowa + marża)
        zakładana marża dla aktualnej ceny
        minimalna marża dla aktualnego produktu (basePrice * margin)
        zarobek (marża uzyskana - minimumDesiredMargin)
         */

        this.endPrice = new SimpleDoubleProperty(endPrice);
        double priceWithMarginBeforeTaxing = endPrice - endPrice * tax;
        double marginForCurrentEndPrice = priceWithMarginBeforeTaxing - basePrice;
        double minimumDesiredMrg = basePrice * margin;

        System.out.println("Full price: " + priceWithMarginBeforeTaxing + "\nMargin for this price: " + marginForCurrentEndPrice + "\n");

        double earnings = priceWithMarginBeforeTaxing - (basePrice);


        this.priceBeforeTaxingSDP = new SimpleDoubleProperty(priceWithMarginBeforeTaxing);
        this.marginForProduct = new SimpleDoubleProperty(marginForCurrentEndPrice);
        this.minimumDesiredMargin = new SimpleDoubleProperty(minimumDesiredMrg);
        this.earnings = new SimpleDoubleProperty(earnings);
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

    public SimpleDoubleProperty marginForProductProperty() {
        return marginForProduct;
    }

    public void setMarginForProduct(double marginForProduct) {
        this.marginForProduct.set(marginForProduct);
    }

    public double getEarnings() {
        return earnings.get();
    }

    public SimpleDoubleProperty earningsProperty() {
        return earnings;
    }

    public double getMinimumDesiredMargin() {
        return minimumDesiredMargin.get();
    }

    public SimpleDoubleProperty minimumDesiredMarginProperty() {
        return minimumDesiredMargin;
    }


    public double getMargin() {
        return margin;
    }

}
