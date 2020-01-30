package prop;

import enums.Browser;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertieLoader {

    private static Properties properties = new Properties();
    static String propFileName = "conf.properties";

        public static String load(String propriedade)   {
            InputStream inputStream = null;

            try {
                inputStream = PropertieLoader.class.getClassLoader().getResourceAsStream(propFileName);

                if (inputStream != null) {
                    properties.load(inputStream);
                } else {
                    throw new FileNotFoundException("Arquivo prop '" + propFileName + "' Não encontrado no classpath");
                }

            } catch (Exception e) {
                System.out.println("Excessão: " + e);
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return properties.getProperty(propriedade);
        }

    public static WebDriver getBrowser()   {
        var prop = load(ConstantsProperties.BROWSER);

        if(prop.equalsIgnoreCase("CHROME"))
            return  Browser.CHROME.retornaBrowser();

        else if(prop.equalsIgnoreCase("GRIDLOCALCHROME")){
            return Browser.GRIDLOCALCHROME.retornaBrowser();
        }

        return Browser.CHROME.retornaBrowser();
    }

}
