package sample;

public class ImportedProduct {
    private String productName;
    private String productCategory;
    private float productValue;

    public ImportedProduct(String productName, String productCategory, String productValue) {
        this.productName = productName;
        this.productCategory = productCategory;

        this.productValue = Float.parseFloat(productValue);
    }

    @Override
    public String toString(){
        return productName + " " + productCategory + " " + productValue;
    }

    
}
