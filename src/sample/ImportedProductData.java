package sample;

public class ImportedProductData {
    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public float getProductValue() {
        return productValue;
    }

    private String productName;
    private String productCategory;
    private float productValue;

    public ImportedProductData(String productName, String productCategory, String productValue) {
        this.productName = productName;
        this.productCategory = productCategory;

        this.productValue = Float.parseFloat(productValue);
    }

    @Override
    public String toString(){
        return productName + " " + productCategory + " " + productValue;
    }

    
}
