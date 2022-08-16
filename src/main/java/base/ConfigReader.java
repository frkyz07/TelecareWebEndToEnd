package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class ConfigReader {
    public static Properties prop;
    // we are creating a method to get our properties from our file
    public static String getProperty(String key){
        try{
            prop = new Properties();
            // System.getProperties("user.dir")
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")+"/src/main/resources/data.properties");

            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }
    public static String getPropertyAssertion(String key){
        try{
            prop = new Properties();
            // System.getProperties("user.dir")
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir")+"/src/main/resources/assertion.properties");

            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }

}