package testCase;

import base.BaseTest;
import org.junit.Test;
import tasks.TwitchTask;


public class LoginTwitchTest extends BaseTest {

    @Test()
    public void logarTwtich()  {
        TwitchTask.build()
                .accessTwitch()
                .login();
//                .acessarVisualizacaoDeAdBits();
        //take Screenshot to applitools analise
        eyes.checkWindow("Screen google Search");

        // End the test.
        eyes.closeAsync();

    }

}





