package sample.RetrievedData;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;

public class ImportedProduct
{

    private SimpleStringProperty productName;
    private SimpleStringProperty productCategory;
    private SimpleFloatProperty productValue;

    public ImportedProduct(String productName, String productCategory, float productValue)
    {
        this.productName = new SimpleStringProperty(productName);
        this.productCategory = new SimpleStringProperty(productCategory);
        this.productValue = new SimpleFloatProperty(productValue);
    }

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory.get();
    }

    public SimpleStringProperty productCategoryProperty() {
        return productCategory;
    }

    public float getProductValue() {
        return productValue.get();
    }

    public SimpleFloatProperty productValueProperty() {
        return productValue;
    }
}