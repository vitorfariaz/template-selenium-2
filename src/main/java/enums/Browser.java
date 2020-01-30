package enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import prop.ConstantsProperties;
import prop.PropertieLoader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public enum Browser {

    CHROME {
        public WebDriver retornaBrowser() {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            long timeOutSeconds = Long.parseLong(PropertieLoader.load(ConstantsProperties.TIME_OUT_SECONDS));

            WebDriver driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(timeOutSeconds, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        }
    },
    GRIDLOCALCHROME {
        public WebDriver retornaBrowser()   {
            WebDriver driver = null;
            
            try {
                return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return driver;
        }
    };

    public abstract WebDriver retornaBrowser();

    }

