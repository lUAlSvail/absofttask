import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.lang.String.format;

public class Configuration {

    private static Properties PROPERTIES = new Properties();

    static {
        String path = "src/main/resources/config.properties";
        try {
            PROPERTIES.load(new FileInputStream(path));
        } catch (IOException e) {
            throw new Error(format("Can't open properties file at '%s' location!", path));
        }
    }

    public static String getProperty(String key){
        return PROPERTIES.getProperty(key);
    }
    public static String YOUR_EMAIL = getProperty("email");
    public static String YOUR_PASSWORD = getProperty("password");
    public static String CHROME_DRIVER = getProperty("pathToChromeDriver");
    public static String CAT = getProperty("pathToSaveScreenOfCat");
    public static String DOG = getProperty("pathToSaveScreenOfDog");
    public static String FOX = getProperty("pathToSaveScreenOfFox");
}
