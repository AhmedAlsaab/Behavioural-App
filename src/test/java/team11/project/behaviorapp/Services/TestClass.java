package team11.project.behaviorapp.Services;

/**
 * Created by c1443907 on 21/03/2018.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestClass {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);

        String message = "The result is : " + result;
        logger.info(message);

    }

}