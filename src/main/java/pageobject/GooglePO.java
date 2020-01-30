package pageobject;

import org.openqa.selenium.WebElement;
import selenium.SeleniumAbstraction;

public class GooglePO extends SeleniumAbstraction {


    protected WebElement pesquisar(){
        return weX("//input[@aria-label='Pesquisar']");
    }

}
