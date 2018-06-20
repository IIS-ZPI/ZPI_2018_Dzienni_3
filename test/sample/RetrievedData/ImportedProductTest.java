package sample.RetrievedData;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class ImportedProductTest {
	
	    private ImportedProduct importedProduct;

	    @Before
	    public void doBeforeTest() {
	    	importedProduct = new ImportedProduct("produkt", "kategoria", 50);
	    }

	    @After
	    public void doAfterTest() {
	        importedProduct = null;
	    }
	    @Test
	    public void checkGetProductNameIsNotNull() {
	        assertNotNull(importedProduct.getProductName());
	    }
	    @Test
	    public void checkGetProductNamePropertyIsNotNull() {
	        assertNotNull(importedProduct.productNameProperty());
	    }
	    @Test
	    public void checkGetProductCategoryIsNotNull() {
	        assertNotNull(importedProduct.getProductCategory());
	    }
	    @Test
	    public void checkProductCategoryPropertyIsNotNull() {
	        assertNotNull(importedProduct.productCategoryProperty());
	    }
	    @Test
	    public void checkGetProductValueIsNotNull() {
	        assertNotNull(importedProduct.getProductValue());
	    }
	    @Test
	    public void checkproductValuePropertyIsNotNull() {
	        assertNotNull(importedProduct.productValueProperty());
	    }
}
