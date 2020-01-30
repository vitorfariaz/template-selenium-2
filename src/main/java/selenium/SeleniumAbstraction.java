package selenium;

import base.BaseDriver;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import prop.ConstantsProperties;
import prop.PropertieLoader;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumAbstraction extends BaseDriver {

    public WebDriverWait wWait;
    static long timeout = Long.parseLong(PropertieLoader.load(ConstantsProperties.TIME_OUT_SECONDS));

    public SeleniumAbstraction() {
        this.wWait = new WebDriverWait(driver, timeout);
    }

    private WebElement findElement(By by) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        return driver.findElement(by);
    }

    private List<WebElement> findElements(By by) {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        return driver.findElements(by);
    }

    private WebElement waitForElement(By by) {
        wait(by);
        return driver.findElement(by);
    }

    private void wait(By by) {
        wWait.until(ExpectedConditions.presenceOfElementLocated(by));
        wWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private boolean isElementDisplayed(By by) {
        try {
            return findElement(by).isDisplayed();
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    private void click(WebElement webElement) {
        if (webElement != null) {
//       wait(webElement);
            webElement.click();
        } else {
            System.out.println("webElement null");
        }
    }

    private void clear(WebElement webElement) {
        if (webElement != null) {
            webElement.clear();
        } else {
            System.out.println("webElement null");
        }
    }

    private void doubleClick(WebElement webElement) {
        Actions action = new Actions(driver);
        action.doubleClick(webElement).perform();
    }


    private void sendKeys(WebElement webElement, CharSequence charSequence) {
        if (webElement != null) {
            webElement.sendKeys(charSequence);
        } else {
            System.out.println("sendKeys null");
        }
    }

    private String getText(WebElement webElement) {
        if (webElement != null) {
            String text = webElement.getText();
            if (StringUtils.isNoneEmpty(text)) {
                return text;
            } else {
                System.out.println("getText text null");
            }
        } else {
            System.out.println("getText webElement null");
        }
        return null;
    }

    private void goFrame(String frame) {
        driver.switchTo().frame(frame);
    }

    private void selectByValue(WebElement webElement, String string) {
        Select combobox = new Select(webElement);
        combobox.selectByValue(string);
    }

    private WebElement weC(String cssSelector) {
        wait(By.cssSelector(cssSelector));
        return driver.findElement(By.cssSelector(cssSelector));
    }

    private WebElement weI(String id) {
        wait(By.id(id));
        return driver.findElement(By.id(id));
    }

    protected WebElement weX(String xpathExpression) {
        wait(By.xpath(xpathExpression));
        return driver.findElement(By.xpath(xpathExpression));
    }

    private WebElement we(By by) {
        wait(by);
        return driver.findElement(by);
    }

    private By by(String xpathExpression) {
        return By.xpath(xpathExpression);
    }

    private By byC(String cssSelector) {
        return By.cssSelector(cssSelector);
    }

    private void setAttributeValue(String idElemento, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String scriptSetAttrValue = "document.getElementById('" + idElemento+ "').value = '"+ value + "';";

        js.executeScript(scriptSetAttrValue);
    }

}
