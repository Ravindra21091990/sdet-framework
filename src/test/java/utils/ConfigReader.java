package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties prop;

    public ConfigReader(){
        try{

            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key){

        return prop.getProperty(key);
    }
}
