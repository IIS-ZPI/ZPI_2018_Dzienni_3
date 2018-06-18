package sample.DataImporters;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DataDownloaderTest {
    private DataDownloader dataDownloader;

    @Before
    public void doBeforeTest() {
        dataDownloader = new DataDownloader();
    }

    @After
    public void doAfterTest() {
        dataDownloader = null;
    }

    @Test
    public void checkDownloadedDataIsNotNull() {
        assertNotNull(dataDownloader.DownloadData());
    }

    @Test
    public void checkExtractForNullValue() {
        assertEquals("", dataDownloader.extractTax(null));
    }

    @Test
    public void checkExtractEmptyStringlValue() {
        assertEquals("", dataDownloader.extractTax(""));
    }
}