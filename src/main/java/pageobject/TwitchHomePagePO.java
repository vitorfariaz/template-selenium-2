package pageobject;

import selenium.SeleniumAbstraction;
import org.openqa.selenium.WebElement;

public class TwitchHomePagePO extends SeleniumAbstraction {

    public TwitchHomePagePO( ) { }

    protected WebElement entrar(){
        return weX("//button[@data-test-selector='anon-user-menu__login-button']");
    }

    protected WebElement cadastrese() {
        return weX("//button[@data-test-selector='anon-user-menu__sign-up-button']");
    }

    protected WebElement campoUsuarioLogin(){
        return  weX("//input[@id='login-username']");
    }
    protected WebElement campoSenhaLogin(){
        return  weX("//input[@id='password-input']");
    }
    protected WebElement campoLogarLogin(){
        return weX("//button[@data-a-target='passport-login-button']");
    }

    protected WebElement primeiroVideoHomePage(){
        return weX("//div[@data-a-target='player-overlay-click-handler']");
    }
    protected WebElement botaoBits(){
        return weX("//button[@data-a-target='bits-button']");
    }
    protected WebElement botaoAdquiraBits(){
        return weX("//button[@data-a-target='get-bits-button']");
    }
    protected WebElement botaoAssistaAnuncio(){
        return weX("//button[@data-a-target='bits-watch-ad']");
    }
    protected WebElement botaoAceitarTermosBits(){
        return weX("//button[@data-a-target='bits-agree-wateb-terms']");

    }
}
