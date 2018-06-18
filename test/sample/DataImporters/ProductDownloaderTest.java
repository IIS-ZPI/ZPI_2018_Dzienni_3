package sample.DataImporters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ProductDownloaderTest {
    private ProductDownloader productDownloader;

    @Before
    public void initFields() {
        productDownloader = new ProductDownloader("http://pkapust.kis.p.lodz.pl/ZPI/product_list.csv");
    }


    @Test(timeout = 100)
    public void downloadTimeTest() {
        productDownloader.downloadProductList();
    }

    @Test
    public void importedProductDataIsNotNull() {
        assertNotNull(productDownloader.getImportedProductData());
    }

    @Test
    public void productWithCategoryIsNotNull() {
        assertNotNull(productDownloader.getProductWithCategory());
    }
}