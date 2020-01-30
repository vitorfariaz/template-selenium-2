package base;

import org.openqa.selenium.WebDriver;
import prop.PropertieLoader;

public class BaseDriver {
    protected static final WebDriver driver = PropertieLoader.getBrowser();
}
