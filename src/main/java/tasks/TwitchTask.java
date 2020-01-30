package tasks;

import org.openqa.selenium.Keys;
import pageobject.TwitchHomePagePO;
import prop.PropertieLoader;

public class TwitchTask extends TwitchHomePagePO {

    private TwitchTask() {
    }

    public static TwitchTask build( ){
        return new TwitchTask();
    }

    private static String URL = "https://www.twitch.tv/skipnholive";

    public TwitchTask accessTwitch(){
        driver.get(URL);
        return this;
    }

    public TwitchTask login(){
        entrar().click();
        campoUsuarioLogin().sendKeys(PropertieLoader.load("user"));
        campoSenhaLogin().sendKeys(PropertieLoader.load("pwd"));
        campoSenhaLogin().sendKeys(Keys.ENTER);
        return this;
    }

    public TwitchTask acessarVisualizacaoDeAdBits(){
        botaoBits().click();
        botaoAdquiraBits().click();
        botaoAssistaAnuncio().click();
        botaoAceitarTermosBits().click();
        return this;
    }



}
