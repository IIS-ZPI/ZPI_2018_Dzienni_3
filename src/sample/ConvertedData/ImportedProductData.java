package sample.ConvertedData;

public class ImportedProductData
{
    private String productName;
    private String productCategory;
    private float productValue;

    public ImportedProductData(String productName, String productCategory, String productValue)
    {
        this.productName = productName;
        this.productCategory = productCategory;
        this.productValue = Float.parseFloat(productValue);
    }

    // this constructor is merely for validity-checking purposes
    public ImportedProductData()
    {
        this.productValue = -50000;
    }

    @Override
    public String toString(){
        return productName + " " + productCategory + " " + productValue;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public float getProductValue() {
        return productValue;
    }


}
