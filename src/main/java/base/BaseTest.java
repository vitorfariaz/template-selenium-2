package base;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import prop.ConstantsProperties;
import prop.PropertieLoader;

public class BaseTest extends BaseDriver {
    protected static EyesRunner runner;
    protected static Eyes eyes;
    protected static BatchInfo batch;

    @BeforeClass
    public static void setBatch() {
        // Must be before ALL tests (at Class-level)
        batch = new BatchInfo("Name of the batch");
    }

    @Before
    public void beforeMethod() {
        // Initialize the Runner for your test.
        runner = new ClassicRunner();
        // Initialize the eyes SDK
        eyes = new Eyes(runner);
        // Set your personal Applitols API Key from your environment variables.
        eyes.setApiKey(ConstantsProperties.API_KEY);
        // set batch name
        eyes.setBatch(batch);

        eyes.open(driver, "Google", "Google search Test"
                ,new RectangleSize(Integer.parseInt(PropertieLoader.load(ConstantsProperties.WIDTH_SIZE_SCREEN))
                ,Integer.parseInt(PropertieLoader.load(ConstantsProperties.HEIGTH_SIZE_SCREEN))));
    }

    @After
    public void afterEach() {
        if (driver != null)
            driver.quit();

        // If the test was aborted before eyes.close was called,
        //  ends the test as aborted.
        eyes.abortIfNotClosed();
        // Wait and collect all test results
        TestResultsSummary allTestResults = runner.getAllTestResults();
        // Print results
        System.out.println(allTestResults);
    }

}