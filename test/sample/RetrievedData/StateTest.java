package sample.RetrievedData;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StateTest {

	private State state;

    @Before
    public void doBeforeTest() {
    	state = new State("California",5);
    }

    @After
    public void doAfterTest() {
        state = null;
    }
    @Test
    public void checkGetStateNameIsNotNull() {
        assertNotNull(state.getStateName());
    }
    @Test
    public void checkgetIdIsNotNull() {
        assertNotNull(state.getId());
    }
}
