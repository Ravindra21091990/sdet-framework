package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private final Properties prop;

    public ConfigReader(){
        try{
            prop = new Properties();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            if (inputStream == null) {
                throw new RuntimeException("Unable to load config.properties from classpath");
            }
            prop.load(inputStream);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public String getProperty(String key){

        return System.getProperty(key, prop.getProperty(key));
    }
}
