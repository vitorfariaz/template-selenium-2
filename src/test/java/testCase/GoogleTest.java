package testCase;

import base.BaseTest;
import org.junit.Test;
import tasks.GoogleTask;

public class GoogleTest extends BaseTest {

    @Test
    public void searchGoogleTest()   {
        GoogleTask.build()
                .accessGoogle()
                .search("Testing search google");

        //take Screenshot to applitools analise
        eyes.checkWindow("Screen google Search");

          // End the test.
        eyes.closeAsync();
    }

}
