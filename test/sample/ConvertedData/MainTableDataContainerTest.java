package sample.ConvertedData;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTableDataContainerTest {
    MainTableDataContainer mainTableDataContainer;

    @Before
    public void doBeforeTest() {
    }

    @Test
    public void checkEndPriceIsEqualZero() {
        mainTableDataContainer = new MainTableDataContainer("a", 20, 10, 5, "price");
        assertEquals(0, mainTableDataContainer.getEndPrice(), 0.01);
    }

    @Test
    public void checkIfParsingIsCorrect() {
        mainTableDataContainer = new MainTableDataContainer("a", 20, 10, 5, "15");
        assertEquals(15, mainTableDataContainer.getEndPrice(), 0.01);
    }


}