package tasks;

import org.openqa.selenium.Keys;
import pageobject.GooglePO;

public class GoogleTask extends GooglePO {
    private GoogleTask() {
    }
    public static GoogleTask build() {
        return new GoogleTask();
    }

    public GoogleTask accessGoogle(){
        driver.get("https://google.com");
        return this;
    }

    public GoogleTask search(String texto) {
        pesquisar().sendKeys(texto);
        pesquisar().sendKeys(Keys.ENTER);
        return this;
    }

}
